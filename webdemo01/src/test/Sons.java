package test;

public class Sons extends Father{
    static{
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类非静态代码块");
    }

    public Sons() {
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        System.out.println("子类的main方法");
        new Sons();
    }

}
