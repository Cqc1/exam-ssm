package ssm.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.dao.AdminMapper;
import ssm.dao.StudentMapper;
import ssm.dao.TeacherMapper;
import ssm.model.Admin;
import ssm.model.Student;
import ssm.model.Teacher;
import ssm.service.LoginService;

/**
 * 
 * 登录验证的业务处理类
 *
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name = "adminMapper")
    private AdminMapper adminMapper;
	
	@Resource(name = "studentMapper")
    private StudentMapper studentMapper;
	
	@Resource(name = "teacherMapper")
    private TeacherMapper teacherMapper;
	// 学生登录验证
	public Student checkStudentLogin(int userid, String password) {
		return studentMapper.getStudent(userid, password);
	}

	// 教师登录验证
	public Teacher checkTeacherLogin(int userid, String password) {
		return teacherMapper.getTeacher(userid, password);
	}

	// 管理员登录验证
	public Admin checkAdminLogin(int userid, String password) {
		return adminMapper.getAdmin(userid, password);
	}

}
