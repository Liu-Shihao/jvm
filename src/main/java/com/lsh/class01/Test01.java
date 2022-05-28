package com.lsh.class01;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/28 9:04 下午
 * @desc ：面试题：打印输出的值为多少？
 * 答案 输出 3  2
 *
 * 考试点：类加载过程：加载  连接（校验、准备、解析）初始化
 * 其中关键了两部分为 准备和初始化
 * 准备：将对象的静态成员变量分配空间，并附默认值 例如 int = 0
 * 初始化：为对象的静态成员变量赋初始值
 *
 * 所以 由于两个变量的顺序不同：
 *  public static  int count = 2;
 *  public static T t = new T();
 *  在准备阶段 count 赋值为默认值0，初始化后count 为2 然后执行构造方法 将count++ 此时count值为3
 *
 *  public static F t = new F();
 *  public static  int count = 2;
 *  先进行初始化 此时count为默认值0 执行构造方法 count++ ，count值为1，然后在初始化时count赋初始值2，所以count最后值为2
 *
 *
 *
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println(T.count);
        System.out.println(F.count);
    }

}
class T{
    public static  int count = 2;
    public static T t = new T();
    private T(){
        count++;
    }
}
class F{
    public static F t = new F();
    public static  int count = 2;
    private F(){
        count++;
    }
}
