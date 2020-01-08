package ssm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value = "/")       //实现在WEB-INF文件下需要额外跳转的jsp文件
public class DispatcherController
{

	@RequestMapping("/behind")
	public ModelAndView admin_leftPage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/behind/admin_left");
		return mv;
	}
	@RequestMapping("/student")
	public ModelAndView student_leftPage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/student/student_left");
		return mv;
	}
	@RequestMapping("/teacher")
	public ModelAndView teacher_leftPage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/teacher/teacher_left");
		return mv;
	}
	@RequestMapping("/index")
	public ModelAndView indexPage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	@RequestMapping("/top")
	public ModelAndView topPage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/top");
		return mv;

	}
}
