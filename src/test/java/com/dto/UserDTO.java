package com.dto;

import java.util.Map;

public class UserDTO {
    private String emailAddress;
    private String password;
    private String loginVerify;

    private Map<String, String> additionalFileds;

    public String get(String key) {
        return additionalFileds.get(key);
    }

    public boolean has(String key) {
        return additionalFileds.containsKey(key);
    }


    public UserDTO(String emailAddress, String password, String loginVerify, Map<String, String> additionalFileds) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.loginVerify = loginVerify;
        this.additionalFileds = additionalFileds;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginVerify() {
        return loginVerify;
    }

    public void setLoginVerify(String loginVerify) {
        this.loginVerify = loginVerify;
    }


}
