package ssm.serviceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ssm.dao.TeataskMapper;
import ssm.model.Teatask;
import ssm.service.TeataskService;
@Service("TeataskService")
public class TeataskServiceImpl implements TeataskService
{

	@Resource(name = "teataskMapper")
    private TeataskMapper teataskMapper;
	@Override
	public Teatask getById(int taskid)
	{
		// TODO Auto-generated method stub
		return teataskMapper.getById(taskid);
	}

	@Override
	public List findAll()
	{
		// TODO Auto-generated method stub
		return teataskMapper.findAll();
	}

	@Override
	public void deleteByid(int taskid)
	{
		// TODO Auto-generated method stub
		teataskMapper.deleteByid(taskid);
	}

	@Override
	public void updateByid(Teatask ta)
	{
		// TODO Auto-generated method stub
		teataskMapper.updateByid(ta);
	}

	@Override
	public List queryfind(String type, String query)
	{
		// TODO Auto-generated method stub
		return teataskMapper.queryfind(type, query);
	}

	@Override
	public void addTask(Teatask ta)
	{
		// TODO Auto-generated method stub
		teataskMapper.addTask(ta);
	}

	@Override
	public Teatask selectByMore(Teatask ta)
	{
		// TODO Auto-generated method stub
		return teataskMapper.selectByMore(ta);
	}

	@Override
	public List<Teatask> getByteaId(int teaid)
	{
		// TODO Auto-generated method stub
		return teataskMapper.getByteaId(teaid);
	}

}
