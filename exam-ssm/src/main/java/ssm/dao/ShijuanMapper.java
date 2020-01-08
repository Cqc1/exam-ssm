package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ssm.model.Shijuan;
import ssm.model.ShijuanExample;
import ssm.model.Shiti;

public interface ShijuanMapper {
    long countByExample(ShijuanExample example);

    int deleteByExample(ShijuanExample example);

    int insert(Shijuan record);

    int insertSelective(Shijuan record);

    List<Shijuan> selectByExample(ShijuanExample example);

    int updateByExampleSelective(@Param("record") Shijuan record, @Param("example") ShijuanExample example);

    int updateByExample(@Param("record") Shijuan record, @Param("example") ShijuanExample example);

    public List findAll();                                //显示所有试卷信息

    public List<Shijuan> getByCouid(@Param("couid") int couid);//通过课程号获取试卷信息
    public List<Shijuan> getByTeaid(int teaid); //通过课程号，专业名称和班级号获取信息
}