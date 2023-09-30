package com.authenticatordemo.authenticatordemo.models.rest;

import com.authenticatordemo.authenticatordemo.models.User;

public class Response {
    private User user;
    private String jwt;

    public Response(){
        super();
    }

    public Response(User user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

}
