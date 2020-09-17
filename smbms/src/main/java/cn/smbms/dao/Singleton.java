package cn.smbms.dao;

/*单例类*/
public class Singleton {
    private static Singleton singleton;

    /*构造方法私有化，防止调用者创建对象*/
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }



}
