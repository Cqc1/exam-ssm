package ssm.model;

public class Admin {
    private Integer adid;

    private String adpwd;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdpwd() {
        return adpwd;
    }

    public void setAdpwd(String adpwd) {
        this.adpwd = adpwd == null ? null : adpwd.trim();
    }
}