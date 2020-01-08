package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import ssm.model.Admin;
import ssm.model.Student;
import ssm.model.StudentExample;
import ssm.model.Teacher;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);
    
    public Student getStudent(@Param("stuid") int stuid, @Param("stupwd") String stupwd);  //验证学生信息
    public Student getById(@Param("stuid") int stuid);  //通过学号查询用户信息
    public List findAll();  //显示所有学生信息
    public int deleteByid(@Param("stuid") int stuid); //通过学号删除学生信息
    public int updateByid(Student stu); //通过学号修改学生信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addUser(Student stu);   //添加学生信息
    public List<Student> getByClaid(@Param("classid") int classid); //通过班级序号查询学生信息
    public int updateByPass(@Param("stuid") int stuid,@Param("password") String password); //修改密码
    public List insertInfoBatch(List<Student> studentList);  //Excel数据导入
}