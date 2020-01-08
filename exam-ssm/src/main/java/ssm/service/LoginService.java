package ssm.service;
import ssm.model.Admin;
import ssm.model.Student;
import ssm.model.Teacher;

/**
 * 
 * 学生、教师、管理员登录验证的业务逻辑处理的接口
 *
 */
public interface LoginService {
	public Student checkStudentLogin(int userid, String password);// 学生登录验证

	public Teacher checkTeacherLogin(int userid, String password);// 教师登录验证

	public Admin checkAdminLogin(int userid, String password);// 管理员登录验证
	
}
