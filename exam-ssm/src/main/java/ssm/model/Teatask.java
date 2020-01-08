package ssm.model;
import ssm.model.Class;
public class Teatask {

    private String term;

    private Integer teaid;

    private Integer couid;

    private Integer classid;
    
    //关联添加对象
    
    private Teacher teacher;
    
    private Course course;
    
    private Class clas;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

	public Teacher getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
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
    
    
}