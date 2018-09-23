package com.icbc.dmqs;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.icbc.dmqs.Goods");
        // 取得父类
        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("clazz的父类为：" + parentClass.getName());

        Goods goods1 = (Goods) clazz.newInstance();
        goods1.setId(12);
        goods1.setGoodsName("demo1");
        System.out.println(goods1);

        tryAllContructs(clazz);
    }

    //example: show all the constructors
    public static void tryAllContructs(Class<?> obj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?> cons[] = obj.getConstructors();
        for (int i = 0;i<cons.length;i++){
            Class<?> clazzs[] = cons[i].getParameterTypes();
            Object[] paras = new Object[clazzs.length];
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
                if (clazzs[j].getName().contains("Integer")){
                    paras[j] = 1;
                } else if (clazzs[j].getName().contains("String")) {
                    paras[j] = "abc";
                }
            }
            System.out.println(")");
            if (clazzs.length == 1){
                System.out.println(cons[i].newInstance(paras[0]));
            } else if (clazzs.length == 2) {
                System.out.println(cons[i].newInstance(paras[0],paras[1]));
            }
        }

    }

}