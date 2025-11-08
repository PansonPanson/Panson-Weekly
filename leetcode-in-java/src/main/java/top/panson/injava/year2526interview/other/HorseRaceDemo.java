package top.panson.injava.year2526interview.other;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程赛马
 *
 * @author Panson
 * @create 2025-11-08
 */
public class HorseRaceDemo {


    static class Result {
        final int horseId;
        final long startNanos;
        final long endNanos;
        final long durationMillis;

        Result(int horseId, long startNanos, long endNanos) {
            this.horseId = horseId;
            this.startNanos = startNanos;
            this.endNanos = endNanos;
            this.durationMillis = endNanos - startNanos;
        }

        @Override
        public String toString() {
            return "Horse-" + horseId + " time=" + durationMillis + "ms";
        }
    }

    public static void main(String[] args) throws Exception {
        final int HORSES = 10;
        // barrierAction 在所有线程到达栅栏时执行（打印 “开跑!”）
        CyclicBarrier startBarrier = new CyclicBarrier(HORSES, () -> System.out.println("裁判：预备 -> 开跑！"));
        CountDownLatch finishLatch = new CountDownLatch(HORSES);

        // 用于收集每匹马的成绩（线程安全）
        ConcurrentLinkedQueue<Result> results = new ConcurrentLinkedQueue<>();

        Random random = new Random();

        ExecutorService pool = new ThreadPoolExecutor(10,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 1; i <= HORSES; i++) {
            final int id = i;
            pool.submit(() -> {
                try {
                    System.out.println("Horse-" + id + " 就绪");
                    // 等待所有马就绪
                    startBarrier.await();

                    // 记录开始时间
                    long start = System.currentTimeMillis();

                    // 模拟跑步过程：随机用时 0 ~ 1000 ms
                    long runMillis = random.nextInt(100) * 10;
                    Thread.sleep(runMillis);

                    long end = System.currentTimeMillis();
                    // 提交成绩
                    results.add(new Result(id, start, end));
                    System.out.println("Horse-" + id + " 到达终点，用时 " + (end - start)  + " ms");
                } catch (BrokenBarrierException | InterruptedException e) {
                    System.out.println("Horse-" + id + " 被打断或栅栏异常: " + e);
                } finally {
                    finishLatch.countDown();
                }
            });
        }

        // 裁判等待所有马到达
        finishLatch.await();

        pool.shutdown();

        // 汇总并排序成绩（按耗时升序）
        List<Result> ranking = new ArrayList<>(results);
        ranking.sort(Comparator.comparingLong(a -> a.durationMillis));

        System.out.println("\n裁判：比赛结束，成绩如下（排名从第一到最后）：");
        AtomicInteger rank = new AtomicInteger(1);
        for (Result r : ranking) {
            System.out.printf("第 %d 名: %s%n", rank.getAndIncrement(), r);
        }
    }
}


