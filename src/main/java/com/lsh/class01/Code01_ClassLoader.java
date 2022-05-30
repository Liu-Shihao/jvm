package com.lsh.class01;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/26 9:16 下午
 * @desc ：类加载器 分层 注意：父加载器不是继承关系
 * 1. BootstrapClassLoader  C++ 编写，子啊Java中没有对应的类，所以打印返回是空值
 * 2. ExtClassLoader
 * 3. AppClassLoader
 * 4. CustomClassLoader
 *
 * JVM类加载机制的三种特性
 * 1. 全盘负责  当一个类加载器负责加载某个Class时，该Class所依赖的和引用的其他Class也将由 该类加载器负责载入，除非显示使用另外一个类加载器来载入
 * 2. 父类委托（双亲委派）是指子类加载器如果没有加载过该目标类，就先委托父类加载器加载该 目标类，只有在父类加载器找不到字节码文件的情况下才从自己的类路径中查找并装载目标类。
 * 3. 缓存机制   将会保证所有加载过的Class都将在内存中缓存，当程序中需要使用某个 Class时，类加载器先从内存的缓存区寻找该Class，只有缓存区不存在，系统才会读取该类对应 的二进制数据，并将其转换成Class对象，存入缓存区。这就是为什么修改了Class后，必须重启 JVM，程序的修改才会生效.对于一个类加载器实例来说，相同全名的类只加载一次，即 loadClass方法不会被重复调用。
 *
 *  缓存机制，缓存机制将会保证所有加载过的Class都将在内存中缓存，
 *  当程序中需要使用某个 Class时，类加载器先从内存的缓存区寻找该Class，
 *  只有缓存区不存在，系统才会读取该类对应 的二进制数据，并将其转换成Class对象，
 *  存入缓存区。这就是为什么修改了Class后，必须重启 JVM，程序的修改才会生效.对于一个类加载器实例来说，
 *  相同全名的类只加载一次，即 loadClass方法不会被重复调用。
 *
 *  假如该类的直接父类还没有被初始化，则先初始化其直接父类
 *
 * sun.misc.Launcher
 *     private static String bootClassPath = System.getProperty("sun.boot.class.path");
 *
 */
public class Code01_ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.getClass().getClassLoader());//打印HelloWorld的类加载器：AppClassLoader
        System.out.println(helloWorld.getClass().getClassLoader().getParent());//打印HelloWorld的类加载器的父加载器：ExtClassLoader
        System.out.println(helloWorld.getClass().getClassLoader().getParent().getParent());//打印HelloWorld的类加载器的父加载器的父加载器：BootstrapClassLoader
        System.out.println(new String().getClass().getClassLoader());//打印java.lang.String类的类加载器：BootstrapClassLoader
        /**
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * sun.misc.Launcher$ExtClassLoader@61bbe9ba
         * null
         * null
         */

        //利用类加载器加载资源
        Class<?> aClass = Code01_ClassLoader.class.getClassLoader().loadClass("com.lsh.class01.Demo");
        System.out.println(aClass.getName());
        /**
         * 什么时候回需要自己去加载一个类？
         * Spring  动态代理
         * 热部署
         */

    }
}
