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

import ssm.model.Profession;
import ssm.model.Teacher;
import ssm.model.Teatask;
import ssm.model.Yuanxi;
import ssm.model.Class;
import ssm.model.Course;
import ssm.service.ClassService;
import ssm.service.CourseService;
import ssm.service.ProfessionService;
import ssm.service.TeacherService;
import ssm.service.TeataskService;
import ssm.service.YuanxiService;
@Controller
@RequestMapping(value = "/admin")
public class AdminController
{
		@Autowired
		YuanxiService yuanxiService;
		@Autowired
		ProfessionService professionService;
		@Autowired
		ClassService classService;
		@Autowired
		CourseService courseService;
		@Autowired
		TeataskService teataskService;
		@Autowired
		TeacherService teacherService;
/*院系管理*/
		@RequestMapping(value = "/YuxiInfo")//查询所有信息
		public ModelAndView YuxiInfo(Model model) throws Exception{
			ModelAndView mv=new ModelAndView(); 
			List list=yuanxiService.findAll();
			model.addAttribute("yuxi",list);
			mv.setViewName("/behind/manager_yuxi");
			return mv;
		}
		@RequestMapping(value = "/YuDelete")//删除信息
		public ModelAndView YuDelete(Model model,@RequestParam int yuid) throws Exception{
			ModelAndView mv=new ModelAndView();
			yuanxiService.deleteByid(yuid);
			List list=yuanxiService.findAll();
			model.addAttribute("yuxi",list);
			mv.setViewName("/behind/manager_yuxi");
			return mv;
		}
		/*更新信息操作*/
		@RequestMapping(value = "/YuUpdate_view")//跳转更新信息界面
		public ModelAndView YuUpdate_view(Model model,@RequestParam int yuid) throws Exception{
			ModelAndView mv=new ModelAndView();
			model.addAttribute("yuid",yuid);
			mv.setViewName("/behind/up_yu");
			return mv;
		}
		@RequestMapping(value = "/YuUpdate")//更新信息
		public ModelAndView YuUpdate(HttpServletRequest request,HttpServletResponse response,
				Model model,Yuanxi yu) throws Exception{
			ModelAndView mv=new ModelAndView();	
			yuanxiService.updateByid(yu);
			List list=yuanxiService.findAll();
			model.addAttribute("yuxi",list);
			mv.setViewName("/behind/manager_yuxi");
			return mv;
		}
		/*查询信息操作*/
		@RequestMapping(value = "/YuxiInfo_query")//模糊查询判断用户是否存在
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
		public String YuxiInfo_query(String query,String type,HttpServletRequest request) throws Exception{
		    List list=yuanxiService.queryfind(type,query);
		    String result="error";
		    if(!list.isEmpty()) {
		    	HttpSession session = request.getSession();
	            session.setAttribute("yuxi",list);
		    	result="success";
		    } 	    
			return result;
		}
		@RequestMapping(value = "/YuxiInfo_query2")//用户存在返回信息界面
		public ModelAndView YuxiInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
			ModelAndView mv=new ModelAndView();
			model.addAttribute("yuxi", (List) request.getAttribute("yuxi"));
			mv.setViewName("/behind/manager_yuxi");
			return mv;
		}
		/*添加信息操作*/
		@RequestMapping(value = "/YuAdd_view")//跳转添加信息界面
		public ModelAndView YuAdd_view(Model model,Yuanxi yu) throws Exception{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("/behind/add_yu");
			return mv;
		}
		@RequestMapping(value ="/addYu")//添加信息
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
		public Yuanxi addYu(@RequestBody Yuanxi requestYu) throws Exception{
			String yunam = requestYu.getYunam();
			Yuanxi yu=requestYu;
			requestYu=yuanxiService.getByNam(yunam);
			if(requestYu==null) {
				yuanxiService.addYuxi(yu);
			}
			return requestYu;
		}
