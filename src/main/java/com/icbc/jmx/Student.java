package com.icbc.jmx;

public class Student implements StudentMBean{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void printName(){
        System.out.println(this.name);
    }
}

