package ssm.util;

import java.util.*;

import ssm.model.Question;
import ssm.model.Solution;

public class GA_exam
{
	//试卷基本量
	private int G0;								//总分值
	private int N0;								//总题数

	//试卷质量影响因素
	private int T0;								//考试时长（分钟）
	private int Q[][];							//试卷题型（6x2），包含个数和单题分数
	private double H_lb;						//难度系数下界（0-1）
	private double H_ub;						//难度系数上界（0-1）

	public int getT0() {
		return T0;
	}

	public void setT0(int t0) {
		T0 = t0;
	}

	public int[][] getQ() {
		return Q;
	}

	public void setQ(int[][] q) {
		Q = q;
	}

	public double getH_lb() {
		return H_lb;
	}

	public void setH_lb(double h_lb) {
		H_lb = h_lb;
	}

	public double getH_ub() {
		return H_ub;
	}

	public void setH_ub(double h_ub) {
		H_ub = h_ub;
	}

	public double getD_lb() {
		return D_lb;
	}

	public void setD_lb(double d_lb) {
		D_lb = d_lb;
	}

	public double getD_ub() {
		return D_ub;
	}

	public void setD_ub(double d_ub) {
		D_ub = d_ub;
	}

	private double D_lb;						//区分度下界（0-1）
	private double D_ub;						//区分度上界（0-1）

	//数据库数据
	private ArrayList<Question> qList=null;		//题目列表

	//试卷题目对应的题型
	private ArrayList<Integer> QI=new ArrayList<Integer>();

	//试题题目对应的题型号起始位置
	private ArrayList<Integer> QII=new ArrayList<Integer>();

	//数据库题目排序后对应的题型号起始位置
	private ArrayList<Integer> QIDI=new ArrayList<Integer>();

	//产生随机数
	private Random rand=new Random();

	/**
	 * 交叉概率pc=0.5
	 * 变异概率pm=0.1
	 */
	//遗传算法参数
	private int n=20;							//种群规模（20-160）
	private double pc=0.5;						//交叉概率（0.5-1.0）
	private double pm=0.1;						//变异概率（0.001-0.1）
	private int gen=100;						//进化代数（100-1000）

	//构造函数，含有考试时长和题型
	public GA_exam(int T0, int Q[][], ArrayList<Question> qList)
	{
		this(T0, Q, qList, 0, 1, 0, 1);
	}

	//构造函数，含有所有所需参数
	public GA_exam(int T0, int Q[][], ArrayList<Question> qList, double H_lb, double H_ub, double D_lb, double D_ub)
	{
		//初始化影响因素
		this.T0=T0;
		this.Q=Q;
		this.H_lb=H_lb;
		this.H_ub=H_ub;
		this.D_lb=D_lb;
		this.D_ub=D_ub;

		//初始化数据库题目
		this.qList=qList;
		Collections.sort(this.qList);
		int qid=0;
		for(int i=0; i<this.qList.size(); i++)
		{
			if(this.qList.get(i).getQid()==qid)
			{
				this.QIDI.add(i);
				qid++;
			}
		}

		//初始化总题数, 以及题目分界序号
		this.N0=0;
		for(int i=0; i<this.Q.length; i++)
		{
			//添加试题题目对应的题型号起始位置
			this.QII.add(this.N0);
			//添加试卷题目对应的题型
			this.N0+=this.Q[i][1];
			for(int j=0; j<this.Q[i][1]; j++)
			{
				this.QI.add(i);
			}
		}

		//初始化总分值
		this.G0=0;
		for(int i=0; i<this.QI.size(); i++)
		{
			this.G0+=Q[this.QI.get(i)][0];
		}
	}

