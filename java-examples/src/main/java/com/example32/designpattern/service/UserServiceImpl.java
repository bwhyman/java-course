package com.example32.designpattern.service;

class UserServiceImpl implements UserService {
    @Override
    public String welcome(String name) {
        return "Welcome, " + name;
    }


}
