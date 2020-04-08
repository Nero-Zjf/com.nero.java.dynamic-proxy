package com.nero.java.dynamic.proxy.service;

public class UserServiceIml implements UserService{
    @Override
    public String getName() {
        return "userName";
    }
}
