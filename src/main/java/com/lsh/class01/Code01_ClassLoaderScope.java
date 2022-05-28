package com.lsh.class01;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/28 4:33 下午
 * @desc ：打印 Bootstrap、Ext、App类加载的Path
 */
public class Code01_ClassLoaderScope {

    public static void main(String[] args) {
        String boot = System.getProperty("sun.boot.class.path");
        System.out.println(boot.replaceAll(":","\n"));
        System.out.println("-------------------------");
        String ext = System.getProperty("java.ext.dirs");
        System.out.println(ext.replaceAll(":","\n"));
        System.out.println("-------------------------");
        String app = System.getProperty("java.class.path");
        System.out.println(app.replaceAll(":","\n"));
    }
}
