package ssm.model;

public class StuAnswer {
    private Integer stuid;

    private Integer shijuanid;

    private Integer shitiid;

    private String stuanswer;

    private String decsrip;

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

    public Integer getShitiid() {
        return shitiid;
    }

    public void setShitiid(Integer shitiid) {
        this.shitiid = shitiid;
    }

    public String getStuanswer() {
        return stuanswer;
    }

    public void setStuanswer(String stuanswer) {
        this.stuanswer = stuanswer == null ? null : stuanswer.trim();
    }

    public String getDecsrip() {
        return decsrip;
    }

    public void setDecsrip(String decsrip) {
        this.decsrip = decsrip == null ? null : decsrip.trim();
    }
}