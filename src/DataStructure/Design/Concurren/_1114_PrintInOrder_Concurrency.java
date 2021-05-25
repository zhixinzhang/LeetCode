package DataStructure.Design.Concurren;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Luke(New Man) Zhang
 * @Date 5/16/2021 3:12 AM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _1114_PrintInOrder_Concurrency {
    private final AtomicInteger i = new AtomicInteger();
    private final Object lock = new Object();

    public _1114_PrintInOrder_Concurrency(){
        i.set(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            while (i.get() != 0) {
                lock.wait();
            }
            printFirst.run();
            i.set(1);
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (i.get() != 1) {
                lock.wait();
            }
            printSecond.run();
            i.set(2);
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (i.get() != 2) {
                lock.wait();
            }
            printThird.run();
            i.set(3);
        }
    }
}
