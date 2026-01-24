package com.dto;

public class UserDTO {
    private String emailAddress;
    private String password;
    private String loginVerify;

    private String dob;

    public String getDob() {
        return dob;
    }

    public UserDTO() {
    }

    public UserDTO(String emailAddress, String password, String loginVerify) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.loginVerify = loginVerify;
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
