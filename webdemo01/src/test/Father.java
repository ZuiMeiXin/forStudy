package test;

public class Father {
    static{
        System.out.println("父类静态代码块");
    }


    public Father() {
        System.out.println("父类构造方法");
    }

    {
        System.out.println("父类非静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("父类的main方法");

    }
}
