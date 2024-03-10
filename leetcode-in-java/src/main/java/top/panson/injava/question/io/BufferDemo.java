package top.panson.injava.question.io;

import java.nio.ByteBuffer;

/**
 * @create 2022-06-15 16:36
 * @Author: Panson
 */
public class BufferDemo {
    /**
     * buffer 的 一些基本概念： capacity、position、limit、mark
     * @param args
     */
    public static void main(String[] args) {
        byte[] data = new byte[] {55, 56, 57, 58, 59};
        ByteBuffer buffer = ByteBuffer.wrap(data);
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        // 把当前 position 所在位置的数据
        System.out.println(buffer.get());
        System.out.println(buffer.position());
        buffer.mark();

        buffer.position(3);
        System.out.println(buffer.get());
        System.out.println(buffer.position());
        // position 回到 mark 的位置
        buffer.reset();

        System.out.println(buffer.position());


    }
}
