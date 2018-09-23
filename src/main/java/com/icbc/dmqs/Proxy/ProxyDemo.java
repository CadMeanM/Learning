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
    public String say(String name, int age) {
        return name + "  " + age;
    }
}
class MyInvocationHandler implements InvocationHandler {
    private Object obj = null;
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("进入invoke方法: ");
        Object temp = method.invoke(this.obj, args);
        return temp;
    }
}
public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        System.out.println(sub.say("Rollen", 20));

        Subject testSub = new RealSubject();
        System.out.println(testSub.say("Rollen2",21));
    }
}