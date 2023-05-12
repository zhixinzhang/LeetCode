package Company.Atlassian.CodeDesign.RateLimiterSlidingWindow;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


// https://leetcode.com/discuss/interview-question/object-oriented-design/1713795/API-Rate-Limiter
// https://leetcode.com/discuss/interview-question/system-design/124558/Uber-or-Rate-Limiter

public class RateLimiterService {
    public static void main(String[] args) {
        int limit = 2; // 5 requests per minute
        RateLimit rateLimit = new RateLimit(limit);
        new RateLimitHelper("UserA", rateLimit).start();
        new RateLimitHelper("userB", rateLimit).start();
    }
}

class Request {
    public Instant timeStamp;
    public Integer count;
    public Request(Instant timeStamp, Integer count) {
        this.timeStamp = timeStamp;
        this.count = count;
    }
}

class RateLimit {

    int rateLimit;
    Map<String, LinkedList<Request>> userRequestMap = new ConcurrentHashMap<>();

    public RateLimit(int limit){
        this.rateLimit = limit;
    }

    public synchronized boolean hit(String user, Instant timeStamp){
        if (!userRequestMap.containsKey(user)){
            return addNewUser(user);
        } else {
            if (getTotalElpasedRequests(user) < rateLimit){
                LinkedList<Request> requests = userRequestMap.get(user);
                requests.add(new Request(timeStamp, 1));
                userRequestMap.put(user, requests);
                return true;
            } else {
                boolean actionTaken = false;
                for (int i = 0; i < userRequestMap.get(user).size(); i++) {
                    Duration duration = Duration.between(userRequestMap.get(user).get(i).timeStamp, timeStamp);
					// check for elapsed time greater than 1 minute (60 seconds)
					// This can be passed as an argument at runtime to avoid hardcoding
                    if (duration.getSeconds() >= 3) {
                        userRequestMap.get(user).remove(i);
                        actionTaken = true;
                    } else {
                        break;
                    }
                }

                if (actionTaken) {
                    LinkedList<Request> requests = userRequestMap.get(user);
                    requests.add(new Request(timeStamp, 1));
                    userRequestMap.put(user, requests);
                    return true;
                }

                return false;
            }
        }
    }

    public boolean addNewUser(String user){
        LinkedList<Request> requests = new LinkedList<>();
        requests.add(new Request(Instant.now(), 1));
        userRequestMap.put(user, requests);
        System.out.println("new user added !! " + user);
        return true;
    }

    public Integer getTotalElpasedRequests(String user) {
        return userRequestMap.get(user).size();

        // return userRequestMap.get(user).stream().mapToInt(Request::getCount).sum();
    }

}

// Thread Helper class - Invoke multiple threads to check throttling of requests
class RateLimitHelper extends Thread {
    RateLimit rateLimit;

    public RateLimitHelper(String user, RateLimit rateLimitService) {
        super(user);
        this.rateLimit = rateLimitService;
    }

    @Override
    public void run(){
        for (int i = 1; i < 10; i++){
            System.out.println("Thread Name - " + getName() + ", Time - " + i + ", rate limit: " + hit(getName(), Instant.now()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("DONE! " + getName());
    }

    public boolean hit(String user, Instant ts) {
        return rateLimit.hit(user, ts);
    }
}





