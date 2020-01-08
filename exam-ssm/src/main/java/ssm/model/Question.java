package ssm.model;

public class Question implements Comparable<Question>
{
	private int q;					//题号
	private double h;				//难度系数
	private double d;				//区分度
	private double t;				//平均时间
	private int qid;				//题型编号

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	//比较题目的大小,先按题型号再按题号比较升序
	public int compareTo(Question question) {
		if(this.qid==question.qid&&this.q==question.q)
			return 0;
		return this.qid<question.qid||(this.qid==question.qid&&this.q<question.q)?-1:1;
	}

	//输出试题
	public String toString() {
		return "题号：" + this.q
				+ "，难度系数：" + this.h
				+ "，区分度：" + this.d
				+ "，平均时间：" + this.t
				+ "，题型编号：" + this.qid;
	}
}
