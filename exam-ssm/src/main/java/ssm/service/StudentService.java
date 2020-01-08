package ssm.service;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import ssm.model.*;

public interface StudentService
{
	public Student getById(int stuid);//通过学号查询学生信息
	public List findAll();		//显示所有学生信息
	public void deleteByid(int stuid); //通过学号删除学生信息
	public void updateByid(Student stu);//通过学号修改学生信息
	public List queryfind(String type,String query);//通过条件模糊查询
	public void addUser(Student stu);//添加学生信息
	public List<Student> getByClaid(int classid);//通过班级序号查询学生信息
	public void updateByPass(int stuid,String password); //修改密码
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception;//实现Excel数据的导入
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;//实现Excel数据的导出
}
