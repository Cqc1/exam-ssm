package ssm.service;
import java.util.List;
import ssm.model.Tixin;

public interface TixinService
{
	public List findAll();		//显示所有题型信息
	public Tixin getByCouId(int couid); //根据课程号查询已有的题型
	public Tixin getById(int txid);//通过序号查询题型信息
	public void deleteByid(int txid); //通过序号删除题型信息
	public void updateByid(Tixin tx);//通过序号修改题型信息
	public void addTixin(Tixin tx);//添加院系信息
	public Tixin getByNam(String tixinname);//通过题型名称查找
	public List queryfind(String type,String query);//通过条件模糊查询
	public List<Tixin> getByTinXinId(int tixinid );
}
