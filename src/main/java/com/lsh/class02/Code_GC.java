package com.lsh.class02;

import java.util.LinkedList;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/6/1 10:29 下午
 * @desc ：
 *
 * 1. 区分概念：内存泄漏memory leak，内存溢出out of memory
 * 2. java -XX:+PrintCommandLineFlags Code_GC
 * 3. java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC  Code_GC
 *    PrintGCDetails PrintGCTimeStamps PrintGCCauses
 * 4. java -XX:+UseConcMarkSweepGC -XX:+PrintCommandLineFlags HelloGC
 * 5. java -XX:+PrintFlagsInitial 默认参数值
 * 6. java -XX:+PrintFlagsFinal 最终参数值
 * 7. java -XX:+PrintFlagsFinal | grep xxx 找到对应的参数
 * 8. java -XX:+PrintFlagsFinal -version |grep GC
 */
public class Code_GC {
    public static void main(String[] args) {
        System.out.println("Hello GC!");
        LinkedList<Object> list = new LinkedList<>();
        for (;;){
            byte[] bytes = new byte[1024 * 1024];
            list.add(bytes);
        }

    }
}
/**
 * java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC  Code_GC:
 * /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/bin/java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=64239:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/tools.jar:/Users/LiuShihao/IdeaProjects/jvm-demo/target/classes:/Users/LiuShihao/Maven/apache-maven-3.5.0/repository/org/openjdk/jol/jol-core/0.16/jol-core-0.16.jar com.lsh.class02.Code_GC
 * -XX:InitialHeapSize=41943040 -XX:MaxHeapSize=62914560 -XX:MaxNewSize=10485760 -XX:NewSize=10485760 -XX:+PrintCommandLineFlags -XX:+PrintGC -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
 * Hello GC!
 * [GC (Allocation Failure)  8008K->6648K(39936K), 0.0043495 secs]
 * [GC (Allocation Failure)  14056K->13768K(39936K), 0.0047763 secs]
 * [GC (Allocation Failure)  21304K->20952K(39936K), 0.0048873 secs]
 * [GC (Allocation Failure)  28272K->28104K(39936K), 0.0046839 secs]
 * [Full GC (Ergonomics)  28104K->28020K(54272K), 0.0116712 secs]
 * [GC (Allocation Failure)  35378K->35316K(54272K), 0.0033994 secs]
 * [GC (Allocation Failure)  42656K->42484K(54272K), 0.0043220 secs]
 * [Full GC (Ergonomics)  42484K->42354K(60416K), 0.0078761 secs]
 * [GC (Allocation Failure)  49706K->49651K(60416K), 0.0039098 secs]
 * [Full GC (Ergonomics)  49651K->49547K(60416K), 0.0040843 secs]
 * [Full GC (Ergonomics)  56862K->56715K(60416K), 0.0039643 secs]
 * [Full GC (Ergonomics)  57739K->57739K(60416K), 0.0029311 secs]
 * [Full GC (Allocation Failure)  57739K->57721K(60416K), 0.0126829 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at com.lsh.class02.Code_GC.main(Code_GC.java:25)
 *
 * Process finished with exit code 1
 *
 * java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGCDetails  Code_GC
 *
 * /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/bin/java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGCDetails "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=64306:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/lib/tools.jar:/Users/LiuShihao/IdeaProjects/jvm-demo/target/classes:/Users/LiuShihao/Maven/apache-maven-3.5.0/repository/org/openjdk/jol/jol-core/0.16/jol-core-0.16.jar com.lsh.class02.Code_GC
 * -XX:InitialHeapSize=41943040 -XX:MaxHeapSize=62914560 -XX:MaxNewSize=10485760 -XX:NewSize=10485760 -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
 * Hello GC!
 * [GC (Allocation Failure) [PSYoungGen: 7844K->496K(9216K)] 7844K->6648K(39936K), 0.0047532 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * [GC (Allocation Failure) [PSYoungGen: 7906K->480K(9216K)] 14058K->13800K(39936K), 0.0044754 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 8180K->480K(9216K)] 21501K->20968K(39936K), 0.0073814 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
 * [GC (Allocation Failure) [PSYoungGen: 7834K->448K(9216K)] 28323K->28112K(39936K), 0.0099763 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 448K->0K(9216K)] [ParOldGen: 27664K->28017K(45056K)] 28112K->28017K(54272K), [Metaspace: 3037K->3037K(1056768K)], 0.0134959 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
 * [GC (Allocation Failure) [PSYoungGen: 7345K->128K(9216K)] 35362K->35313K(54272K), 0.0034972 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 7459K->128K(9216K)] 42644K->42481K(54272K), 0.0041867 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 128K->0K(9216K)] [ParOldGen: 42353K->42354K(51200K)] 42481K->42354K(60416K), [Metaspace: 3053K->3053K(1056768K)], 0.0085381 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 7330K->128K(9216K)] 49684K->49650K(60416K), 0.0038424 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 128K->0K(9216K)] [ParOldGen: 49522K->49522K(51200K)] 49650K->49522K(60416K), [Metaspace: 3058K->3058K(1056768K)], 0.0037658 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 7321K->6144K(9216K)] [ParOldGen: 49522K->50546K(51200K)] 56844K->56690K(60416K), [Metaspace: 3058K->3058K(1056768K)], 0.0049940 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 7172K->7170K(9216K)] [ParOldGen: 50546K->50546K(51200K)] 57719K->57717K(60416K), [Metaspace: 3059K->3059K(1056768K)], 0.0034549 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 7170K->7170K(9216K)] [ParOldGen: 50546K->50528K(51200K)] 57717K->57699K(60416K), [Metaspace: 3059K->3059K(1056768K)], 0.0088376 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 * Heap
 *  PSYoungGen      total 9216K, used 7399K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *   eden space 8192K, 90% used [0x00000007bf600000,0x00000007bfd39e28,0x00000007bfe00000)
 *   from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *  ParOldGen       total 51200K, used 50528K [0x00000007bc400000, 0x00000007bf600000, 0x00000007bf600000)
 *   object space 51200K, 98% used [0x00000007bc400000,0x00000007bf5582a8,0x00000007bf600000)
 *  Metaspace       used 3092K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 340K, capacity 388K, committed 512K, reserved 1048576K
 */
