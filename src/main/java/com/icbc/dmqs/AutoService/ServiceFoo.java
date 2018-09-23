package com.icbc.dmqs.AutoService;

import com.google.auto.service.AutoService;

@AutoService(ServiceDemo.class)
public class ServiceFoo implements ServiceDemo{

    public String getName() {
        return this.getClass().getName();
    }
}
