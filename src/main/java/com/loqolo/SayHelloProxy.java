package com.loqolo;

import com.loqolo.Service.ISayHello;
import com.loqolo.impl.SayHelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liqianlong on 16/1/22.
 */
public class SayHelloProxy implements InvocationHandler{

    private Object target;

    public SayHelloProxy(Object target){
        this.target=target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        try{
            System.out.println("before,sayHello");
            obj= method.invoke(target,args);
            System.out.println("after,sayHello");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error,sayHello");
        }
        return obj;
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
