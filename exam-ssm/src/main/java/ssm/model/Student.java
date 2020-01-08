package ssm.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


public class Student {
	@NotEmpty(message="学生学号不能为空")
    private Integer stuid;

	@NotEmpty(message="学生密码不能为空")
    private String stupwd;

	@NotEmpty(message="学生名称不能为空")
	@Length(min=6,max=10,message="用户密码长度为6-10")
    private String stuname;

    private String stusex;

    private Integer classid;
   
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"
    	    ,message = "邮箱格式不正确")
    private String stumail;

    @NotEmpty(message="学生号码不能为空")
	@Length(min=11,max=11,message="用户电话号码长度为11")
    private Integer stunum;
   
    private Class clas;//添加班级对象实现关联

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStupwd() {
        return stupwd;
    }

    public void setStupwd(String stupwd) {
        this.stupwd = stupwd == null ? null : stupwd.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex == null ? null : stusex.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getStumail() {
        return stumail;
    }

    public void setStumail(String stumail) {
        this.stumail = stumail == null ? null : stumail.trim();
    }

    public Integer getStunum() {
        return stunum;
    }

    public void setStunum(Integer stunum) {
        this.stunum = stunum;
    }

	public Class getClas()
	{
		return clas;
	}

	public void setClas(Class clas)
	{
		this.clas = clas;
	}
    
}