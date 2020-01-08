package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ssm.model.Class;
import ssm.model.ClassExample;
import ssm.model.Profession;

public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);
    
    public List findAll();  //显示所有班级信息
    public Class getById(@Param("classid") int classid);  //通过序号查询班级信息
    public int deleteByid(@Param("classid") int classid);  //通过序号删除班级信息
    public int updateByid(Class cla);                //通过序号修改班级信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addCla(Class cla);                   //添加班级信息
    public Class getByNam(@Param("claname") String claname);//通过名称查询班级信息
    public List<Class> getByProid(@Param("proid") int proid);     //通过专业序号查询班级信息
}
