package com.boot.test.model;

import com.boot.test.anno.userIofoItf;

public class userBean {

    public userBean() {
    }

    public userBean(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Integer id;
    @userIofoItf("name")
    private String name;
    @userIofoItf("age")
    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
