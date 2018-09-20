package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

public class Scenarist extends AbstractSaved{
    private String fullname;
    private int age;

    @Override
    public void save() {

    }

    public Scenarist() {
    }

    public Scenarist(String fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return fullname+" "+age;
    }
}
