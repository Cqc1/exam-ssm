package ssm.service;

import java.util.List;

import ssm.model.Teacher;

public interface TeacherService
{
	public Teacher getById(int teaid);//通过工号查询教师信息
	public List findAll();		//显示所有教师信息
	public void deleteByid(int teaid); //通过工号删除教师信息
	public void updateByid(Teacher te);//通过工号修改教师信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addUser(Teacher tea);//添加教师信息
	public List<Teacher> getByYuid(int yuid);  //通过院系编号查询教师信息
	public void updateByPass(int teaid,String password); //修改密码
}
