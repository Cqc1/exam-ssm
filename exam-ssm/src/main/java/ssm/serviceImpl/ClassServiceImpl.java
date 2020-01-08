package ssm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.dao.*;
import ssm.model.Class;
import ssm.service.ClassService;
@Service("ClassService")
public class ClassServiceImpl implements ClassService
{
	@Resource(name = "classMapper")
    private ClassMapper classMapper;  //显示所有院系信息
	public List findAll()
	{
		return classMapper.findAll();
	}
	@Override
	public Class getById(int classid)
	{
		// TODO Auto-generated method stub
		return classMapper.getById(classid);
	}
	@Override
	public Class getByNam(String claname)
	{
		// TODO Auto-generated method stub
		return classMapper.getByNam(claname);
	}
	@Override
	public void deleteByid(int classid)
	{
		// TODO Auto-generated method stub
		classMapper.deleteByid(classid);
	}
	@Override
	public void updateByid(Class cla)
	{
		// TODO Auto-generated method stub
		classMapper.updateByid(cla);
	}
	@Override
	public List queryfind(String type, String query)
	{
		// TODO Auto-generated method stub
		return classMapper.queryfind(type, query);
	}
	@Override
	public void addCla(Class cla)
	{
		// TODO Auto-generated method stub
		classMapper.addCla(cla);
	}
	@Override
	public List<Class> getByProid(int proid)
	{
		// TODO Auto-generated method stub
		return classMapper.getByProid(proid);
	}
}
