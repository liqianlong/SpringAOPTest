package com.loqolo;

import com.loqolo.Service.ISayHello;
import com.loqolo.impl.SayHelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by liqianlong on 16/1/22.
 */
public class SayHelloTest {
    public static void main(String[] args) {
        //定义目标类
        ISayHello sayHello = new SayHelloImpl();
        //构造代理类
        InvocationHandler handler = new SayHelloProxy(sayHello);

        ISayHello sayHelloProxy = (ISayHello)Proxy.newProxyInstance(sayHello.getClass().getClassLoader(), sayHello.getClass().getInterfaces(), handler);

        sayHelloProxy.sayHello();

    }
}
