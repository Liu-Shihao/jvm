package com.lsh.class01;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/26 9:50 下午
 * @desc ：JVM 运行时数据区
 * Java中有两类方法  Java方法 虚拟机栈   native方法 本地方法栈
 * 1. 程序计数器（线程私有区域）： 用来记录线程当前执行的位置，（线程抢占CPU时间片执行，当失去CPU执行权的时候需要通过程序计数器记录执行位置，等待下一次再次执行）
 * 2. 栈（线程私有区域）：栈帧  代表着一个方法的执行
 * 3. 本地方法栈（线程私有区域）
 * 4. 堆（线程共享区域） ：在JVM虚拟机启动时创建，存储对象实例和数组           ，会抛出OOM异常
 * 5. 方法区（线程共享区域）：在JVM虚拟机启动时创建，存储类的结构信息、静态变量  会抛出OOM异常
 * 线程 抢占 CPU时间片 获得执行  CPU通过线程调度算法分配执行权
 *
 * 动态链接
 * 栈帧信息：
 *         局部变量表：
 *         操作数栈：
 *       - 动态链接： 将符号方法引用转换为具体的方法引用、Java方法调用native方法时
 *栈帧信息| 返回信息：
 *       - 附加信息：
 *
 *
 */
public class Code02_RunTimeDateAreas {

    public static void main(String[] args) {
        /**
         * 最多创建一个字符串对象。
         *
         * 首先“aaaa”会被认为字面量，先在字符串常量池中查找（.equals()）,
         * 如果没有找到，在堆中创建“aaaa”字符串对象，并且将“aaaa”的引用维护到字符串常量池中（实际是一个hashTable结构，存放key-value结构数据），
         * 再返回该引用；如果在字符串常量池中已经存在“aaaa”的引用，直接返回该引用。
         */
        String s1 = "aaaa";

        /**
         * 最多会创建两个对象。
         * 首先“aaaa”会被认为字面量，先在字符串常量池中查找（.equals()）,
         * 如果没有找到，在堆中创建“aaaa”字符串对象，然后再在堆中创建一个“aaaa”对象，返回后面“aaaa”的引用；
         */
        String s2 = new String("aaaa");
        /**
         * intern方法是一个 native 的方法，当调用 intern方法时，
         * 如果常量池已经包含一个等于此String对象的字符串（用equals(object)方法确定），则返回池中的字符串。
         * 否则，将intern返回的引用指向当前字符串
         */
        System.out.println(s1 == s2);//false
        System.out.println(s2 == s2.intern());//false
        System.out.println(s1 == s1.intern());//true
    }
}
