package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ssm.model.Score;
import ssm.model.ScoreExample;
import ssm.model.Teatask;

public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);
    
    public Score getById(@Param("stuid") int stuid);  //通过学号查询成绩信息
    public List findAll();                                //显示所有成绩信息
    public int deleteByid(@Param("stuid") int stuid);     //通过学号删除成绩信息
    public int updateByid(Score sce);                    //通过学号修改教学信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addScore(Score sce);                        //添加成绩信息
    public Teatask selectByMore(Score sce);                  //多条件查询
}