/*专业管理*/
		@RequestMapping(value = "/ProInfo")//查询所有信息
		public ModelAndView ProInfo(Model model) throws Exception{
			ModelAndView mv=new ModelAndView(); 
			List list=professionService.findAll();
			System.out.println(list.isEmpty());
			model.addAttribute("pro",list);
			mv.setViewName("/behind/manager_pro");
			return mv;
		}
		@RequestMapping(value = "/ProDelete")//删除信息
		public ModelAndView ProDelete(Model model,@RequestParam int proid) throws Exception{
			ModelAndView mv=new ModelAndView();
			professionService.deleteByid(proid);
			List list=professionService.findAll();
			model.addAttribute("pro",list);
			mv.setViewName("/behind/manager_pro");
			return mv;
		}
		/*更新信息操作*/
		@RequestMapping(value = "/ProUpdate_view")//跳转更新信息界面
		public ModelAndView ProUpdate_view(Model model,@RequestParam int proid) throws Exception{
			ModelAndView mv=new ModelAndView();
			List list=yuanxiService.findAll();
			model.addAttribute("yuanxi",list);
			model.addAttribute("proid",proid);
			mv.setViewName("/behind/up_pro");
			return mv;
		}
		@RequestMapping(value = "/ProUpdate")//更新信息
		public ModelAndView ProUpdate(HttpServletRequest request,HttpServletResponse response,
				Model model,Profession pro) throws Exception{
			ModelAndView mv=new ModelAndView();	
			professionService.updateByid(pro);
			List list=professionService.findAll();
			model.addAttribute("pro",list);
			mv.setViewName("/behind/manager_pro");
			return mv;
		}
		/*查询信息操作*/
		@RequestMapping(value = "/ProInfo_query")//模糊查询判断用户是否存在
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
		public String ProInfo_query(String query,String type,HttpServletRequest request) throws Exception{
		    List list=professionService.queryfind(type,query);
		    String result="error";
		    if(!list.isEmpty()) {
		    	HttpSession session = request.getSession();
	            session.setAttribute("pro",list);
		    	result="success";
		    } 	    
			return result;
		}
		@RequestMapping(value = "/ProInfo_query2")//用户存在返回信息界面
		public ModelAndView ProInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
			ModelAndView mv=new ModelAndView();
			model.addAttribute("pro", (List) request.getAttribute("pro"));
			mv.setViewName("/behind/manager_pro");
			return mv;
		}
		/*添加信息操作*/
		@RequestMapping(value = "/ProAdd_view")//跳转添加信息界面
		public ModelAndView ProAdd_view(Model model,Profession pro) throws Exception{
			ModelAndView mv=new ModelAndView();
			List list=yuanxiService.findAll();
			model.addAttribute("yuanxi",list);
			mv.setViewName("/behind/add_pro");
			return mv;
		}
		@RequestMapping(value ="/addPro")//添加信息
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
		public Profession addPro(@RequestBody Profession requestPro) throws Exception{
			String proname = requestPro.getProname();
			Profession pro=requestPro;
			requestPro=professionService.getByNam(proname);
			if(requestPro==null) {
				professionService.addPro(pro);
			}
			return requestPro;
		}
		
/*班级管理*/
		@RequestMapping(value = "/ClaInfo")//查询所有信息
		public ModelAndView ClaInfo(Model model) throws Exception{
			ModelAndView mv=new ModelAndView(); 
			List list=classService.findAll();
			System.out.println(list.isEmpty());
			model.addAttribute("cla",list);
			mv.setViewName("/behind/manager_cla");
			return mv;
		}
		@RequestMapping(value = "/ClaDelete")//删除信息
		public ModelAndView ClaDelete(Model model,@RequestParam int classid) throws Exception{
			ModelAndView mv=new ModelAndView();
			classService.deleteByid(classid);
			List list=classService.findAll();
			model.addAttribute("cla",list);
			mv.setViewName("/behind/manager_cla");
			return mv;
		}
		/*更新信息操作*/
		@RequestMapping(value = "/ClaUpdate_view")//跳转更新信息界面
		public ModelAndView ClaUpdate_view(Model model,@RequestParam int classid) throws Exception{
			ModelAndView mv=new ModelAndView();
			List list=professionService.findAll();
			model.addAttribute("pro",list);
			model.addAttribute("classid",classid);
			mv.setViewName("/behind/up_cla");
			return mv;
		}
		@RequestMapping(value = "/ClaUpdate")//更新信息
		public ModelAndView ClaUpdate(HttpServletRequest request,HttpServletResponse response,
				Model model,Class cla) throws Exception{
			ModelAndView mv=new ModelAndView();	
			classService.updateByid(cla);
			List list=classService.findAll();
			model.addAttribute("cla",list);
			mv.setViewName("/behind/manager_cla");
			return mv;
		}
		/*查询信息操作*/
		@RequestMapping(value = "/ClaInfo_query")//模糊查询判断用户是否存在
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
		public String ClaInfo_query(String query,String type,HttpServletRequest request) throws Exception{
		    List list=classService.queryfind(type,query);
		    String result="error";
		    if(!list.isEmpty()) {
		    	HttpSession session = request.getSession();
	            session.setAttribute("cla",list);
		    	result="success";
		    } 	    
			return result;
		}
		@RequestMapping(value = "/ClaInfo_query2")//用户存在返回信息界面
		public ModelAndView ClaInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
			ModelAndView mv=new ModelAndView();
			model.addAttribute("cla", (List) request.getAttribute("cla"));
			mv.setViewName("/behind/manager_cla");
			return mv;
		}
		/*添加信息操作*/
		@RequestMapping(value = "/ClaAdd_view")//跳转添加信息界面
		public ModelAndView ClaAdd_view(Model model,Class cla) throws Exception{
			ModelAndView mv=new ModelAndView();
			List list=professionService.findAll();
			model.addAttribute("pro",list);
			mv.setViewName("/behind/add_cla");
			return mv;
		}
		@RequestMapping(value ="/addCla")//添加信息
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
		public Class addCla(@RequestBody Class requestCla) throws Exception{
			String claname = requestCla.getClaname();
			Class cla=requestCla;
			requestCla=classService.getByNam(claname);
			if(requestCla==null) {
				classService.addCla(cla);
			}
			return requestCla;
		}

