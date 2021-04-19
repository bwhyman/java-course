package com.example32.designpattern.service;

public class ServiceFactory {
    private static final UserService userService = create();
    private static UserService create() {
        return new UserServiceImpl();
    }
    // 延迟加载，单例，线程安全，隐藏接口的具体实现
    public static UserService getUserService() {
        return userService;
    }
}
