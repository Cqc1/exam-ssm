package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import ssm.model.Student;
import ssm.model.Teacher;
import ssm.model.TeacherExample;

public interface TeacherMapper {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    
    public Teacher getTeacher(@Param("teaid") int teaid, @Param("teapwd") String teapwd);//验证教师信息
    public Teacher getById(@Param("teaid") int teaid);  //通过工号查询用户信息
    public List findAll();  //显示所有教师信息
    public int deleteByid(@Param("teaid") int teaid); //通过工号删除教师信息
    public int updateByid(Teacher te); //通过工号修改教师信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addUser(Teacher tea);   //添加教师信息
    public List<Teacher> getByYuid(@Param("yuid") int yuid);  //通过院系编号查询教师信息
    public int updateByPass(@Param("teaid") int teaid,@Param("password") String password); //修改密码
    
}