/*课程管理*/
		@RequestMapping(value = "/CouInfo")//查询所有信息
		public ModelAndView CouInfo(Model model) throws Exception{
			ModelAndView mv=new ModelAndView(); 
			List list=courseService.findAll();
			model.addAttribute("cou",list);
			mv.setViewName("/behind/manager_cou");
			return mv;
		}
		@RequestMapping(value = "/CouDelete")//删除信息
		public ModelAndView CouDelete(Model model,@RequestParam int couid) throws Exception{
			ModelAndView mv=new ModelAndView();
			courseService.deleteByid(couid);
			List list=courseService.findAll();
			model.addAttribute("cou",list);
			mv.setViewName("/behind/manager_cou");
			return mv;
		}
		/*更新信息操作*/
		@RequestMapping(value = "/CouUpdate_view")//跳转更新信息界面
		public ModelAndView CouUpdate_view(Model model,@RequestParam int couid) throws Exception{
			ModelAndView mv=new ModelAndView();
			model.addAttribute("couid",couid);
			mv.setViewName("/behind/up_cou");
			return mv;
		}
		@RequestMapping(value = "/CouUpdate")//更新信息
		public ModelAndView CouUpdate(HttpServletRequest request,HttpServletResponse response,
				Model model,Course co) throws Exception{
			ModelAndView mv=new ModelAndView();	
			courseService.updateByid(co);
			List list=courseService.findAll();
			model.addAttribute("cou",list);
			mv.setViewName("/behind/manager_cou");
			return mv;
		}
		/*查询信息操作*/
		@RequestMapping(value = "/CouInfo_query")//模糊查询判断用户是否存在
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
		public String CouInfo_query(String query,String type,HttpServletRequest request) throws Exception{
		    List list=courseService.queryfind(type,query);
		    String result="error";
		    if(!list.isEmpty()) {
		    	HttpSession session = request.getSession();
	            session.setAttribute("cou",list);
		    	result="success";
		    } 	    
			return result;
		}
		@RequestMapping(value = "/CouInfo_query2")//用户存在返回信息界面
		public ModelAndView CouInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
			ModelAndView mv=new ModelAndView();
			model.addAttribute("cou", (List) request.getAttribute("cou"));
			mv.setViewName("/behind/manager_cou");
			return mv;
		}
		/*添加信息操作*/
		@RequestMapping(value = "/CouAdd_view")//跳转添加信息界面
		public ModelAndView CouAdd_view(Model model,Course co) throws Exception{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("/behind/add_cou");
			return mv;
		}
		@RequestMapping(value ="/addCou")//添加信息
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
		public Course addCou(@RequestBody Course requestCou) throws Exception{
			String couname = requestCou.getCouname();
			Course cou=requestCou;			
			requestCou=courseService.getByNam(couname);
			if(requestCou==null) {
				courseService.addCou(cou);
			}
			return requestCou;
		}
