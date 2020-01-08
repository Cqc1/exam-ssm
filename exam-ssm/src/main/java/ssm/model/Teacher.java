package ssm.model;

public class Teacher {
    private Integer teaid;

    private String teaname;

    private String teapwd;

    private String teasex;

    private Integer yuid;

    private String teamail;

    private Integer teanum;
    
    private Yuanxi yuanxi; //添加院系对象实现关联

    public Yuanxi getYuanxi()
	{
		return yuanxi;
	}

	public void setYuanxi(Yuanxi yuanxi)
	{
		this.yuanxi = yuanxi;
	}

	public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer integer) {
        this.teaid = Integer.valueOf(integer).intValue();
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    public String getTeapwd() {
        return teapwd;
    }

    public void setTeapwd(String teapwd) {
        this.teapwd = teapwd == null ? null : teapwd.trim();
    }

    public String getTeasex() {
        return teasex;
    }

    public void setTeasex(String teasex) {
        this.teasex = teasex == null ? null : teasex.trim();
    }

    public Integer getYuid() {
        return yuid;
    }

    public void setYuid(Integer integer) {
        this.yuid = Integer.valueOf(integer).intValue();
    }

    public String getTeamail() {
        return teamail;
    }

    public void setTeamail(String teamail) {
        this.teamail = teamail == null ? null : teamail.trim();
    }

    public Integer getTeanum() {
        return teanum;
    }

    public void setTeanum(Integer integer) {
        this.teanum = Integer.valueOf(integer).intValue();
    }
}