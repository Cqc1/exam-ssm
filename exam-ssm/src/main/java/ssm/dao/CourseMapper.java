package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import ssm.model.Class;
import ssm.model.Course;
import ssm.model.CourseExample;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);
    
    public List findAll();                                 //显示所有课程信息
    public Course getById(@Param("couid") int couid);      //通过序号查询课程信息
    public int deleteByid(@Param("couid") int couid);      //通过序号删除课程信息
    public int updateByid(Course cou);                      //通过序号修改课程信息
    public List queryfind(@Param("type") String type,@Param("query") String query);//通过条件模糊查询
    public int addCou(Course cou);                          //添加班级信息
    public Course getByNam(@Param("couname") String couname);//通过名称查询班级信息
}