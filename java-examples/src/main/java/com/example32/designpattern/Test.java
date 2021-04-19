package com.example32.designpattern;


import com.example32.designpattern.service.ServiceFactory;
import com.example32.designpattern.service.UserService;

public class Test {

    public static void main(String[] args) {
        // getBuilder();
        // getSingleton();
    }

    private static void getBuilder() {
        HttpClient client = new HttpClient.Builder("www.whyman.site", "8089")
                .mainThread(true)
                .cacheDir("d:/")
                .build();
    }

    private static void getSingleton() {
        UserService userService = ServiceFactory.getUserService();
        System.out.println(userService.welcome("BO"));
    }
}
