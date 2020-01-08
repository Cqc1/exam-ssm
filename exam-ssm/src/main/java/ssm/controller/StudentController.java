package ssm.controller;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import ssm.model.Student;
import ssm.service.ClassService;
import ssm.service.StudentService;
@Controller
@RequestMapping(value = "/student")
public class StudentController
{
	@Autowired
	StudentService studentService;
	@Autowired
	ClassService classService;
	/*管理员权限*/
	@RequestMapping(value = "/StuInfo")
	public ModelAndView TeInfo(Model model) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		List list=studentService.findAll();
		model.addAttribute("student",list);
		mv.setViewName("/behind/manager_stu");
		return mv;
	}
	@RequestMapping(value = "/Delete")
	public ModelAndView Delete(Model model,@RequestParam int stuid) throws Exception{
		ModelAndView mv=new ModelAndView();
		studentService.deleteByid(stuid);
		List list=studentService.findAll();
		model.addAttribute("student",list);
		mv.setViewName("/behind/manager_stu");
		return mv;
	}
	@RequestMapping(value = "/Update_view")
	public ModelAndView Update_view(Model model,@RequestParam int stuid) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=classService.findAll();
		model.addAttribute("clas",list);
		model.addAttribute("stuid",stuid);
		mv.setViewName("/behind/up_stu");
		return mv;
	}
	@RequestMapping(value = "/Update")
	public ModelAndView Update(HttpServletRequest request,HttpServletResponse response,
			Model model,Student stu) throws Exception{
		ModelAndView mv=new ModelAndView();	
		studentService.updateByid(stu);
		List list=studentService.findAll();
		model.addAttribute("student",list);
		mv.setViewName("/behind/manager_stu");
		return mv;
	}
	@RequestMapping(value = "/StuInfo_query")
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
	public String StuInfo_query(String query,String type,HttpServletRequest request) throws Exception{
	    List list=studentService.queryfind(type,query);
	    String result="error";
	    if(!list.isEmpty()) {
	    	HttpSession session = request.getSession();
            session.setAttribute("student",list);
	    	result="success";
	    } 	    
		return result;
	}
	@RequestMapping(value = "/StuInfo_query2")
	public ModelAndView StuInfo_query2(Model model,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		model.addAttribute("student", (List) request.getAttribute("student"));
		mv.setViewName("/behind/manager_stu");
		return mv;
	}
	@RequestMapping(value = "/Add_view")
	public ModelAndView Add_view(Model model,Student stu) throws Exception{
		ModelAndView mv=new ModelAndView();
		List list=classService.findAll();
		model.addAttribute("clas",list);
		mv.setViewName("/behind/add_stu");
		return mv;
	}
	@RequestMapping(value ="/addStu")
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值 
	public Student addTea(@RequestBody /*@Valid*/ Student requestStu/*,BindingResult result*/,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		/* if (result.hasErrors()){
	            //校验失败,返回错误信息并在模态框中显示
			 return requestStu;
		 }*/
		int stuid = requestStu.getStuid();
		Student stu=requestStu;
		requestStu=studentService.getById(stuid);
		if(requestStu==null) {
			studentService.addUser(stu);
		}
		return requestStu;
	}
	/*学生权限*/
	@RequestMapping(value = "/Stu_idioInfo")
	public ModelAndView Stu_idioInfo(Model model,int stuid) throws Exception{
		ModelAndView mv=new ModelAndView(); 
		Student stu=studentService.getById(stuid);
		model.addAttribute("student",stu);
		mv.setViewName("/student/student_info");
		return mv;
	}
	@RequestMapping(value = "/Stu_pass")   //修改密码时的验证
	@ResponseBody             //此注解不能省略 否则ajax无法接受返回值
	public String Stu_pass(int stuid,String old_pass,String new_pass) throws Exception{
		Student stu=studentService.getById(stuid);
		System.out.println(stuid+","+old_pass+"||"+stu.getStupwd()+new_pass);
		String result="error";
		if(stu.getStupwd().equals(old_pass)) {
			studentService.updateByPass(stuid, new_pass);
	        result="success";
		}
		return result;
	}
	@RequestMapping(value = "/student_pass") //跳转更新密码界面
	public ModelAndView student_passView(Model model,Object stu,HttpServletRequest request) throws Exception{
		stu=request.getAttribute("stu");
		ModelAndView mv=new ModelAndView(); 
		model.addAttribute("stu",stu);
		mv.setViewName("/student/student_pass");
		return mv;
	}
/*Excel数据的导入与导出
@ResponseBody
@RequestMapping("/import")

public ModelAndView impotr(HttpServletRequest request, Model model) throws Exception {

     ModelAndView mv=new ModelAndView();
     //获取上传的文件

     MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;

     MultipartFile file = multipart.getFile("upfile");

     InputStream in = file.getInputStream();

     //数据导入

     studentService.importExcelInfo(in,file);

     in.close();
     mv.setViewName("/behind/manager_stu");
     return mv;

}

@RequestMapping("/export")

public @ResponseBody void export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {

        Map<String,Object> map=new HashMap<String,Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssms");

        String dateStr = sdf.format(new Date());
        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示

        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。

        response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xlsx"); 
        
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");

        response.setHeader("Pragma", "no-cache");

        response.setHeader("Cache-Control", "no-cache");

        response.setDateHeader("Expires", 0);

        XSSFWorkbook workbook=null;

        //导出Excel对象

        workbook = studentService.exportExcelInfo();

        OutputStream output;

        try {

            output = response.getOutputStream();

            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);

            bufferedOutPut.flush();

            workbook.write(bufferedOutPut);

            bufferedOutPut.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }*/

}

