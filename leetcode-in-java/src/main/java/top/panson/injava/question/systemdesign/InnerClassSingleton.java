package top.panson.injava.question.systemdesign;

/**
 * @create 2022-03-06 15:11
 * @Author: Panson
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private InnerClassSingleton getInstance() {
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
}
