package ssm.service;

import java.util.List;

import ssm.model.Yuanxi;

public interface YuanxiService
{
	public List findAll();		//显示所有院系信息
	public Yuanxi getById(int yuid);//通过序号查询院系信息
	public Yuanxi getByNam(String yunam);//通过序号查询院系信息
	public void deleteByid(int yuid); //通过序号删除院系信息
	public void updateByid(Yuanxi yu);//通过序号修改院系信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addYuxi(Yuanxi yu);//添加院系信息
}
