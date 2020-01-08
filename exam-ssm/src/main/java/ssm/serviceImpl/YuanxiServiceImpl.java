package ssm.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.dao.YuanxiMapper;
import ssm.model.Yuanxi;
import ssm.service.*;
@Service("YuanxiService")
public class YuanxiServiceImpl implements YuanxiService
{

	@Resource(name = "yuanxiMapper")
    private YuanxiMapper yuanxiMapper;  //显示所有院系信息
	public List findAll()
	{
		return yuanxiMapper.findAll();
	}
	@Override
	public Yuanxi getById(int yuid)     //通过序号查询院系信息
	{
		// TODO Auto-generated method stub
		return yuanxiMapper.getById(yuid);
	}
	@Override
	public void deleteByid(int yuid)   //通过序号删除院系信息
	{
		// TODO Auto-generated method stub
		yuanxiMapper.deleteByid(yuid);
	}
	@Override
	public void updateByid(Yuanxi yu)  //通过序号修改院系信息
	{
		// TODO Auto-generated method stub
		yuanxiMapper.updateByid(yu);
	}
	@Override
	public List queryfind(String type, String query) //通过条件模糊查询
	{
		// TODO Auto-generated method stub
		return yuanxiMapper.queryfind(type, query);
	}
	@Override
	public void addYuxi(Yuanxi yu)                  //添加院系信息
	{
		// TODO Auto-generated method stub
		yuanxiMapper.addYuxi(yu);
	}
	@Override
	public Yuanxi getByNam(String yunam)            //通过名称查询院系信息
	{
		// TODO Auto-generated method stub
		return yuanxiMapper.getByNam(yunam);
	}

}
