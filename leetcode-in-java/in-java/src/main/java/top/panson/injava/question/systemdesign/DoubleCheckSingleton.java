package top.panson.injava.question.systemdesign;

/**
 * @create 2022-03-06 15:06
 * @Author: Panson
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public DoubleCheckSingleton getInstance() {
        if(instance == null) {
            // 多个线程卡在这里
            synchronized (DoubleCheckSingleton.class) {
                // 线程a 进入，然后创建退出代码块，此时线程B进入，如果没有双重检查锁，会重复创建
                if(instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
