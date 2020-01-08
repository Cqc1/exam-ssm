package ssm.controller;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import ssm.model.*;
import ssm.service.*;
import ssm.util.GA_exam;
import ssm.util.TestPaper;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherControll
{
	@Autowired
	TeacherService teacherService;
	@Autowired
	TeataskService teataskService;
	@Autowired
	YuanxiService yuanxiService;
	@Autowired
	TixinService tixinService;
	@Autowired
    ShijuanService shijuanService;
	@Autowired
	ShitiService shitiService;

/*---------------------------------管理员权限------------------------------*/
	@RequestMapping(value = "/TeInfo")//查询所有信息
	public ModelAndView TeInfo(Model model) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		List list=teacherService.findAll();
		model.addAttribute("teacher",list);
		mv.setViewName("/behind/manager_teacher");
		return mv;
	}
	@RequestMapping(value = "/Delete")//删除信息
	public ModelAndView Delete(Model model,@RequestParam int teaid) throws Exception{
		ModelAndView mv=new ModelAndView();
		teacherService.deleteByid(teaid);
		List list=teacherService.findAll();
		model.addAttribute("teacher",list);
		mv.setViewName("/behind/manager_teacher");
		return mv;
	}
	/*更新信息操作*/
	@RequestMapping(value = "/Update_view")//跳转更新信息界面
	public ModelAndView Update_view(Model model,@RequestParam int teaid) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=yuanxiService.findAll();
		model.addAttribute("yuanxi",list);
		model.addAttribute("teid",teaid);
		mv.setViewName("/behind/up_te");
		return mv;
	}
	@RequestMapping(value = "/Update")//更新信息
	public ModelAndView Update(HttpServletRequest request,HttpServletResponse response,
			Model model,Teacher te) throws Exception{
		ModelAndView mv=new ModelAndView();	
		teacherService.updateByid(te);
		List list=teacherService.findAll();
		model.addAttribute("teacher",list);
		mv.setViewName("/behind/manager_teacher");
		return mv;
	}
	/*查询信息操作*/
	@RequestMapping(value = "/TeInfo_query")//模糊查询判断用户是否存在
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
	public String TeInfo_query(String query,String type,HttpServletRequest request) throws Exception{
	    List list=teacherService.queryfind(type,query);
	    String result="error";
	    if(!list.isEmpty()) {
	    	HttpSession session = request.getSession();
            session.setAttribute("teacher",list);
	    	result="success";
	    } 	    
		return result;
	}
	@RequestMapping(value = "/TeInfo_query2")//用户存在返回信息界面
	public ModelAndView TeInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mv=new ModelAndView();
		model.addAttribute("teacher", (List) request.getAttribute("teacher"));
		mv.setViewName("/behind/manager_teacher");
		return mv;
	}
	/*添加信息操作*/
	@RequestMapping(value = "/Add_view")//跳转添加信息界面
	public ModelAndView Add_view(Model model,Teacher tea) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=yuanxiService.findAll();
		model.addAttribute("yuanxi",list);
		mv.setViewName("/behind/add_te");
		return mv;
	}
	@RequestMapping(value ="/addTea")//添加信息
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
	public Teacher addTea(@RequestBody Teacher requestTe) throws Exception{
		int teaid = requestTe.getTeaid();
		Teacher tea=requestTe;
		requestTe=teacherService.getById(teaid);
		if(requestTe==null) {
			teacherService.addUser(tea);
		}
		return requestTe;
	}
/*--------------------------------教师权限-------------------------------*/
	@RequestMapping(value = "/Tea_idioInfo")
	public ModelAndView Tea_idioInfo(Model model,int teaid) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		Teacher tea=teacherService.getById(teaid);
		model.addAttribute("teacher",tea);
		mv.setViewName("/teacher/teacher_info");
		return mv;
	}
	@RequestMapping(value = "/Tea_pass")   //修改密码时的验证
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
	public String Tea_pass(int teaid,String old_pass,String new_pass) throws Exception{
		Teacher tea=teacherService.getById(teaid);
		System.out.println(teaid+","+old_pass+"||"+tea.getTeapwd()+new_pass);
		String result="error";
		if(tea.getTeapwd().equals(old_pass)) {
			teacherService.updateByPass(teaid, new_pass);
	        result="success";
		}
		return result;
	}
	@RequestMapping(value = "/Tea_tasInfo")
	public ModelAndView Tea_tasInfo(Model model,int teaid) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		List<Teatask> tas=teataskService.getByteaId(teaid);
		model.addAttribute("tas",tas);
		mv.setViewName("/teacher/teacher_task");
		return mv;
	}
	@RequestMapping(value = "/teacher_pass") //跳转更新密码界面
	public ModelAndView student_passView(Model model,Object tea,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		tea=request.getAttribute("tea");
		model.addAttribute("tea",tea);
		mv.setViewName("/teacher/teacher_pass");
		return mv;
	}