/*教学任务管理*/
		@RequestMapping(value = "/TasInfo")//查询所有信息
		public ModelAndView TasInfo(Model model) throws Exception{
			ModelAndView mv=new ModelAndView(); 
			List list=teataskService.findAll();
			model.addAttribute("tas",list);
			mv.setViewName("/behind/manager_tas");
			return mv;
		}
		@RequestMapping(value = "/TasDelete")//删除信息
		public ModelAndView TasDelete(Model model,@RequestParam int taskid) throws Exception{
			ModelAndView mv=new ModelAndView();
			teataskService.deleteByid(taskid);
			List list=teataskService.findAll();
			model.addAttribute("tas",list);
			mv.setViewName("/behind/manager_tas");
			return mv;
		}
		/*更新信息操作*/
		@RequestMapping(value = "/TasUpdate_view")//跳转更新信息界面
		public ModelAndView TasUpdate_view(Model model,@RequestParam int taskid) throws Exception{
			ModelAndView mv=new ModelAndView();
			List list=courseService.findAll();
			model.addAttribute("cou",list);
			model.addAttribute("taskid",taskid);
			mv.setViewName("/behind/up_tas");
			return mv;
		}
		@RequestMapping(value = "/TasUpdate")//更新信息
		public ModelAndView TasUpdate(HttpServletRequest request,HttpServletResponse response,
				Model model,Teatask tas) throws Exception{
			ModelAndView mv=new ModelAndView();	
			teataskService.updateByid(tas);
			List list=teataskService.findAll();
			model.addAttribute("tas",list);
			mv.setViewName("/behind/manager_tas");
			return mv;
		}
		/*查询信息操作*/
		@RequestMapping(value = "/TasInfo_query")//模糊查询判断用户是否存在
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
		public String TasInfo_query(String query,String type,HttpServletRequest request) throws Exception{
		    List list=teataskService.queryfind(type,query);
		    String result="error";
		    if(!list.isEmpty()) {
		    	HttpSession session = request.getSession();
	            session.setAttribute("tas",list);
		    	result="success";
		    } 	    
			return result;
		}
		@RequestMapping(value = "/TasInfo_query2")//用户存在返回信息界面
		public ModelAndView TasInfo_query2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
			ModelAndView mv=new ModelAndView();
			model.addAttribute("tas", (List) request.getAttribute("tas"));
			mv.setViewName("/behind/manager_tas");
			return mv;
		}
		/*添加信息操作*/
		@RequestMapping(value = "/TasAdd_view")//跳转添加信息界面
		public ModelAndView TasAdd_view(Model model,Teatask tas) throws Exception{
			ModelAndView mv=new ModelAndView();
			List list=courseService.findAll();
			model.addAttribute("cou",list);
			mv.setViewName("/behind/add_tas");
			return mv;
		}
		@RequestMapping(value ="/addTask")//添加信息
		@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
		public Teatask addTask(@RequestBody Teatask requestTas) throws Exception{		
			Teatask tas=requestTas;
			/*System.out.println(tas.getTerm());
			System.out.println(tas.getTeaid());
			System.out.println(tas.getCouid());
			System.out.println(tas.getClassid());*/
			requestTas=teataskService.selectByMore(requestTas);
			if(requestTas==null) {
				teataskService.addTask(tas);
			}
			return requestTas;
		}
/*获取各种组合框信息*/
		@RequestMapping(value ="/getList1")           //获取一级组合框的信息（如院系、专业） 
		public @ResponseBody Object getList() throws Exception{		
			List<Yuanxi> yuInfo1 = new ArrayList<Yuanxi>();
	        List<Profession> proInfo2 = new ArrayList<Profession>();
	        yuInfo1=yuanxiService.findAll();
	        proInfo2=professionService.findAll();
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("yuInfo1",yuInfo1);
	        map.put("proInfo2",proInfo2);
	        return map;
		}
		@RequestMapping(value ="/getList2")           //获取二级组合框的信息（如教师、班级） 
		public @ResponseBody Object getList2(int vals) throws Exception{		
			List<Teacher> teInfo1 = new ArrayList<Teacher>();
	        List<Class> claInfo2 = new ArrayList<Class>();	      
	        HashMap<String, Object> map = new HashMap<>();
	        teInfo1=teacherService.getByYuid(vals);
	        claInfo2=classService.getByProid(vals);
	        map.put("teInfo1",teInfo1);
	        map.put("claInfo2",claInfo2);
	        return map;
		}
		
}

