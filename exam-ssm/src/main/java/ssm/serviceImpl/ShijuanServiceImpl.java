package ssm.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.dao.ShijuanMapper;
import ssm.model.Shijuan;
import ssm.service.*;
@Service("ShijuanService")
public class ShijuanServiceImpl implements ShijuanService
{

	@Resource(name = "shijuanMapper")
    private ShijuanMapper shijuanMapper;
	@Override
	public List findAll()
	{
		// TODO Auto-generated method stub
		return shijuanMapper.findAll();
	}
	@Override
	public List<Shijuan> getByCouid(int couid)
	{
		// TODO Auto-generated method stub
		return shijuanMapper.getByCouid(couid);
	}

	@Override
	public List<Shijuan> getByTeaid(int teaid) {
		return shijuanMapper.getByTeaid(teaid);
	}
}
