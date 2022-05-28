package com.lsh.class01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/28 4:39 下午
 * @desc ：自定义类加载器 继承java.lang.ClassLoader
 * 重写findClass（）方法
 * 使用该类加载器时调用loadClass（）方法
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        ///Users/LiuShihao/IdeaProjects/jvm-demo/target/classes/com/lsh/class01/HelloWorld.class
        String s = "/Users/LiuShihao/IdeaProjects/jvm-demo/target/classes/" + name.replaceAll("\\.", "/");
        System.out.println(s);
        File file = new File(s);
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) != 0){
                bos.write(b);
            }
            byte[] bytes = bos.toByteArray();
            fis.close();
            bos.close();
            return defineClass(name,bytes,0,bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("com.lsh.class01.HelloWorld");
        HelloWorld o = (HelloWorld)aClass.newInstance();
        o.m();
        System.out.println(myClassLoader.getClass().getClassLoader());
        System.out.println(myClassLoader.getParent());

    }

}