/*--------------------------------教师管理模块------------------------------*/
	@RequestMapping(value = "/TxInfo")//查询所有信息
	public ModelAndView TxInfo(Model model) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/teacher_tixin");
		return mv;
	}
	/*添加信息操作*/
	@RequestMapping(value = "/TxAdd_view")//跳转添加信息界面
	public ModelAndView TxAdd_view(Model model,Tixin tx) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/add_tx");
		return mv;
	}
	@RequestMapping(value ="/addTx")//添加信息
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
	public Tixin addTx(@RequestBody Tixin requestTx) throws Exception{
		String txname = requestTx.getTixinname();
		Tixin tx=requestTx;
		requestTx=tixinService.getByNam(txname);
		if(requestTx==null) {
			tixinService.addTixin(tx);
		}
		return requestTx;
	}
	@RequestMapping(value = "/TxDelete")//删除题型信息
	public ModelAndView TxDelete(Model model,@RequestParam int txid) throws Exception{
		ModelAndView mv=new ModelAndView();
		tixinService.deleteByid(txid);
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/teacher_tixin");
		return mv;
	}

	@RequestMapping(value = "/Download")//删除题型信息
	public ModelAndView DownloadExam(Model model,@RequestParam int txid) throws Exception{
		ModelAndView mv=new ModelAndView();
		tixinService.deleteByid(txid);
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/manage_exam");
		return mv;
	}

	/*更新信息操作*/
	@RequestMapping(value = "/TxUpdate_view")//跳转更新信息界面
	public ModelAndView TxUpdate_view(Model model,@RequestParam int txid) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=tixinService.findAll();
		model.addAttribute("txid",txid);
		mv.setViewName("/teacher/up_tx");
		return mv;
	}
	@RequestMapping(value = "/txUpdate")//更新信息
	public ModelAndView txUpdate(HttpServletRequest request,HttpServletResponse response,
			Model model,Tixin tx) throws Exception{
		ModelAndView mv=new ModelAndView();	
		tixinService.updateByid(tx);
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/teacher_tixin");
		return mv;
	}

	@RequestMapping(value = "/addRadio_view")//跳转增加单选题页面
	public ModelAndView addRadio(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/teacher_radio");
		return mv;
	}

	@RequestMapping(value = "/addCheckbox_view")//增加多选题页面
	public ModelAndView addCheckbox(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/add_checkbox");
		return mv;
	}

	@RequestMapping(value = "/addJuage_view")//增加判断题页面
	public ModelAndView addJuage(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/add_juage");
		return mv;
	}

	@RequestMapping(value = "/addFill_view")//更新信息
	public ModelAndView addFill(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/add_fill");
		return mv;
	}

	@RequestMapping(value = "/addSAQ_view")//增加简答题页面
	public ModelAndView addSAQ(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=tixinService.findAll();
		model.addAttribute("tx",list);
		mv.setViewName("/teacher/add_saq");
		return mv;
	}

	@RequestMapping(value = "/GExam")//组卷页面
	public ModelAndView generateExam(Model model, int teaid) throws Exception{
		ModelAndView mv=new ModelAndView();
		List<Teatask> list=teataskService.getByteaId(teaid);
		model.addAttribute("tx1",list);
		mv.setViewName("/teacher/generate_exam");
		return mv;
	}

	@RequestMapping(value = "/GExam2")//组卷页面
	@ResponseBody
	public Solution generateExam2(@RequestBody GA_Exam_model ga, HttpServletRequest request) throws Exception{
		System.out.println("\n数据库读取和处理数据······");
		int To = Integer.parseInt(ga.getT0());
		System.out.println(To);
		String a[] = ga.getNum();
		String b[] = ga.getScore();
		int score = 0;
		int [][] Q =new int[a.length][2];
		for (int i=0; i<a.length;i++){
			for (int j=0; j<2;j++){
				if (j==0){
					Q[i][j]=Integer.parseInt(b[i]);
					score += Integer.parseInt(b[i]);
				}
				if (j==1){
					Q[i][j]=Integer.parseInt(a[i]);
				}
			}
		}
		double d_lb = Double.parseDouble(ga.getD_lb());
		double d_ub = Double.parseDouble(ga.getD_ub());
		double h_lb = Double.parseDouble(ga.getH_lb());
		double h_ub = Double.parseDouble(ga.getH_ub());
		long ft=System.currentTimeMillis();
		ArrayList<Shiti> tqList=shitiService.findAll2();
		System.out.println();
		System.out.println("用时："+(System.currentTimeMillis()-ft)/1000.0+"s");
		ArrayList<Question> qList=Shiti.getQList(tqList);
		System.out.println("\n遗传算法求解：");
		ft=System.currentTimeMillis();
		Solution bestSolution=new GA_exam(To, Q, qList, h_lb, h_ub, d_lb, d_ub).getBestSolution();
		Solution solution=bestSolution;
		HttpSession session = request.getSession();
		int length = solution.getQuestionIds().length;
		int[] shitiid = new int[length];
		for (int i=0;i<length;i++){
			shitiid[i] =solution.getQuestionIds()[i];
		}
		session.setAttribute("score", score);
		session.setAttribute("time", To);
		session.setAttribute("length",length);
		session.setAttribute("shitiid",shitiid);
		System.out.println(bestSolution.toString());
		System.out.println("算法用时："+(System.currentTimeMillis()-ft)/1000.0+"s");
		//System.out.println("\n生成测试题······");
		//ft=System.currentTimeMillis();
		//String paper=new TestPaper(To, Q, tqList, h_lb, h_ub, d_lb, d_ub, solution).toString();
		//TestPaper.writeTo(new File("./testPaper", TestPaper.getTime()+".txt"), paper);
		//System.out.println("用时："+(System.currentTimeMillis()-ft)/1000.0+"s");
		return  solution;
	}

	@RequestMapping(value = "/show_exam")//用户存在返回信息界面
	public ModelAndView ProInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session = request.getSession();
		int length = (int) session.getAttribute("length");
		int a[] = new int[length];
		String line = "考试时长："+ session.getAttribute("time") + "分钟,"+ "总分值：" + session.getAttribute("score") + "分," + "总题数："+ length + "个";
		a = (int[]) session.getAttribute("shitiid");
		List<Shiti> list[] = new List[length];
		for (int i=0; i<length;i++){
			list[i] = shitiService.getByShiTiId(a[i]);
		}

		String[] str1 = {"一.","二.","三.","四.","五.","六.","七.","八.","九."};

        List<Tixin> tixinList[]=new List[6];
        List<Tixin> tixinList2[]= new List[length];
        int j = -1;
		for (int i = 0; i <length;i++) {
		    tixinList2[i] = tixinService.getByTinXinId(list[i].get(0).getTixinid());
		    if(i != 0) {
                if (!tixinList[j].get(0).getTixinid().equals(tixinList2[i].get(0).getTixinid())) {
                    tixinList[++j] = tixinList2[i];
                    tixinList[j].get(0).setTixinname(str1[j] + tixinList[j].get(0).getTixinname());
                }
            }
            if (i == 0){
                tixinList[++j] = tixinService.getByTinXinId(list[i].get(0).getTixinid());
                tixinList[j].get(0).setTixinname( str1[j] + tixinList[j].get(0).getTixinname());
            }
        }
        model.addAttribute("tixinlist",tixinList);
		model.addAttribute("list",list);
		model.addAttribute("line", line);
		mv.setViewName("/teacher/show_exam");
		return mv;
	}

	@RequestMapping(value = "/SetExam")//组卷页面
	@ResponseBody
	public String SetExam(String query,String type,HttpServletRequest request) throws Exception{
		List list=tixinService.queryfind(type,query);
		System.out.println(query);
		String result="error";
		if(!list.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute("tixin",list);
			result="success";
		}
		return result;
	}

	@RequestMapping(value = "/GExam_query")//用户存在返回信息界面
	public ModelAndView generateExam_query(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mv=new ModelAndView();
		model.addAttribute("tixin", (List) request.getAttribute("tixin"));
		mv.setViewName("/teacher/generate_exam2");
		return mv;
	}

	@RequestMapping(value = "/MExam")//管理试卷页面
	public ModelAndView manageExam(Model model, int teaid) throws Exception{
		ModelAndView mv=new ModelAndView();
		List<Shijuan> list = shijuanService.getByTeaid(teaid);
		model.addAttribute("sj",list);
		mv.setViewName("/teacher/manage_exam");
		return mv;
	}

	@RequestMapping(value = "/UpdateExam")//管理试卷页面
	public ModelAndView updateExam(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/teacher/show_exam");
		return mv;
	}

	@RequestMapping(value = "/TestExam")//管理试卷页面
	public ModelAndView testExam(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		List<Shiti> shiti = shitiService.findAll();
		model.addAttribute("shiti",shiti);
		mv.setViewName("/teacher/testExam");
		return mv;
	}
}
