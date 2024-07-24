package com.chatapp.dto;

public class UserDto {
    private String userid;
    private char [] password;
    public UserDto(String userid, char [] password){
        this.userid = userid;
        this.password = password;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
