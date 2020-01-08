package ssm.serviceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ssm.dao.CourseMapper;
import ssm.model.Course;
import ssm.service.CourseService;
@Service("CourseService")
public class CourseServiceImpl implements CourseService
{
	@Resource(name = "courseMapper")
    private CourseMapper courseMapper;  
	@Override
	public List findAll()                  //显示所有课程信息
	{
		// TODO Auto-generated method stub
		return courseMapper.findAll();
	}

	@Override
	public Course getById(int couid)       //通过序号查询课程信息
	{
		// TODO Auto-generated method stub
		return courseMapper.getById(couid);
	}

	@Override
	public Course getByNam(String couname) //通过名称查询课程信息
	{
		// TODO Auto-generated method stub
		return courseMapper.getByNam(couname);
	}

	@Override
	public void deleteByid(int couid)      //通过序号删除课程信息
	{
		// TODO Auto-generated method stub
		courseMapper.deleteByid(couid);
	}

	@Override
	public void updateByid(Course cou)     //通过序号修改课程信息
	{
		// TODO Auto-generated method stub
		courseMapper.updateByid(cou);
	}

	@Override
	public List queryfind(String type, String query) //通过条件模糊查询
	{
		// TODO Auto-generated method stub
		return courseMapper.queryfind(type, query);
	}

	@Override
	public void addCou(Course cou)                    //添加课程信息
	{
		// TODO Auto-generated method stub
		courseMapper.addCou(cou);
	}

}
