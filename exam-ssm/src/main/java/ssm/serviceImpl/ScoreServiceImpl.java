package ssm.serviceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ssm.dao.ScoreMapper;
import ssm.model.Score;
import ssm.service.*;
@Service("ScoreService")
public class ScoreServiceImpl implements ScoreService
{
	@Resource(name = "scoreMapper")
    private ScoreMapper scoreMapper;
	@Override
	public Score getById(int stuid)
	{
		// TODO Auto-generated method stub
		return scoreMapper.getById(stuid);
	}

	@Override
	public List findAll()
	{
		// TODO Auto-generated method stub
		return scoreMapper.findAll();
	}

	@Override
	public void deleteByid(int stuid)
	{
		// TODO Auto-generated method stub
		scoreMapper.deleteByid(stuid);
	}

	@Override
	public void updateByid(Score sce)
	{
		// TODO Auto-generated method stub
		scoreMapper.updateByid(sce);
	}

	@Override
	public List queryfind(String type, String query)
	{
		// TODO Auto-generated method stub
		return scoreMapper.queryfind(type, query);
	}

	@Override
	public void addScore(Score sce)
	{
		// TODO Auto-generated method stub
		scoreMapper.addScore(sce);
	}

	@Override
	public Score selectByMore(Score sce)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
