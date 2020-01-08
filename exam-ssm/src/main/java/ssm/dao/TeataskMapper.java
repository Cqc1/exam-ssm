package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Service;
import ssm.model.Shiti;
import ssm.model.Teatask;
import ssm.model.TeataskExample;
import ssm.service.ShitiService;

public interface TeataskMapper {
    long countByExample(TeataskExample example);

    int deleteByExample(TeataskExample example);

    int insert(Teatask record);

    int insertSelective(Teatask record);

    List<Teatask> selectByExample(TeataskExample example);

    int updateByExampleSelective(@Param("record") Teatask record, @Param("example") TeataskExample example);

    int updateByExample(@Param("record") Teatask record, @Param("example") TeataskExample example);
     
    public Teatask getById(@Param("taskid") int taskid);  //通过编号查询教学信息
    public List findAll();                                //显示所有教学信息
    public int deleteByid(@Param("taskid") int taskid);     //通过编号删除教学信息
    public int updateByid(Teatask ta);                    //通过编号修改教学信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addTask(Teatask ta);                       //添加教学信息
    public Teatask selectByMore(Teatask ta);                  //多条件查询
    public List<Teatask> getByteaId(@Param("teaid") int teaid);  //通过教师工号查询教学信息
}