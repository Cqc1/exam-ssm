package ssm.serviceImpl;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ssm.dao.StudentMapper;
import ssm.model.ExcelBean;
import ssm.model.Student;
import ssm.service.*;
import ssm.util.ExcelUtil;

@Service("StudentService")
public class StudentServiceImpl implements StudentService
{
	@Resource(name = "studentMapper")
    private StudentMapper studentMapper;
	
	@Override
	public List findAll()   //查询学生所有信息
	{
		return studentMapper.findAll();
	}

	public void deleteByid(int stuid)   //通过学号删除学生信息
	{
		studentMapper.deleteByid(stuid);		
	}

	@Override
	public void updateByid(Student stu)   //通过学号修改学生信息
	{
		studentMapper.updateByid(stu);
	}

	@Override
	public List queryfind(String type, String query)  //通过条件模糊查询
	{
		return studentMapper.queryfind(type, query);
	}

	@Override
	public void addUser(Student stu)   //添加学生信息
	{
		studentMapper.addUser(stu);
	}

	@Override
	public Student getById(int stuid)  //查询单个学生信息
	{
		return studentMapper.getById(stuid);
	}

	@Override
	public List<Student> getByClaid(int classid)
	{
		// TODO Auto-generated method stub
		return studentMapper.getByClaid(classid);
	}

	@Override
	public void updateByPass(int stuid, String password)
	{
		// TODO Auto-generated method stub
		studentMapper.updateByPass(stuid, password);
	}
	

public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{

    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());

    List<Student> studentList = new ArrayList<Student>();

    //遍历listob数据，把数据放到List中

    for (int i = 0; i < listob.size(); i++) {

        List<Object> ob = listob.get(i);

        Student stu = new Student();


        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载

        stu.setStuid(Integer.valueOf((String) ob.get(1)));

        stu.setStupwd(String.valueOf(ob.get(2)));

        stu.setStuname(String.valueOf(ob.get(3)));

        stu.setStusex(String.valueOf(ob.get(4)));

        stu.setClassid(Integer.valueOf((String) ob.get(5)));

        stu.setStumail(String.valueOf(ob.get(6)));

        stu.setStunum(Integer.valueOf((String) ob.get(7)));

        studentList.add(stu);

    }

    //批量插入

    studentMapper.insertInfoBatch(studentList);

}

public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {

    //根据条件查询数据，把数据装载到一个list中

    List<Student> list = studentMapper.findAll();

    List<ExcelBean> excel=new ArrayList<>();

    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();

    XSSFWorkbook xssfWorkbook=null;

    //设置标题栏

    excel.add(new ExcelBean("学号","id",0));

    excel.add(new ExcelBean("密码","password",0));

    excel.add(new ExcelBean("姓名","name",0));

    excel.add(new ExcelBean("性别","sex",0));

    excel.add(new ExcelBean("班级序号","classId",0));

    excel.add(new ExcelBean("邮箱","stuMail",0));

    excel.add(new ExcelBean("号码","stuNum",0));

    map.put(0, excel);

    String sheetName = "学生信息总表";

    //调用ExcelUtil的方法

    xssfWorkbook = ExcelUtil.createExcelFile(Student.class, list, map, sheetName);

    return xssfWorkbook;

}

	
}
