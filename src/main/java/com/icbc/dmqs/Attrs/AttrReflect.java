package com.icbc.dmqs.Attrs;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AttrReflect implements ReflectInterface {
    private static final long serialVersionUID = -286258502L;
    public int subAttr = 0;
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.icbc.dmqs.Attrs.AttrReflect");
        System.out.println("===============本类属性===============");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println("修饰符:"+priv + " 类型:" + type.getName() + " 变量名:" + field[i].getName() + ";");
        }

        System.out.println("==========实现的接口或者父类的属性以及本类的公有属性名字==========");
        // 取得实现的接口或者父类的属性以及本类的公有属性名字
        Field[] fields1 = clazz.getFields();
        for (int j = 0; j < fields1.length; j++) {
            // 权限修饰符
            int mo = fields1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = fields1[j].getType();
            System.out.println("修饰符:"+priv + " 类型:" + type.getName() + " 变量名:" + fields1[j].getName() + ";");
        }
    }

    public void test() {
        System.out.println("entry AttrReflect Class");
    }
}
