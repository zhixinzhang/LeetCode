package Company.Sony.ThreadAbstractInterface.Semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
// https://www.jianshu.com/p/0090341c6b80
/**
 * Semaphore可以用来做流量分流，特别是对公共资源有限的场景，比如数据库连接。
假设有这个的需求，读取几万个文件的数据到数据库中，由于文件读取是IO密集型任务，可以启动几十个线程并发读取，但是数据库连接数只有10个，这时就必须控制最多只有10个线程能够拿到数据库连接进行操作。这个时候，就可以使用Semaphore做流量控制。

作者：占小狼
链接：https://www.jianshu.com/p/0090341c6b80
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
*/
public class SemaphoreTest {
    private static final int COUNT = 40;
    private static Executor executor = Executors.newFixedThreadPool(COUNT);
    private static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i=0; i< COUNT; i++) {
            // executor.execute(new ThreadTest.Task());
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                //读取文件操作
                semaphore.acquire();
                // 存数据过程
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
