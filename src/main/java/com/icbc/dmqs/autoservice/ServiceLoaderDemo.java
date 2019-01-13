package com.icbc.dmqs.autoservice;

import com.sun.tools.javac.util.ServiceLoader;

/**
 * @author: huangz
 */
public class ServiceLoaderDemo {
    public static void main(String[] args){
        ServiceLoader<ServiceDemo> myService = ServiceLoader.load(ServiceDemo.class);
        for (ServiceDemo sd:myService){
            System.out.println(sd.getName());
        }
    }
}
