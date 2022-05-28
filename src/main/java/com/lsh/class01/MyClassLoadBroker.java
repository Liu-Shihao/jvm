package com.lsh.class01;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/28 6:46 下午
 * @desc ：
 * 自定义类加载器，打破双亲委派机制
 * 重写loadClass（）方法可以打破双亲委派机制
 *
 * /Users/LiuShihao/IdeaProjects/jvm-demo/target/classes/cn/com/wyt/Demo.class
 *
 * 控制台打印：
 * 加载：com.lsh.class01.HelloWorld
 * 加载：java.lang.Object
 * File Not Found：java.lang.Object
 * null
 * com.lsh.class01.MyClassLoadBroker@511d50c0
 * 加载：com.lsh.class01.HelloWorld
 * 加载：java.lang.Object
 * File Not Found：java.lang.Object
 * com.lsh.class01.MyClassLoadBroker@5e2de80c
 * false
 *
 * 由控制台打印输出分析可知：
 * 在使用自定义加载Demo类的时候 ，还首先加载了它的父类Object
 *
 *
 *
 */
public class MyClassLoadBroker extends ClassLoader  {

    /**
     * 重写了loadClass（）方法，破坏了双亲委派机制，不在向上寻找父类加载器，通过自定义的类加载直接加载
     * 通过System.out.println(aClass == aClass1); 为 false 说明每次加载的类是不同的，此时不能保证类的唯一性了！
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String s = "/Users/LiuShihao/IdeaProjects/jvm-demo/target/classes/" + name.replaceAll("\\.", "/")+".class";
        File file = new File(s);
        System.out.println("加载："+name);
        if (!file.exists()){
            System.out.println("File Not Found："+name);
            return super.loadClass(name);
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            return defineClass(name,bytes,0,bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.loadClass(name);

    }

    public static void main(String[] args)throws Exception {
        MyClassLoadBroker myClassLoadBroker = new MyClassLoadBroker();
        Class<?> aClass = myClassLoadBroker.loadClass("com.lsh.class01.HelloWorld");

        System.out.println(aClass.getClass().getClassLoader());
        System.out.println(aClass.getClassLoader());

        myClassLoadBroker = new MyClassLoadBroker();
        Class<?> aClass1 = myClassLoadBroker.loadClass("com.lsh.class01.HelloWorld");
        System.out.println(""+aClass1.getClassLoader());
        System.out.println(aClass == aClass1);

    }
}
