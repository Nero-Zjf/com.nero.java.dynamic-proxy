package com.nero.java.dynamic.proxy.handler;

import com.nero.java.dynamic.proxy.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandler implements InvocationHandler {

    //代理的目标对象
    private UserService target;

    public UserHandler(UserService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // print implicit argument
        System.out.print("代理对象打印日志：" + target);
        // print method name
        System.out.print("." + method.getName() + "(");
        // print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        return method.invoke(target, args);
    }
}
