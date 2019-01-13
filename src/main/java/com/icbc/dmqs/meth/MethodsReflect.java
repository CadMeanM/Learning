package com.icbc.dmqs.meth;

import com.icbc.dmqs.attrs.ReflectInterface;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author: huangz
 * 用于展示一个类的自定义方法和所有方法
 */

public class MethodsReflect implements ReflectInterface {
    public void test() {
        System.out.println("反射调用了MethodsReflect的test方法");
    }
    private static final long serialVersionUID = -255236662L;

    public static Method[] getDMethods(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Method[] methods = clazz.getDeclaredMethods();
        return methods;
    }
    public static Method[] getAMethods(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Method[] methods = clazz.getMethods();
        return methods;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("===================自身定义的方法===============");
        showMethods(getDMethods("com.icbc.dmqs.meth.MethodsReflect"));
        System.out.println("===================所有方法===============");
        showMethods(getAMethods("com.icbc.dmqs.meth.MethodsReflect"));
    }

    private static void showMethods(Method[] method) {
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?>[] para = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print("方法名："+method[i].getName() + " ");
            System.out.print("修饰: "+Modifier.toString(temp) + " ");
            System.out.print("返回："+returnType.getName() + "  ");
            for (int j = 0; j < para.length; ++j) {
                System.out.print("入参："+para[j].getName());
            }
            System.out.println();
            Class<?>[] exce = method[i].getExceptionTypes();
            for (int k = 0; k < exce.length; ++k) {
                System.out.println("   异常："+exce[k].getName());
            }
        }
    }
}

