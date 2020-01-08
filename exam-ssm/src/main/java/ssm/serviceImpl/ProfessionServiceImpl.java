package ssm.serviceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ssm.dao.ProfessionMapper;
import ssm.model.Profession;
import ssm.service.ProfessionService;
@Service("ProfessionService")
public class ProfessionServiceImpl implements ProfessionService
{
	@Resource(name = "professionMapper")
    private ProfessionMapper professionMapper;
	@Override
	public Profession getById(int proid)
	{
		// TODO Auto-generated method stub
		return professionMapper.getById(proid);
	}

	@Override
	public List findAll()
	{
		// TODO Auto-generated method stub
		return professionMapper.findAll();
	}

	@Override
	public void deleteByid(int proid)
	{
		// TODO Auto-generated method stub
		professionMapper.deleteByid(proid);
	}

	@Override
	public void updateByid(Profession pro)
	{
		// TODO Auto-generated method stub
		professionMapper.updateByid(pro);
	}

	@Override
	public List queryfind(String type, String query)
	{
		// TODO Auto-generated method stub
		return professionMapper.queryfind(type, query);
	}

	@Override
	public void addPro(Profession pro)
	{
		// TODO Auto-generated method stub
		professionMapper.addPro(pro);
	}

	@Override
	public Profession getByNam(String proname)
	{
		// TODO Auto-generated method stub
		return professionMapper.getByNam(proname);
	}

}
