package ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.model.Teatask;

public interface TeataskService
{
	public Teatask getById(int taskid);//通过编号查询教学信息
	public List findAll();		       //显示所有教学信息
	public void deleteByid(int taskid); //通过编号删除教学信息
	public void updateByid(Teatask ta);//通过编号修改教学信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addTask(Teatask ta);  //添加教学信息
	public Teatask selectByMore(Teatask ta);//多条件查询
	public List<Teatask> getByteaId(int teaid);  //通过教师工号查询教学信息
}
