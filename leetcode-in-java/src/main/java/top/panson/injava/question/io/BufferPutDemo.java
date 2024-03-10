package top.panson.injava.question.io;

import java.nio.ByteBuffer;

/**
 * @create 2022-06-15 17:57
 * @Author: Panson
 */
public class BufferPutDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);

        System.out.println("position = " + buffer.position());
        System.out.println("capacity = " + buffer.position());
        System.out.println("limit = " + buffer.limit());

        byte[] data = new byte[]{1, 2, 3, 4, 5};
        // position [0, 4] 都填充了数据
        buffer.put(data);
        System.out.println("position = " + buffer.position());

        // position = 5, 此时如果直接读数据，是读不到的
        // 手动操作一下 position， 调整到 position = 0 的地方，开始读数据
        buffer.position(0);
        byte[] dst = new byte[5];
        // 将 buffer 里的数据转移到传入的数组里
        buffer.get(dst);
        System.out.println("position = " + buffer.position());
        System.out.print("dst=[");
        for(int i = 0; i < dst.length; i++) {
            System.out.print(dst[i]);
            if(i < dst.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");


    }

}
