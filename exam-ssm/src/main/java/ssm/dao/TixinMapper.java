package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import ssm.model.Student;
import ssm.model.Tixin;
import ssm.model.TixinExample;
import ssm.model.Yuanxi;

public interface TixinMapper {
    long countByExample(TixinExample example);

    int deleteByExample(TixinExample example);

    int insert(Tixin record);

    int insertSelective(Tixin record);

    List<Tixin> selectByExample(TixinExample example);

    int updateByExampleSelective(@Param("record") Tixin record, @Param("example") TixinExample example);
    int updateByExample(@Param("record") Tixin record, @Param("example") TixinExample example);
   
    public List findAll();  //显示所有题型信息
    public Tixin getByCouId(int couid); //根据课程号查询已有的题型
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public Tixin getById(@Param("txid") int txid); //通过题型号查询题型信息
    public int deleteByid(@Param("txid") int txid); //通过题型号删除题型信息
    public int updateByid(Tixin tx); //通过题型号修改学生信息
    public int addTixin(Tixin tx);   //添加题型信息
    public Tixin getByNam(@Param("tixinname") String tixinname);  //通过名称查询题型信息
    public List<Tixin> getByTinXinId(int tixinid );
}