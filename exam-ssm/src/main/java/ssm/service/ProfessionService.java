package ssm.service;
import java.util.List;
import ssm.model.Profession;
public interface ProfessionService
{
	public Profession getById(int proid); //通过序号查询专业信息
	public Profession getByNam(String proname); //通过序号查询专业信息
	public List findAll();		       //显示所有专业信息
	public void deleteByid(int proid); //通过序号删除专业信息
	public void updateByid(Profession pro);//通过序号修改专业信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addPro(Profession pro);  //添加专业信息
}
