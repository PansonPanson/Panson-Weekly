package top.panson.injava.year2526interview.other;

/**
 * @author Panson
 * @create 2025-11-04
 */
public class Singleton {

//    private static volatile Singleton instance;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if(instance == null) {
//            synchronized (Singleton.class) {
//                if(instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    private Singleton() {

    }


    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }


    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
