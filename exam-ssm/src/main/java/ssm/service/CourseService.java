package ssm.service;

import java.util.List;

import ssm.model.Course;


public interface CourseService
{
	public List findAll();		//显示所有课程信息
	public Course getById(int couid);//通过序号查询课程信息
	public Course getByNam(String couname);//通过序号查询课程信息
	public void deleteByid(int couid); //通过序号删除课程信息
	public void updateByid(Course cou);//通过序号修改课程信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addCou(Course cou);//添加课程信息
}
