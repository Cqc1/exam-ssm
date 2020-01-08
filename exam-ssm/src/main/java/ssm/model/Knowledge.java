package ssm.model;

public class Knowledge {
    private Integer knpoid;

    private Integer classid;

    private String zhjie;

    private String content;

    private String flour;

    public Integer getKnpoid() {
        return knpoid;
    }

    public void setKnpoid(Integer knpoid) {
        this.knpoid = knpoid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getZhjie() {
        return zhjie;
    }

    public void setZhjie(String zhjie) {
        this.zhjie = zhjie == null ? null : zhjie.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFlour() {
        return flour;
    }

    public void setFlour(String flour) {
        this.flour = flour == null ? null : flour.trim();
    }
}