package ssm.service;
import java.util.List;
import ssm.model.Score;
public interface ScoreService
{
	public Score getById(int stuid);//通过学号查询成绩信息
	public List findAll();		       //显示所有成绩信息
	public void deleteByid(int stuid); //通过学号删除成绩信息
	public void updateByid(Score sce);//通过学号修改成绩信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addScore(Score sce);  //添加成绩信息
	public Score selectByMore(Score sce);//多条件查询
}
