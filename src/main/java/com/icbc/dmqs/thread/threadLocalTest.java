package com.icbc.dmqs.thread;

public class threadLocalTest {
    public static void main(String[] args) throws Exception
    {
        ThreadLocalThread a = new ThreadLocalThread("ThreadA");
        ThreadLocalThread b = new ThreadLocalThread("ThreadB");
        ThreadLocalThread c = new ThreadLocalThread("ThreadC");
        a.start();
        b.start();
        c.start();
    }
}
