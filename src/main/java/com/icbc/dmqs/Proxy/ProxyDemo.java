package com.icbc.dmqs.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//定义项目接口
interface Subject {
    public String say(String name, int age);
}
// 定义真实项目
class RealSubject implements Subject {
    String name;
    RealSubject(){

    }

    RealSubject(String name){
        this.name=name;
    }
    public String say(String name, int age) {
        String n = this.name == null? name:this.name;
        return n + "  " + age;
    }
}
class MyInvocationHandler implements InvocationHandler {
    private Object obj = null;
    private int tag = 0;
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("进入invoke方法第"+(++tag)+"次： ");
        Object temp = method.invoke(this.obj, args);
        return temp;
    }
}
public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        System.out.println(sub.say("Rollen", 20));

        sub = (Subject) demo.bind(new RealSubject("Tylon"));
        System.out.println(sub.say("Rollen", 20));

        Subject testSub = new RealSubject();
        System.out.println(testSub.say("Byson",21));
    }
}