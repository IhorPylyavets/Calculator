package com.goit.project.database.entity;

public class Computing {
    private static final long serialVersionUID = 1L;

    private Integer computingId;

    public Computing(String timeComputing, String expression, String result, Integer userId) {
        this.timeComputing = timeComputing;
        this.expression = expression;
        this.result = result;
        this.userId = userId;
    }

    private String timeComputing;
    private String expression;
    private String result;
    private Integer userId;

    public Computing() {}

    public Integer getComputingId() {
        return computingId;
    }

    public void setComputingId(Integer computingId) {
        this.computingId = computingId;
    }

    public String getTimeComputing() {
        return timeComputing;
    }

    public void setTimeComputing(String timeComputing) {
        this.timeComputing = timeComputing;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
