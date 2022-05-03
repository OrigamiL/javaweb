package com.weifang.reflectAll.reflectJk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.weifang.reflectAll.reflectJk.Jk");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            String modifier = Modifier.toString(constructors[i].getModifiers());
            System.out.println(modifier);
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();
            int parameterCount = constructors[i].getParameterCount();
            // System.out.println(parameterTypes.length);
            Jk jk=null;
            while(jk==null){
                try{
                if(parameterTypes.length==0)
                    jk = (Jk) constructors[i].newInstance();
                else if(parameterTypes.length==1)
                    jk = (Jk) constructors[i].newInstance(1);
                else if(parameterTypes.length==2)
                    jk = (Jk) constructors[i].newInstance(1,"a");
                }catch (Exception e){
                    constructors[i].setAccessible(true);
                    System.out.println("ok");
                }
            }
        }


    }
}
