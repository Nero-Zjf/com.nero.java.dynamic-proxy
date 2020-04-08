package com.nero.java.dynamic.proxy;

import com.nero.java.dynamic.proxy.handler.UserHandler;
import com.nero.java.dynamic.proxy.service.UserService;
import com.nero.java.dynamic.proxy.service.UserServiceIml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        //定义InvocationHandler
        InvocationHandler handler = new UserHandler(new UserServiceIml());
        //生成代理类
        UserService userService = (UserService) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{UserService.class}, handler);

        System.out.println(userService.getName());
    }
}
