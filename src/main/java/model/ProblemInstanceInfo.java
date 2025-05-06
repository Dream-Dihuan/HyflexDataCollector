package model;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ProblemInstanceInfo {
    @Excel(name = "heuristic算法", orderNum = "0")
    private String heuristic;

    @Excel(name = "问题领域", orderNum = "1")
    private String problemDomain;

    @Excel(name = "实例", orderNum = "2")
    private String instance;

    @Excel(name = "运行", orderNum = "3")
    private String run;

    @Excel(name = "最佳值", orderNum = "4")
    private Double bestValue;

    @Excel(name = "超时时间", orderNum = "5")
    private Double timeout;

    @Excel(name = "耗时", orderNum = "6")
    private Double timeMillis;

    @Excel(name = "启发式调用次数", orderNum = "7")
    private Double heuristicCallTimes;

    @Excel(name = "instanceScore", orderNum = "8")
    private Double instanceScore;

    @Excel(name = "totalScore", orderNum = "9")
    private Double totalScore;


    public ProblemInstanceInfo() {
    }
    public ProblemInstanceInfo(String heuristic, String problemDomain, String instance, String run, Double bestValue, Double timeout, Double timeMillis, Double heuristicCallTimes, Double instanceScore, Double totalScore) {
        this.heuristic = heuristic;
        this.problemDomain = problemDomain;
        this.instance = instance;
        this.run = run;
        this.bestValue = bestValue;
        this.timeout = timeout;
        this.timeMillis = timeMillis;
        this.heuristicCallTimes = heuristicCallTimes;
        this.instanceScore = instanceScore;
        this.totalScore = totalScore;
    }

    public ProblemInstanceInfo(String method, String problemDomain, String instance, String run, Double bestValue, Double timeout, Double timeMillis, Double heuristicCallTimes) {
        this.heuristic=method;
        this.problemDomain = problemDomain;
        this.instance = instance;
        this.run = run;
        this.bestValue = bestValue;
        this.timeout = timeout;
        this.timeMillis = timeMillis;
        this.heuristicCallTimes = heuristicCallTimes;
    }

    public String getProblemDomain() {
        return problemDomain;
    }

    public void setProblemDomain(String problemDomain) {
        this.problemDomain = problemDomain;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public double getBestValue() {
        return bestValue;
    }

    public void setBestValue(double bestValue) {
        this.bestValue = bestValue;
    }

    public double getTimeout() {
        return timeout;
    }

    public void setTimeout(double timeout) {
        this.timeout = timeout;
    }

    public double getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(double timeMillis) {
        this.timeMillis = timeMillis;
    }

    public double getHeuristicCallTimes() {
        return heuristicCallTimes;
    }

    public void setHeuristicCallTimes(double heuristicCallTimes) {
        this.heuristicCallTimes = heuristicCallTimes;
    }

    public void setBestValue(Double bestValue) {
        this.bestValue = bestValue;
    }

    public void setTimeout(Double timeout) {
        this.timeout = timeout;
    }

    public void setTimeMillis(Double timeMillis) {
        this.timeMillis = timeMillis;
    }

    public void setHeuristicCallTimes(Double heuristicCallTimes) {
        this.heuristicCallTimes = heuristicCallTimes;
    }

    public Double getInstanceScore() {
        return instanceScore;
    }

    public void setInstanceScore(Double instanceScore) {
        this.instanceScore = instanceScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public String getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(String heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public String toString() {
        return "ProblemInstanceInfo{" +
                "heuristic='" + heuristic + '\'' +
                ", problemDomain='" + problemDomain + '\'' +
                ", instance='" + instance + '\'' +
                ", run='" + run + '\'' +
                ", bestValue=" + bestValue +
                ", timeout=" + timeout +
                ", timeMillis=" + timeMillis +
                ", heuristicCallTimes=" + heuristicCallTimes +
                ", instanceScore=" + instanceScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
