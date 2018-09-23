package com.icbc.dmqs.Methods;

import java.lang.reflect.Method;

public class MethodInvoke {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.icbc.dmqs.Methods.MethodsReflect");
        // 调用TestReflect类中的reflect1方法
        Method method = clazz.getMethod("getAMethods", String.class);
        Method[] meths = (Method[]) method.invoke(clazz.newInstance(),"com.icbc.dmqs.Methods.MethodsReflect");
        for (Method m: meths){
            System.out.println(m.getName());
        }
//        // Java 反射机制 - 调用某个类的方法1.
//        // 调用TestReflect的reflect2方法
//        method = clazz.getMethod("reflect2", int.class, String.class);
//        method.invoke(clazz.newInstance(), 20, "辅助");
//        // Java 反射机制 - 调用某个类的方法2.
//        // age -> 20. name -> 辅助
//
//        Class<?> clazz2 = Class.forName("com.fuzhu.reflect.TestReflect6");
//        Method method2 = clazz2.getMethod("test");
//        method2.invoke(clazz2.newInstance());
//        //请看回TestReflect6 的test方法
    }

}
