package ssm.model;

import java.util.Date;

public class Shijuan {
    private Integer shijuanid;

    private Integer couid;

    private Date examday;

    private String examtime;

    private String examadr;

    private Integer classid;

    private Integer tixinid;

    private Integer tixinscore;

    private Integer toalscore;

    private String zujuuser;
    
    //关联对象
    
    private Course course;
    
    private Class clas;
    
    private Tixin tixin;

    private Teatask teatask;

    public Teatask getTeatask() {
        return teatask;
    }

    public void setTeatask(Teatask teatask) {
        this.teatask = teatask;
    }

    public Integer getShijuanid() {
        return shijuanid;
    }

    public void setShijuanid(Integer shijuanid) {
        this.shijuanid = shijuanid;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Date getExamday() {
        return examday;
    }

    public void setExamday(Date examday) {
        this.examday = examday;
    }

    public String getExamtime() {
        return examtime;
    }

    public void setExamtime(String examtime) {
        this.examtime = examtime == null ? null : examtime.trim();
    }

    public String getExamadr() {
        return examadr;
    }

    public void setExamadr(String examadr) {
        this.examadr = examadr == null ? null : examadr.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getTixinid() {
        return tixinid;
    }

    public void setTixinid(Integer tixinid) {
        this.tixinid = tixinid;
    }

    public Integer getTixinscore() {
        return tixinscore;
    }

    public void setTixinscore(Integer tixinscore) {
        this.tixinscore = tixinscore;
    }

    public Integer getToalscore() {
        return toalscore;
    }

    public void setToalscore(Integer toalscore) {
        this.toalscore = toalscore;
    }

    public String getZujuuser() {
        return zujuuser;
    }

    public void setZujuuser(String zujuuser) {
        this.zujuuser = zujuuser == null ? null : zujuuser.trim();
    }

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public Class getClas()
	{
		return clas;
	}

	public void setClas(Class clas)
	{
		this.clas = clas;
	}

	public Tixin getTixin()
	{
		return tixin;
	}

	public void setTixin(Tixin tixin)
	{
		this.tixin = tixin;
	}
    
    
}