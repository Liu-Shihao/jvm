package com.lsh.class02;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/30 9:37 下午
 * @desc ：
 * i=i++;
 *  0 bipush 8     立即字节符号扩展为一个 int 值。该值被压入操作数堆栈。
 *  2 istore_1       存入局部变量表中    弹栈（从操作数栈中弹出）
 *  3 iload_1        从局部变量表加载int 压栈（操作数栈）
 *  4 iinc 1 by 1     按常量递增局部变量
 *  7 istore_1        从局部变量表加载int
 *  8 getstatic #2 <java/lang/System.out>
 * 11 iload_1
 * 12 invokevirtual #3 <java/io/PrintStream.println>
 * 15 return
 *
 * i = ++i;
 *  0 bipush 8
 *  2 istore_1
 *  3 iinc 1 by 1
 *  6 iload_1
 *  7 istore_1
 *  8 getstatic #2 <java/lang/System.out>
 * 11 iload_1
 * 12 invokevirtual #3 <java/io/PrintStream.println>
 * 15 return
 *
 *
 *
 *
 */
public class Test01 {
    public static void main(String[] args) {
        int i = 8 ;
//        i = i++;//8
        i = ++i;//9
        System.out.println(i);
    }
}
