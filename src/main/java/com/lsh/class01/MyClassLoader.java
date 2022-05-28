package com.lsh.class01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/28 4:39 下午
 * @desc ：自定义类加载器 继承java.lang.ClassLoader
 * 重写 findClass（）方法
 * 使用该类加载器时调用loadClass（）方法
 * Users/LiuShihao/Desktop/Demo.class
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("执行了MyClassLoader的findClass（）方法");
//        String s = "/Users/LiuShihao/IdeaProjects/jvm-demo/target/classes/" + name.replaceAll("\\.", "/")+".class";
        String s = "/Users/LiuShihao/Desktop/Demo.class";

        System.out.println("name:"+name);
        System.out.println(s);

        File file = new File(s);
        if (!file.exists()){
            System.out.println("File Not Fount:"+name);
            return super.findClass(name);
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[fis.available()];
            int length = 0;
            if ((length = fis.read(bytes))!= -1){
                bos.write(bytes,0,length);
            }
            System.out.println("____"+name);
            return defineClass(name,bos.toByteArray(),0,bos.toByteArray().length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
//        Class<?> aClass = myClassLoader.loadClass("com.lsh.class01.Demo");
        Class<?> aClass = myClassLoader.loadClass("Demo");
        System.out.println(aClass.getClassLoader());

        myClassLoader = new MyClassLoader();
//        Class<?> aClass1 = myClassLoader.loadClass("com.lsh.class01.Demo");
        Class<?> aClass1 = myClassLoader.loadClass("Demo");
        System.out.println(aClass.getClassLoader());
        System.out.println(aClass == aClass1);//判断加载出的类是否是同一个类

//        Demo o = (Demo)aClass.newInstance();
//        o.m();


//        Class<?> aClass1 = myClassLoader.loadClass("com.lsh.class01.Demo");



    }

}
