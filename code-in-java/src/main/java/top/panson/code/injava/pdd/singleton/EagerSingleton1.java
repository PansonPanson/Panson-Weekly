package top.panson.code.injava.pdd.singleton;

/**
 * 恶汉模式
 * @author Panson
 * @create 2024-07-12
 */
public class EagerSingleton1 {

    private static EagerSingleton1 instance = new EagerSingleton1();

    private EagerSingleton1() {
    }

    public static EagerSingleton1 getEagerSingleton() {
        return instance;
    }
}
