package com.lsh.class01;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/28 9:54 下午
 * @desc ：乱序问题
 *  x y a b 初始值都为0
 *  启动两个线程  A1 :a = 1  A2:x = b  ; B1 :b = 1 B2:y = a;
 *  四个命令起名为 A1 A2 B1 B2 正常可以分析出四个命令的执行顺序：
 * 1. A1 A2  B1 B2 输出结果：x = 0  y = 1;
 * 2. A1 B1  A2 B2 输出结果：x = 1  y = 1;
 * 3. A1 B1  B2 A2 输出结果：x = 1  y = 1;
 * 4. B1 A1  A2 B2 输出结果：x = 1  y = 1;
 * 5. B1 A1  B2 A2 输出结果：x = 1  y = 1;
 * 6. B1 B2  A1 A2 输出结果：x = 1  y = 0;
 *
 * 只有发生了乱序，才会导致 A2执行在A1前; B2执行在B1前;  导致x = 0 y = 0 的特殊情况
 */
public class Code04_DisOrder {
    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0 ;
        for (;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(() -> {
                //第4854次结果： x = 0;y =0
                //第214026次结果： x = 0;y =0 2022年05月28日22:16:24
                a = 1;
                x = b;
            });
            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start();two.start();
            one.join();two.join();
            String result = "第"+i+"次结果： x = "+x+";y ="+y+" ";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            }
        }
    }


    public static void  shortwait(Long l){
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
