package ssm.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.dao.TeacherMapper;
import ssm.model.Teacher;
import ssm.service.TeacherService;
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService
{

	@Resource(name = "teacherMapper")
    private TeacherMapper teacherMapper;
	
	@Override
	public List findAll()   //查询教师所有信息
	{
		return teacherMapper.findAll();
	}

	public void deleteByid(int teaid)   //通过工号删除教师信息
	{
		teacherMapper.deleteByid(teaid);		
	}

	@Override
	public void updateByid(Teacher te)   //通过工号修改教师信息
	{
		teacherMapper.updateByid(te);
	}

	@Override
	public List queryfind(String type, String query)  //通过条件模糊查询
	{
		return teacherMapper.queryfind(type, query);
	}

	@Override
	public void addUser(Teacher tea)   //添加教师信息
	{
		teacherMapper.addUser(tea);
	}

	@Override
	public Teacher getById(int teaid)  //查询单个教师信息
	{
		return teacherMapper.getById(teaid);
	}

	@Override
	public List<Teacher> getByYuid(int yuid)
	{
		// TODO Auto-generated method stub
		return teacherMapper.getByYuid(yuid);
	}

	@Override
	public void updateByPass(int teaid, String password)
	{
		// TODO Auto-generated method stub
		teacherMapper.updateByPass(teaid, password);
	}
	

}
