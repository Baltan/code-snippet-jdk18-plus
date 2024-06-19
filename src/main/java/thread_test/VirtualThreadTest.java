package thread_test;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * Description: 创建虚拟线程
 *
 * @author baltan
 * @date 2024/6/18 17:13
 */
public class VirtualThreadTest {
    /**
     * @param args
     * @see <a href="https://javaguide.cn/java/new-features/java20.html#jep-436-%E8%99%9A%E6%8B%9F%E7%BA%BF%E7%A8%8B-%E7%AC%AC%E4%BA%8C%E6%AC%A1%E9%A2%84%E8%A7%88"></a>
     */
    @SneakyThrows
    public static void main(String[] args) {
        /**
         * 第一种创建虚拟线程的方式
         */
        Thread.startVirtualThread(() -> System.out.println("virtualThread1"));
        /**
         * 第二种创建虚拟线程的方式
         */
        try (ExecutorService virtualThreadPool = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> future = virtualThreadPool.submit(() -> {
                TimeUnit.SECONDS.sleep(3L);
                return "virtualThread2";
            });
            System.out.println(future.get());
        }
        /**
         * 第三种创建虚拟线程的方式
         */
        ThreadFactory factory = Thread.ofVirtual().factory();
        Thread virtualThread3 = factory.newThread(() -> System.out.println("virtualThread3"));
        virtualThread3.start();
        /**
         * 第四种创建虚拟线程的方式
         */
        Thread virtualThread4 = Thread.ofVirtual().unstarted(() -> System.out.println("virtualThread4"));
        virtualThread4.start();
    }
}
