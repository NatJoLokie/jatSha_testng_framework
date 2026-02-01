package com.ui.pojo;

public class Environment {
    private String url;
    private int MAX_RETRY_ATTEMPT;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMAX_RETRY_ATTEMPT() {
        return MAX_RETRY_ATTEMPT;
    }

    public void setMAX_RETRY_ATTEMPT(int MAX_RETRY_ATTEMPT) {
        this.MAX_RETRY_ATTEMPT = MAX_RETRY_ATTEMPT;
    }


}
