package top.panson.code.injava.pdd.singleton;

/**
 * @author Panson
 * @create 2024-07-12
 */
public class StaticInnerSingleton {


    private static class Holder {
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {

    }

    public StaticInnerSingleton getStaticInnerSingleton() {
        return Holder.instance;
    }
}
