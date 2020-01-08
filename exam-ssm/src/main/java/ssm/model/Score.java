package ssm.model;

public class Score {
    private String term;

    private Integer couid;

    private Integer stuid;

    private Integer shijuanid;

    private Integer score;
    
    //添加关联对象
    
    private Student student;
    
    private Course course;
    
    private Shijuan shijuan;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getShijuanid() {
        return shijuanid;
    }

    public void setShijuanid(Integer shijuanid) {
        this.shijuanid = shijuanid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public Shijuan getShijuan()
	{
		return shijuan;
	}

	public void setShijuan(Shijuan shijuan)
	{
		this.shijuan = shijuan;
	}
    
    
}