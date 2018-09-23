package com.icbc.dmqs.AutoService;

import com.sun.tools.javac.util.ServiceLoader;

public class ServiceLoaderDemo {
    public static void main(String[] args){
        ServiceLoader<ServiceDemo> myService = ServiceLoader.load(ServiceDemo.class);
        for (ServiceDemo sd:myService){
            System.out.println(sd.getName());
        }
    }
}
