package com.samuel.user;

import com.samuel.myspringboot.core.MySpringApplication;
import com.samuel.myspringboot.core.MySpringBootApplication;

@MySpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        MySpringApplication.run(UserApplication.class);
    }

}
