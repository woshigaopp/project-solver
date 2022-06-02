package com.dabao.api.data;

public class Result {
    private Status status;
    private String message;
    private String data;
    private long elapsed;

    public Result() {
    }

    public Result(Status status, String message, String data, long elapsed) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.elapsed = elapsed;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getElapsed() {
        return elapsed;
    }

    public void setElapsed(long elapsed) {
        this.elapsed = elapsed;
    }
}
