package Company.Atlassian.CodeDesign.RateLimiterTokenBucket;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimit {
private long now  = System.currentTimeMillis();

private int size = 100;
private int rate = 100;

private int curentSize = 0;

private AtomicInteger count ;
private int maxPreSecondVisit;




//漏桶算法
public boolean limit1(){
    long currentTime = System.currentTimeMillis();
    curentSize = (int)Math.max(0,curentSize - (currentTime - now) *rate);
    if(curentSize < size){
        now  = currentTime;
        curentSize++;
        return true;
    }else{
        return false;
    }
}

//令牌桶算法
public boolean limit2(){
    long currentTime = System.currentTimeMillis();
    curentSize = (int)Math.min(size,curentSize + (currentTime - now) *rate);
    if(curentSize > 0){
        now  = currentTime;
        curentSize--;
        return true;
    }else{
        return false;
    }
}

//固定窗口
public boolean limit3(){
    long currentTime = System.currentTimeMillis();
    if(currentTime -now>1000){
        now = currentTime;
        count.set(1);
    }else{
        count.addAndGet(1);
    }
    return count.get() > maxPreSecondVisit ? false : true;

}

//滑动窗口
public boolean limit4(){
    long currentTime = System.currentTimeMillis();
    if(currentTime -now>1000){
        now = currentTime;
        count.set(1);
    }else{
        count.addAndGet(1);
    }
    return count.get() > maxPreSecondVisit ? false : true;
}

//滑动窗口
public static  class SlideWindowRateLimiter {
    private AtomicInteger[] buckets;
    private int index=0;
    private int maxVisitPerSecond;
    private AtomicInteger visit=new AtomicInteger(0);

    public SlideWindowRateLimiter(int bucket,int maxVisitPerSecond ){
        this.buckets = new AtomicInteger[bucket];
        for(int i = 0;i<bucket;i++){
            buckets[i] = new AtomicInteger(0);
        }
        this.maxVisitPerSecond = maxVisitPerSecond;
        startThread();
    }

    private void startThread() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                index = (index + 1) % SlideWindowRateLimiter.this.buckets.length;
                int val = SlideWindowRateLimiter.this.buckets[index].getAndSet(0);
                SlideWindowRateLimiter.this.visit.addAndGet(-val);
                }
        },100, 100, TimeUnit.MILLISECONDS);
    }

    public boolean limit(){
        buckets[index].addAndGet(1);
        visit.addAndGet(1);
        return visit.get() > maxVisitPerSecond ? false : true;
    }

}

public static void main(String[] args) {
    RateLimit rateLimit = new RateLimit();
    /*
   for(int i= 0 ;i<10000;i++){
       if(rateLimit.limit1()){
           System.out.println("i="+i+ "    yes");
       }else{
           System.out.println("i="+i+ "    no");
       }
   }
   */

    for(int i= 0 ;i<10000;i++){
        if(rateLimit.limit2()){
            System.out.println("i="+i+ "    yes");
        }else{
            System.out.println("i="+i+ "    no");
        }
    }
}
}

