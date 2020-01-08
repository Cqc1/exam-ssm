package ssm.model;

public class Tixin {
    private Integer tixinid;

    private String tixinname;

    private int couid;

    public int getCouid() {
        return couid;
    }

    public void setCouid(int couid) {
        this.couid = couid;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private  Course course;

    public Integer getTixinid() {
        return tixinid;
    }

    public void setTixinid(Integer tixinid) {
        this.tixinid = tixinid;
    }

    public String getTixinname() {
        return tixinname;
    }

    public void setTixinname(String tixinname) {
        this.tixinname = tixinname == null ? null : tixinname.trim();
    }
}