	//获取算法求解出的最佳解集
	public Solution getBestSolution()
	{
		//初始化最佳个体Single
		Single bestSingle=null;

		//初始化种群
		ArrayList<Single> sList=new ArrayList<Single>();
		for(int i=0; i<n; i++)
		{
			//获取个体Single
			Single s=this.getSubjectToSingle(new Single());
			//加入种群中
			sList.add(s);
		}

		//遗传算法求解
		for(int i=0; i<this.gen; i++)
		{
			//交叉次数
			int nc=rand.nextInt((int)Math.round(this.pc*this.n));

			//进行交叉
			for(int j=0; j<nc; j++)
			{
				//随机产生交叉的个体序号
				int n1=rand.nextInt(this.n);
				int n2=rand.nextInt(this.n);
				//获取需要交叉的个体
				Single s1=sList.get(n1);
				Single s2=sList.get(n2);
				//一次交叉
				Single s=this.getSubjectToSingle(s1.cross(s2));
				//加入种群中
				sList.add(s);
			}

			//变异次数
			int nm=rand.nextInt((int)Math.round(this.pm*this.n));

			//进行变异
			for(int j=0; j<nm; j++)
			{
				//随机产生交叉的个体序号
				int n1=rand.nextInt(this.n);
				//获取需要交叉的个体
				Single s1=sList.get(n1);
				//一次变异
				Single s=this.getSubjectToSingle(s1.change());
				//加入种群中
				sList.add(s);
			}

			//种群按个体满意度M降序
			Collections.sort(sList);

			//优胜劣汰
			while(sList.size()>this.n)
			{
				//随机产生淘汰的个体序号
				int n1=rand.nextInt(sList.size()/2)+(sList.size()+1)/2;
				//淘汰n1
				sList.remove(n1);
			}

			//自适应改变交叉概率pc、变异概率pm
			this.pc=1-(sList.get(0).getM()-sList.get(sList.size()-1).getM())*0.3;
			this.pm=1-(sList.get(0).getM()-sList.get(sList.size()-1).getM())*0.9;
		}

		//存储最佳个体Single
		bestSingle=sList.get(0);

		//存储最佳解集
		Solution bestSolution=new Solution();
		bestSolution.setM(bestSingle.getM());
		bestSolution.setH(bestSingle.getH());
		bestSolution.setD(bestSingle.getD());
		bestSolution.setT(bestSingle.getT());
		bestSolution.setQuestionIds(bestSingle.getQuestionIds());

		return bestSolution;
	}

	//获取约束条件下的个体Single
	private Single getSubjectToSingle(Single s)			//s为新建的个体
	{
		//求解评价指标和满意度
		s.doSolution();
		//获取个体的评价指标
		double H=s.getH();
		double D=s.getD();
		double T=s.getT();
		//若不满足约束条件，则设置M=0
		if(!this.isSubjectTo(H, D, T))
		{
			s.setM(0);
		}
		//返回个体Single
		return s;
	}

	//判断是否满足约束条件
	private boolean isSubjectTo(double H, double D, double T)
	{
		return (H_lb<=H&&H<=H_ub)&&(D_lb<=D&&D<=D_ub)&&(0<=T&&T<=1);
	}

	//遗传算法个体类
	private class Single implements Comparable<Single>
	{
		//初始化题目列表序号数组
		private int ids[]=new int[N0];

		//试卷满意度
		private double M=0;

		//试卷评价指标
		private double H=1;								//难度系数
		private double D=0;								//区分度
		private double T=1;								//时间使用率

		public Single()
		{
			for(int i=0; i<this.ids.length; i++)
			{
				//初始化起始时间
				long ft=System.currentTimeMillis();
				while(true)
				{
					//随机生成在题型区间的题号, 包括qidi_begin, 但不包括qidi_end
					int qidi_begin=QIDI.get(QI.get(i));
					int qidi_end=QI.get(i)+1<6?QIDI.get(QI.get(i)+1):qList.size();
					int id=rand.nextInt(qidi_end-qidi_begin)+qidi_begin;
					boolean used=false;
					//检查是否重复
					for(int j=QII.get(QI.get(i)); j<i; j++)
					{
						if(this.ids[j]==id)
						{
							used=true;
							break;
						}
					}
					//若不重复，则跳出循环
					if(!used)
					{
						this.ids[i]=id;
						break;
					}

					//超时跳出
					if(System.currentTimeMillis()-ft>1000)
					{
						try {
							throw new Exception("生成种群个体时，超时！");
						} catch (Exception e) {
							e.printStackTrace();
							break;
						}
					}
				}
			}
		}

		public Single(Single s)
		{
			for(int i=0; i<this.ids.length; i++)
			{
				this.ids[i]=s.ids[i];
			}
		}

