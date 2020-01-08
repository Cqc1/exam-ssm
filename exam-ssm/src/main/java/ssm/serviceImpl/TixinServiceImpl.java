package ssm.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.dao.TixinMapper;
import ssm.model.Tixin;
import ssm.service.*;
@Service("TixinService")
public class TixinServiceImpl implements TixinService
{
	@Resource(name = "tixinMapper")
    private TixinMapper tixinMapper;  
	@Override
	public List findAll()
	{
		// TODO Auto-generated method stub
		return tixinMapper.findAll();
	}

	@Override
	public Tixin getByCouId(int couid) {
		return tixinMapper.getByCouId(couid);
	}

	@Override
	public Tixin getById(int txid)
	{
		// TODO Auto-generated method stub
		return tixinMapper.getById(txid);
	}

	@Override
	public void deleteByid(int txid)
	{
		// TODO Auto-generated method stub
		tixinMapper.deleteByid(txid);
	}

	@Override
	public void updateByid(Tixin tx)
	{
		// TODO Auto-generated method stub
		tixinMapper.updateByid(tx);
	}

	@Override
	public void addTixin(Tixin tx)
	{
		// TODO Auto-generated method stub
		tixinMapper.addTixin(tx);
	}

	@Override
	public Tixin getByNam(String tixinname)
	{
		// TODO Auto-generated method stub
		return tixinMapper.getByNam(tixinname);
	}

	@Override
	public List queryfind(String type, String query) {
		return tixinMapper.queryfind(type,query);
	}

	@Override
	public List<Tixin> getByTinXinId(int tixinid) {
		return tixinMapper.getByTinXinId(tixinid);
	}

}
