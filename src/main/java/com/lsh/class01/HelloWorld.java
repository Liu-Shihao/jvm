package com.lsh.class01;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/25 10:14 下午
 * @desc ：；类加载机制
 * 加载 ：通过一个类的全限定名获取定义此类的二进制字节流，通过类加载器完成加载，类加载完成后 ，在运行时数据区的方法区和堆内存中有已经有数据了：堆:代表被加载类的java.lang.Class对象；方法区:类信息，静态变量，常量
 * 连接
 *      验证 ：为了确保Class文件中的字节流包含的信息完全符合当前虚拟机的要求，并且还要求 我们的信息不会危害虚拟机自身的安全，导致虚拟机的崩溃。
 *      准备：为类的静态变量分配内存，并将其初始化为默认值；不包含用final修饰的static，因为final在编译的时候就会分配了；不会为实例变量(也就是没加static)分配初始化，类变量会分配在方法区中，而实例变量 是会随着对象一起分配到Java堆中
 *      解析 将类中的符号引用转换为直接引用；符号引用就是一组符号来描述目标，可以是任何字面量；直接引用就是直接指向目标的指针、相对偏移量或一个间接定位到目标的句柄。
 * 初始化：初始化阶段是执行类构造器()方法的过程。假如该类的直接父类还没有被初始化，则先初始化其直接父类
 * 使用
 * 卸载
 *
 *  在连接 阶段 的准备阶段 会对类的静态变量分配空间，并赋默认值  ，在类初始化的时候才会赋初始值
 *  静态变量  被static修饰的变量
 *  没有被static修饰的变量为 类的实例变量
 *
 *  还有 被 static final 修饰的变量 则会直接进行初始化
 *
 *  类加载器 ClassLoader 用来装载class文件的  还可以确定类在虚拟机中的唯一性
 *  1)Bootstrap ClassLoader 负责加载$JAVA_HOME中 jre/lib/rt.jar 里所有的class或Xbootclassoath选项指定的jar包。由C+
 *  2)Extension ClassLoader 负责加载java平台中扩展功能的一些jar包，包括$JAVA_HOME中jre/lib/*.jar 或 -Djava.ext.dirs
 *  3)App ClassLoader 负责加载classpath中指定的jar包及 Djava.class.path 所指定目录下的类和jar包。
 *  4)Custom ClassLoader 通过java.lang.ClassLoader的子类自定义加载class，属于应用程序根据自身需要自定义的ClassLoader
 *  
 *
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }


    public void m(){
        System.out.println("Hello World");
    }
}
