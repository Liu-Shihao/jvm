package com.lsh.class02;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/31 2:58 下午
 * @desc ：
 */
public class Code02_Invoke {

    public static void main(String[] args) {
        Code02_Invoke code02_invoke = new Code02_Invoke();
        code02_invoke.m();//invokespecial
        m_static();//invokestatic
        code02_invoke.privateMethod();//invokevirtual

        I i1 = C::n;//是用lambda jvm调用指令 invokedynamic
        I i2 = C::n;
        I i3 = ()->{C.n();};
        System.out.println(i1.getClass());
        System.out.println(i2.getClass());
        System.out.println(i3.getClass());

    }
    public static void m_static(){
        System.out.println("void m");
    }

    public void m(){
        System.out.println("void m");
    }

    //构造方法
    public Code02_Invoke(){
        System.out.println("构造方法");
    }

    private void privateMethod(){
        System.out.println("privateMethod");
    }


    public interface I{
        void m();
    }

    public static class C {
       static void n(){
           System.out.println("hello");
       }
    }


}



