package top.panson.code.injava.pdd.singleton;

/**
 * 恶汉模式
 * @author Panson
 * @create 2024-07-12
 */
public class EagerSingleton2 {

    private static EagerSingleton2 instance = null;

    static {
        instance = new EagerSingleton2();
    }

    private EagerSingleton2() {
    }

    public static EagerSingleton2 getEagerSingleton() {
        return instance;
    }
}
