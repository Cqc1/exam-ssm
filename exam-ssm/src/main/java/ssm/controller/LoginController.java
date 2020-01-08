package ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.model.Student;
import ssm.model.Teacher;
import ssm.model.Admin;
import ssm.service.LoginService;

@Controller
@RequestMapping(value = "/user")
public class LoginController
{
	private Student student;
	private Teacher teacher;
	private Admin admin;
	@Autowired
	LoginService loginService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, @RequestParam int userid,@RequestParam String password,int type) throws IOException    {       
		ModelAndView mv=new ModelAndView();
		String login=null;
		System.out.println("userid=" + userid);
		System.out.println("password=" + password);
		System.out.println("type=" + type);
		if (type == 0) {// 学生登录验证
			student = loginService.checkStudentLogin(userid, password);
			if (student != null) {
				login="success";
				request.getSession().setAttribute("student", student.getStuname());
				request.getSession().setAttribute("studentId", student.getStuid());
				request.getSession().setAttribute("sessionlevel",type);
				request.getSession().setAttribute("stu", student);
				request.getSession().setAttribute("LOGIN_USER", login);//登录成功的拦截验证
				mv.setViewName("/student/student_Index");
			} else
				mv.setViewName("/login");
		} else if (type == 1) {// 教师登录验证
			teacher = loginService.checkTeacherLogin(userid, password);
			if (teacher != null) {
				login="success";
				HttpSession session = request.getSession();
				request.getSession().setAttribute("teacher", teacher.getTeaname());
				request.getSession().setAttribute("teacherId", teacher.getTeaid());
				request.getSession().setAttribute("sessionlevel",type);
				request.getSession().setAttribute("tea", teacher);
				request.getSession().setAttribute("LOGIN_USER", login);//登录成功的拦截验证
				System.out.println(session.getAttribute("LOGIN_USER")+"2");
				mv.setViewName("/teacher/teacher_Index");	
			} else {
				mv.setViewName("/login");
			}
	
		} else {// 管理员登录验证
			admin = loginService.checkAdminLogin(userid, password);
			if (admin != null) {
				login="success";
				request.getSession().setAttribute("sessionlevel",type);
				request.getSession().setAttribute("admin", admin.getAdid());
				request.getSession().setAttribute("LOGIN_USER", login);//登录成功的拦截验证
				mv.setViewName("/behind/admin_Index");
			} else
				mv.setViewName("/login");
		}
		return mv;
		}
}
