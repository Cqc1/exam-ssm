package ssm.model;

public class Yuanxi {
    private Integer yuid;

    private String yunam;
    
    private Teacher teacher;

    public Teacher getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}

	public Integer getYuid() {
        return yuid;
    }

    public void setYuid(Integer yuid) {
        this.yuid = yuid;
    }

    public String getYunam() {
        return yunam;
    }

    public void setYunam(String yunam) {
        this.yunam = yunam == null ? null : yunam.trim();
    }
}