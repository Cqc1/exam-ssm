package ssm.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import ssm.model.Class;
import ssm.model.Profession;
import ssm.model.Score;
import ssm.model.Shijuan;
import ssm.model.Student;
import ssm.model.Teacher;
import ssm.model.Yuanxi;
import ssm.service.ClassService;
import ssm.service.CourseService;
import ssm.service.ProfessionService;
import ssm.service.ScoreService;
import ssm.service.ShijuanService;
import ssm.service.StudentService;
import ssm.service.YuanxiService;
@Controller
@RequestMapping(value = "/score")
public class ScoreController
{
	@Autowired
	ScoreService scoreService;
	@Autowired
	CourseService courseService;
	@Autowired
	ClassService classService;
	@Autowired
	ShijuanService shijuanService;
	@Autowired
	ProfessionService professionService;
	@Autowired
	StudentService studentService;
	@Autowired
	YuanxiService yuanxiService;
	@RequestMapping(value = "/ScoInfo")//查询所有信息
	public ModelAndView ScoInfo(Model model) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		List list=scoreService.findAll();
		model.addAttribute("sco",list);
		mv.setViewName("/behind/manager_sco");
		return mv;
	}
	@RequestMapping(value = "/ScoDelete")//删除信息
	public ModelAndView TasDelete(Model model,@RequestParam int stuid) throws Exception{
		ModelAndView mv=new ModelAndView();
		scoreService.deleteByid(stuid);
		List list=scoreService.findAll();
		model.addAttribute("sco",list);
		mv.setViewName("/behind/manager_sco");
		return mv;
	}
	/*更新信息操作*/
	@RequestMapping(value = "/ScoUpdate_view")//跳转更新信息界面
	public ModelAndView ScoUpdate_view(Model model,@RequestParam int stuid) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=courseService.findAll();
		model.addAttribute("cou",list);
		model.addAttribute("stuid",stuid);
		mv.setViewName("/behind/up_sco");
		return mv;
	}
	@RequestMapping(value = "/ScoUpdate")//更新信息
	public ModelAndView ScoUpdate(HttpServletRequest request,HttpServletResponse response,
			Model model,Score sco) throws Exception{
		ModelAndView mv=new ModelAndView();	
		scoreService.updateByid(sco);
		List list=scoreService.findAll();
		model.addAttribute("sco",list);
		mv.setViewName("/behind/manager_sco");
		return mv;
	}
	/*查询信息操作*/
	@RequestMapping(value = "/ScoInfo_query")//模糊查询判断用户是否存在
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
	public String ScoInfo_query(String query,String type,HttpServletRequest request) throws Exception{
	    List list=scoreService.queryfind(type,query);
	    String result="error";
	    if(!list.isEmpty()) {
	    	HttpSession session = request.getSession();
            session.setAttribute("sco",list);
	    	result="success";
	    } 	    
		return result;
	}
	@RequestMapping(value = "/ScoInfo_query2")//用户存在返回信息界面
	public ModelAndView ScoInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mv=new ModelAndView();
		model.addAttribute("sco", (List) request.getAttribute("sco"));
		mv.setViewName("/behind/manager_sco");
		return mv;
	}
	/*添加信息操作*/
	@RequestMapping(value = "/ScoAdd_view")//跳转添加信息界面
	public ModelAndView ScoAdd_view(Model model,Score sco) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list1=courseService.findAll();
		List list2=classService.findAll();
		model.addAttribute("cou",list1);
		model.addAttribute("cla",list2);
		mv.setViewName("/behind/add_sco");
		return mv;
	}
	@RequestMapping(value ="/addScore")//添加信息
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
	public Score addScore(@RequestBody Score requestSco) throws Exception{		
		Score sco=requestSco;
		requestSco=scoreService.selectByMore(requestSco);
		if(requestSco==null) {
			scoreService.addScore(sco);
		}
		return requestSco;
	}
/*获取各种组合框信息*/
	@RequestMapping(value ="/getList1")           //获取一级组合框的信息（如专业） 
	public @ResponseBody Object getList() throws Exception{		
		List<Yuanxi> yuInfo1 = new ArrayList<Yuanxi>();
        List<Profession> proInfo2 = new ArrayList<Profession>();
        List<Class> claInfo2 = new ArrayList<Class>();
        yuInfo1=yuanxiService.findAll();
        proInfo2=professionService.findAll();
        claInfo2=classService.findAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("yuInfo1",yuInfo1);
        map.put("proInfo2",proInfo2);
        
        return map;
	}
	@RequestMapping(value ="/getList2")           //获取二级组合框的信息（如教师、班级） 
	public @ResponseBody Object getList2(int vals) throws Exception{		
        List<Student> stuInfo = new ArrayList<Student>();
        List<Shijuan> shijuan = new ArrayList<Shijuan>();
        HashMap<String, Object> map = new HashMap<>();
        shijuan=shijuanService.getByCouid(vals);
        stuInfo=studentService.getByClaid(vals);
        map.put("stuInfo",stuInfo);
        map.put("shijuanInfo",shijuan);
        return map;
	}
}
