package ssm.model;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class GA_Exam_model {
    private String t0;								//考试时长（分钟）
    String [] score;
    String[] num;
   				//试卷题型（6x2），包含个数和单题分数
    private String h_ub;						//难度系数上界（0-1）
    private String h_lb;						//难度系数下界（0-1）


    private String d_ub;						//区分度上界（0-1）
    private String d_lb;						//区分度下界（0-1）

    public String getT0() {
        return t0;
    }

    public void setT0(String t0) {
        this.t0 = t0;
    }

    public String getH_ub() {
        return h_ub;
    }

    public void setH_ub(String h_ub) {
        this.h_ub = h_ub;
    }

    public String getH_lb() {
        return h_lb;
    }

    public void setH_lb(String h_lb) {
        this.h_lb = h_lb;
    }

    public String getD_ub() {
        return d_ub;
    }

    public void setD_ub(String d_ub) {
        this.d_ub = d_ub;
    }

    public String getD_lb() {
        return d_lb;
    }

    public void setD_lb(String d_lb) {
        this.d_lb = d_lb;
    }

    public String[] getScore() {
        return score;
    }

    public void setScore(String[] score) {
        this.score = score;
    }

    public String[] getNum() {
        return num;
    }

    public void setNum(String[] num) {
        this.num = num;
    }
}
