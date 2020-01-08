package ssm.model;

import java.util.ArrayList;

public class Shiti {
    private Integer shitiid;

    private Integer couid;

    private Integer tixinid;

    private double difficulty;

    private Integer knpoid;

    private double qufen;

    private String content;

    private String chart;

    private String answer;

    private String testnumber;

    private double correctnumber;

    public double getCorrectnumber() {
        return correctnumber;
    }

    public void setCorrectnumber(double correctnumber) {
        this.correctnumber = correctnumber;
    }

    private double avetim ;

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getTixinid() {
        return tixinid;
    }

    public void setTixinid(Integer tixinid) {
        this.tixinid = tixinid;
    }

    public Integer getKnpoid() {
        return knpoid;
    }

    public void setKnpoid(Integer knpoid) {
        this.knpoid = knpoid;
    }

    public double getQufen() {
        return qufen;
    }

    public void setQufen(double qufen) {
        this.qufen = qufen;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getAvetim() {
        return avetim;
    }

    public void setAvetim(double avetim) {
        this.avetim = avetim;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTestnumber() {
        return testnumber;
    }

    public void setTestnumber(String testnumber) {
        this.testnumber = testnumber;
    }


    public Integer getShitiid() {
        return shitiid;
    }

    public void setShitiid(Integer shitiid) {
        this.shitiid = shitiid;
    }

    public Integer getCouid() {
        return couid;
    }

    //TestQuestionתΪQuestion
    public Question getQuestion()
    {
        //��ʼ������
        Question question=new Question();
        //��������
        question.setQ(this.shitiid);
        question.setH(this.difficulty);
        question.setD(this.qufen);
        question.setT(this.avetim);
        question.setQid(this.tixinid);
        //��������
        return question;
    }

    //tqListתΪqList
    public static ArrayList<Question> getQList(ArrayList<Shiti> tqList)
    {
        //��ʼ��qList
        ArrayList<Question> qList=new ArrayList<Question>();
        //���ת��
        for(int i=0; i<tqList.size(); i++)
        {
            Shiti shiti=tqList.get(i);
            qList.add(shiti.getQuestion());
        }
        //�������⼯
        return qList;
    }

}