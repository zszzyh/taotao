package com.cwb.bean;

/**
 * Created by cwb on 18/8/8.
 */
public class UpLoadFileResult {
    private int error;
    private String message;
    private String url;

    public int getError() {
        return error;
    }

    public UpLoadFileResult setError(int error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UpLoadFileResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UpLoadFileResult setUrl(String url) {
        this.url = url;
        return this;
    }
}