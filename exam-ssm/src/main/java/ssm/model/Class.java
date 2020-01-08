package ssm.model;

public class Class {
    private Integer classid;

    private String claname;

    private Integer proid;
    
    private Profession profession;
    private Yuanxi yuanxi;

    public Yuanxi getYuanxi() {
        return yuanxi;
    }

    public void setYuanxi(Yuanxi yuanxi) {
        this.yuanxi = yuanxi;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClaname() {
        return claname;
    }

    public void setClaname(String claname) {
        this.claname = claname == null ? null : claname.trim();
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

	public Profession getProfession()
	{
		return profession;
	}

	public void setProfession(Profession profession)
	{
		this.profession = profession;
	}
    
}