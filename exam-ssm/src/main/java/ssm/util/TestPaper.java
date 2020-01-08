package ssm.util;

import ssm.model.Shiti;
import ssm.model.Solution;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class TestPaper 
{
	//�Ծ������
	private int G0;								//�ܷ�ֵ
	private int N0;								//������
	
	//�Ծ�����Ӱ������
	private int T0;								//����ʱ�������ӣ�
	private int Q[][];							//�Ծ����ͣ�6x2�������������͵������
	private double H_lb;						//�Ѷ�ϵ���½磨0-1��
	private double H_ub;						//�Ѷ�ϵ���Ͻ磨0-1��
	private double D_lb;						//���ֶ��½磨0-1��
	private double D_ub;						//���ֶ��Ͻ磨0-1��
	
	//�Ծ��⼯�ͽ⼯
	private ArrayList<Shiti> tqList=null;
	private Solution solution=null;
	
	//�Ծ���Ŀ��Ӧ������
	private ArrayList<Integer> QI=new ArrayList<Integer>();
	
	//���캯��
	public TestPaper(int T0, int Q[][], ArrayList<Shiti> tqList, double H_lb, double H_ub, double D_lb, double D_ub, Solution solution)
	{
		//��ʼ��Ӱ������
		this.T0=T0;
		this.Q=Q;
		this.H_lb=H_lb;
		this.H_ub=H_ub;
		this.D_lb=D_lb;
		this.D_ub=D_ub;
		
		//��ʼ��������, �Լ���Ŀ�ֽ����
		this.N0=0;
		for(int i=0; i<this.Q.length; i++)
		{
			this.N0+=this.Q[i][1];
			for(int j=0; j<this.Q[i][1]; j++)
			{
				this.QI.add(i);
			}
		}
		
		//��ʼ���ܷ�ֵ
		this.G0=0;
		for(int i=0; i<this.QI.size(); i++)
		{
			this.G0+=Q[this.QI.get(i)][0];
		}
		
		//��ʼ�����⼯�ͽ⼯
		this.tqList=tqList;
		this.solution=solution;
	}
	
	//�������������б��е����
	private int testQuestionId2listIndex(int testQuestionId)
	{
		int listIndex=-1;
		for(int i=0; i<this.tqList.size(); i++)
		{
			Shiti shiti=this.tqList.get(i);
			if(shiti.getShitiid()==testQuestionId)
			{
				listIndex=i;
				break;
			}
		}
		return listIndex;
	}
	
	//���������Ծ�
	//输出所组的试卷
	public String toString()
	{
		//初始化为空字符串
		String paper="";

		//添加标题
		paper+="考试时长："+this.T0+"分钟, 总分值："+this.G0+"分, 总题数："+this.N0+"个\n\n";

		//初始化题号栈
		Queue<String> queTitle1=new LinkedList<String>();
		Queue<String> queTitle2=new LinkedList<String>();
		String titleNumbers[]= {"一", "二", "三", "四", "五", "六"};
		String titles[]= {"单选题", "判断题", "多选题", "填空题", "画图题", "主观题"};
		for(int i=0; i<this.Q.length; i++)
		{
			queTitle1.add(titleNumbers[i]);
		}
		for(int i=1; i<=this.N0; i++)
		{
			queTitle2.add(i+"");
		}

		//循环输出题目
		for(int i=0; i<this.Q.length; i++)
		{
			if(this.Q[i][1]>0)
			{
				//一级标题
				paper+=queTitle1.poll()+"、"+titles[i]+"(共"+this.Q[i][1]+"题, 每题"+this.Q[i][0]+"分)\n";

				//二级标题
				for(int j=0; j<this.Q[i][1]; j++)
				{
					int k=Integer.parseInt(queTitle2.poll());
					int listIndex=this.testQuestionId2listIndex(this.solution.getQuestionIds()[k-1]);
					paper+=k+". "+this.tqList.get(listIndex).getContent()+"\n\n";
				}
			}
		}

		//换行处理
		while(paper.indexOf("\\n")>=0)
		{
			int k=paper.indexOf("\\n");
			paper=paper.substring(0, k)+"\n"+paper.substring(k+2);
		}

		//返回字符串
		return paper;
	}
	
	//��ȡ��ǰʱ��
	public static String getTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
		return df.format(new Date());
	}
	
	//����TXT�ļ�
	public static void writeTo(File file, String str)
	{
		try
		{
			FileWriter fw=new FileWriter(file);
			fw.write(str);
			fw.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
