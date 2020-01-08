package ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.model.Shijuan;

public interface ShijuanService
{
	 public List findAll();                                //显示所有试卷信息
	 public List<Shijuan> getByCouid(int couid);           //通过课程号获取试卷信息
	public List<Shijuan> getByTeaid(int teaid); //通过课程号，专业名称和班级号获取信息
}