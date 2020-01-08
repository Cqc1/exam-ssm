package ssm.model;

public class Profession {
    private Integer proid;

    private String proname;

    private Integer yuid;
    
    private Yuanxi yuanxi;

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public Integer getYuid() {
        return yuid;
    }

    public void setYuid(Integer yuid) {
        this.yuid = yuid;
    }

	public Yuanxi getYuanxi()
	{
		return yuanxi;
	}

	public void setYuanxi(Yuanxi yuanxi)
	{
		this.yuanxi = yuanxi;
	}
    
}