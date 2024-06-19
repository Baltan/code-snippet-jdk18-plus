package thread_test;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author baltan
 * @date 2024/6/19 16:26
 */
public class Test1 {
    public static void main(String[] args) {
        testThread(2000); // 20416毫秒
        testVirtualThread(1000); // 20442毫秒
    }

    @SneakyThrows
    private static void testThread(int threadCount) {
        CountDownLatch latch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            final String threadName = STR."线程-\{i}";
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(STR."\{threadName}: \{j}");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(STR."\{threadName}执行结束");
                latch.countDown();
            }).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @SneakyThrows
    private static void testVirtualThread(int threadCount) {
        CountDownLatch latch = new CountDownLatch(threadCount);
        ThreadFactory factory = Thread.ofVirtual().factory();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            final String threadName = STR."虚拟线程-\{i}";
            factory.newThread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(STR."\{threadName}: \{j}");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(STR."\{threadName}执行结束");
                latch.countDown();
            }).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
