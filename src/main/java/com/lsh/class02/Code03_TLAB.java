package com.lsh.class02;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/31 10:50 下午
 * @desc ：
 * JVM 参数：
 * -XX:-UseTLAB
 * -XX:-DoescapeAnalysis
 * -XX:-EliminateAllocations
 *
 * 栈上分配比在堆上分配要快
 * 栈上直接弹出，不需要垃圾回收
 *
 * -Xms 起始堆内存大小
 * -Xmx 最大堆内存大小
 * 搜索JVM参数：
 * java -XX:+PrintFlagsFinal -version | grep XXX(关键词)
 *
 * XX:MaxTenuringThreshold  指定次数 对象何时进入老年代
 * ParallelScavenge  15次
 * CMS   6次
 * G1    15次
 *
 * 动态年龄：
 *
 *
 *
 *
 *
 */
public class Code03_TLAB {
    public static void main(String[] args) {

    }
}
