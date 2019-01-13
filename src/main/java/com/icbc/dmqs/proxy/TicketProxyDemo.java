package com.icbc.dmqs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 接口类
 */
interface Seller{
    /**
     * 获取票价
     * @return
     */
    public Integer getPrice();
}
/**
 * 真实卖家
 */
class RealSeller implements Seller{

    public Integer getPrice() {
        return 20;
    }
}
/**
 * 黑心卖家
 */
class FakeSeller implements Seller{

    public Integer getPrice() {
        return 40;
    }
}
/**
 * 中间商
 */
class TicketProxy implements InvocationHandler {

    private Object obj = null;
    private int fee;

    TicketProxy(){
        this.fee=10;
    }

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object price = method.invoke(this.obj,args);
        int i = (Integer)price + fee;
        return i;
    }
}

/**
 * @author: huangz
 */
public class TicketProxyDemo{
    public static void main(String[] args){
        TicketProxy tp = new TicketProxy();
        Seller seller = (Seller) tp.bind(new RealSeller());
        System.out.println("真实卖家："+new RealSeller().getPrice());
        System.out.println("中间商赚个辛苦费："+seller.getPrice());
        System.out.println("黑心卖家："+new FakeSeller().getPrice());
        System.out.println("中间商和黑心卖家："+((Seller)tp.bind(new FakeSeller())).getPrice());
    }
}
