package com.icbc.dmqs.Methods;

import com.icbc.dmqs.Attrs.ReflectInterface;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodsReflect implements ReflectInterface {
    public void test() {
        System.out.println("反射调用了MethodsReflect的test方法");//为一会TestReflect7的调用做准备
    }
    private static final long serialVersionUID = -255236662L;

    public static Method[] getDMethods(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Method methods[] = clazz.getDeclaredMethods();
        return methods;
    }
    public static Method[] getAMethods(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Method methods[] = clazz.getMethods();
        return methods;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("===================自身定义的方法===============");
        showMethods(getDMethods("com.icbc.dmqs.Methods.MethodsReflect"));
        System.out.println("===================所有方法===============");
        showMethods(getAMethods("com.icbc.dmqs.Methods.MethodsReflect"));
    }

    private static void showMethods(Method method[]) {
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print("方法名："+method[i].getName() + " ");//方法名字
            System.out.print("修饰: "+Modifier.toString(temp) + " ");//拿权限，他是包括了final、static的
            System.out.print("返回："+returnType.getName() + "  ");//返回类型
            for (int j = 0; j < para.length; ++j) {
                System.out.print("入参："+para[j].getName());//拿到参数名字
            }
            System.out.println();
            Class<?> exce[] = method[i].getExceptionTypes();//拿到方法异常内和抛出
            for (int k = 0; k < exce.length; ++k) {
                System.out.println("   异常："+exce[k].getName());//拿到异常名字
            }
        }
    }
}

