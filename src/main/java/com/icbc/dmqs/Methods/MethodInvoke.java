package com.icbc.dmqs.Methods;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoke {
    public String tag="1";
    public static void main(String[] args) throws Exception {
        String className = "com.icbc.dmqs.Methods.MethodReflect";
        String methodName = "getDMethods";
        String targetClass = "com.icbc.dmqs.Methods.MethodInvoke";

        //输出MethodInvoke类的所有自定义方法
        invokeMethod(className,methodName,targetClass);

        changeAttr();
    }

    public static void invokeMethod(String classnName,String arg,String targetClassName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.icbc.dmqs.Methods.MethodsReflect");

        Method method = clazz.getMethod("getDMethods", String.class);
        Method[] meths = (Method[]) method.invoke(clazz.newInstance(), "com.icbc.dmqs.Methods.MethodInvoke");
        for (Method m : meths) {
            System.out.println(m.getName());
        }
    }
    public static void changeAttr() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        MethodInvoke obj = (MethodInvoke) Class.forName("com.icbc.dmqs.Methods.MethodInvoke").newInstance();
        System.out.println("Set tag to "+obj.tag+" before change it");
        Field field = Class.forName("com.icbc.dmqs.Methods.MethodInvoke").getDeclaredField("tag");
        field.setAccessible(true);
        field.set(obj,"2");
        System.out.println("Set tag to "+obj.tag+" after change it");
    }

}
