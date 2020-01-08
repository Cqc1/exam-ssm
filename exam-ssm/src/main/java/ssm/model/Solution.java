package ssm.model;

import java.util.Arrays;

public class Solution 
{	
	private int questionIds[];						//��ż�
	private double M;								//�����
	private double H=0;								//�Ѷ�ϵ��
	private double D=0;								//���ֶ�
	private double T=0;								//ʱ��ʹ����
	
	public int[] getQuestionIds() {
		return questionIds;
	}
	
	public void setQuestionIds(int[] questionIds) {
		this.questionIds = questionIds;
	}
	
	public double getM() {
		return M;
	}
	
	public void setM(double m) {
		M = m;
	}
	
	public double getH() {
		return H;
	}
	
	public void setH(double h) {
		H = h;
	}
	
	public double getD() {
		return D;
	}
	
	public void setD(double d) {
		D = d;
	}
	
	public double getT() {
		return T;
	}
	
	public void setT(double t) {
		T = t;
	}
	
	//�������
	public String toString() {
		return "��ż���" + Arrays.toString((this.questionIds)) 
				+ "\n����ȣ�" + this.M 
				+ "���Ѷ�ϵ����" + this.H 
				+ "�����ֶȣ�" + this.D
				+ "��ʱ��ʹ���ʣ�" + this.T;
	}
}