		//获取题号
		public int[] getQuestionIds()
		{
			int questionIds[]=new int[N0];
			for(int i=0; i<this.ids.length; i++)
			{
				//获取问题集
				Question question=qList.get(this.ids[i]);
				//赋值题号
				questionIds[i]=question.getQ();
			}
			return questionIds;
		}

		public double getM()
		{
			return this.M;
		}

		public void setM(double M)
		{
			this.M=M;
		}

		public double getH()
		{
			return this.H;
		}

		public double getD()
		{
			return this.D;
		}

		public double getT()
		{
			return T;
		}

		//比较个体Single的大小，按满意度M比较降序
		public int compareTo(Single s) {
			if(this.M==s.M)
				return 0;
			//降序
			return this.M<M?1:-1;
		}

		//目标函数——满意度的求解
		public void doSolution()
		{
			//初始化评价指标
			this.M=0;
			this.H=0;
			this.D=0;
			this.T=0;

			//计算评价指标
			for(int i=0; i<this.ids.length; i++)
			{
				//获取问题集
				Question question=qList.get(this.ids[i]);
				//计算难度系数H
				this.H+=question.getH()*Q[QI.get(i)][0]*1.0/G0;
				//计算区分度D
				this.D+=question.getD()*Q[QI.get(i)][0]*1.0/G0;
				//计算时间使用率
				this.T+=question.getT()/T0;
			}
			//满意度M
			this.M=(2+this.D-this.H-this.T)/3;
		}

		//个体与个体交叉
		public Single cross(Single s)
		{
			//新的个体
			Single s_new=new Single(this);

			//单点交叉
			int qid=rand.nextInt(Q.length);						//共有6种题型
			if(rand.nextDouble()>0.5) {
				for(int i=QII.get(qid); i<s_new.ids.length; i++)
				{
					s_new.ids[i]=s.ids[i];
				}
			} else {
				for(int i=0; i<QII.get(qid); i++)
				{
					s_new.ids[i]=s.ids[i];
				}
			}

			//判断个体是否变好, 并返回新个体
			if(this.isBetter(s_new)) {
				return s_new;
			} else {
				return this;
			}
		}

		//个体变异
		public Single change()
		{
			//新的个体
			Single s_new=new Single(this);

			//随机选点变异
			for(int i=0; i<s_new.ids.length; i+=1)
			{
				//初始化起始时间
				long ft=System.currentTimeMillis();
				while(true)
				{
					//生成对应题型区间的题号, 包括qidi_begin, 但不包括qidi_end
					int qidi_begin=QIDI.get(QI.get(i));
					int qidi_end=QI.get(i)+1<6?QIDI.get(QI.get(i)+1):qList.size();
					int id=rand.nextInt(qidi_end-qidi_begin)+qidi_begin;
					//检查是否重复
					boolean used=false;
					int id_end=QI.get(i)+1<6?QII.get(QI.get(i)+1):s_new.ids.length;
					for(int j=QII.get(QI.get(i)); j<id_end; j++)
					{
						if(j!=i&&s_new.ids[j]==id)
						{
							used=true;
							break;
						}
					}
					//若不重复，则跳出循环
					if(!used)
					{
						//判断个体是否变好
						if(s_new.isBetter(i, id))
						{
							s_new.ids[i]=id;
						}
						break;
					}

					//超时跳出
					if(System.currentTimeMillis()-ft>1000)
					{
						try {
							throw new Exception("个体染色体变异，超时！");
						} catch (Exception e) {
							e.printStackTrace();
							break;
						}
					}
				}
			}

			//返回新个体
			return s_new;
		}

		//判断个体是否变好
		private boolean isBetter(Single s_new)
		{
			//原满意度
			this.doSolution();
			if(!GA_exam.this.isSubjectTo(this.getH(), this.getD(), this.getT()))
			{
				this.setM(0);
			}
			//现满意度
			s_new.doSolution();
			if(!GA_exam.this.isSubjectTo(s_new.getH(), s_new.getD(), s_new.getT()))
			{
				s_new.setM(0);
			}
			//比较两个满意度
			return this.getM()<s_new.getM();
		}

		private boolean isBetter(int i, int id_new)
		{
			//新的个体
			Single s_new=new Single(this);
			s_new.ids[i]=id_new;

			//比较两个满意度
			return this.isBetter(s_new);
		}
	}

}
