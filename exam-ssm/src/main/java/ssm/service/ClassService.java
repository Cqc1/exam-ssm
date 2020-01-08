package ssm.service;
import java.util.List;
import ssm.model.Class;
public interface ClassService
{
	public Class getById(int classid); //通过序号查询班级信息
	public Class getByNam(String claname); //通过序号查询班级信息
	public List findAll();		       //显示所有班级信息
	public void deleteByid(int classid); //通过序号删除班级信息
	public void updateByid(Class cla);//通过序号修改班级信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addCla(Class cla);  //添加班级信息
	public List<Class> getByProid(int proid); //通过专业序号查询班级信息
}
