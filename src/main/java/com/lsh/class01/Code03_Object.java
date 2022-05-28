package com.lsh.class01;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/26 10:48 下午
 * @desc ：Java 对象内存布局
 * 1. 对象头
 *      MarkWord 标记位：哈希码 分代年龄 锁状态       64位系统占8字节
 *      ClassPointer  指向对象对应的类元数据的内存地址  64位系统占8字节
 *      Length 数组对象特有 数组长度 占4字节
 * 2. 实例数据 包含了对象所有的成员变量 大小由各个变量类型决定
 *      boolean 和 byte 占 1字节
 *      short 和 char 占2 字节
 *      int 和 float 占 4字节（32位）
 *      long 和 double  占 8字节
 *      reference（引用） 占8 字节（64位系统）
 *      默认开启指针压缩 8字节压缩为4字节
 *      关闭指针压缩 : -XX:-UseCompressedOops
 *
 * 3. 对齐信息  为了保证对象的大小为8字节的整数倍
 */
public class Code03_Object {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.hashCode());
        System.out.println(ClassLayout.parseInstance(helloWorld).toPrintable());
    }
    /**
     * com.lsh.class01.HelloWorld object internals:
     * OFF  SZ               TYPE DESCRIPTION               VALUE
     *   0   8                    (object header: mark)     0x000000511d50c001 (hash: 0x511d50c0; age: 0)  MarkWord 哈希码、锁信息、分代年龄
     *   8   4                    (object header: class)    0xf800c143   ClassPointer指针
     *  12   4                int HelloWorld.id             0   实例变量
     *  16   4   java.lang.String HelloWorld.str            null
     *  20   4                    (object alignment gap)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
}
