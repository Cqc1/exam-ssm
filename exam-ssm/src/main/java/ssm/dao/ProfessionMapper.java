package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ssm.model.Profession;
import ssm.model.ProfessionExample;
import ssm.model.Yuanxi;

public interface ProfessionMapper {
    long countByExample(ProfessionExample example);

    int deleteByExample(ProfessionExample example);

    int insert(Profession record);

    int insertSelective(Profession record);

    List<Profession> selectByExample(ProfessionExample example);

    int updateByExampleSelective(@Param("record") Profession record, @Param("example") ProfessionExample example);

    int updateByExample(@Param("record") Profession record, @Param("example") ProfessionExample example);
    
    public List findAll();  //显示所有专业信息
    public Profession getById(@Param("proid") int proid);  //通过序号查询专业信息
    public int deleteByid(@Param("proid") int proid);  //通过序号删除专业信息
    public int updateByid(Profession pro);                //通过序号修改专业信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addPro(Profession pro);                   //添加专业信息
    public Profession getByNam(@Param("proname") String proname);//通过名称查询专业信息
}