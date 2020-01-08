package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import ssm.model.Teacher;
import ssm.model.Yuanxi;
import ssm.model.YuanxiExample;

public interface YuanxiMapper {
    long countByExample(YuanxiExample example);

    int deleteByExample(YuanxiExample example);

    int insert(Yuanxi record);

    int insertSelective(Yuanxi record);

    List<Yuanxi> selectByExample(YuanxiExample example);

    int updateByExampleSelective(@Param("record") Yuanxi record, @Param("example") YuanxiExample example);

    int updateByExample(@Param("record") Yuanxi record, @Param("example") YuanxiExample example);
    
    public List findAll();  //显示所有院系信息
    public Yuanxi getById(@Param("yuid") int yuid);  //通过序号查询院系信息
    public Yuanxi getByNam(@Param("yunam") String yunam);  //通过名称查询院系信息
    public int deleteByid(@Param("yuid") int yuid);  //通过序号删除院系信息
    public int updateByid(Yuanxi yu);                //通过序号修改院系信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addYuxi(Yuanxi yu);                   //添加院系信息
}