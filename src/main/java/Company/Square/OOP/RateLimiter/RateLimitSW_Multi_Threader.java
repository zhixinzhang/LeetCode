package Company.Square.OOP.RateLimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


// https://leetcode.com/discuss/interview-question/object-oriented-design/1713795/API-Rate-Limiter
// https://leetcode.com/discuss/interview-question/system-design/124558/Uber-or-Rate-Limiter

public class RateLimitSW_Multi_Threader {
    public static void main(String[] args) {
        int limit = 2; // 2 requests everg 5 seconds
        int timeSeconds = 5;
        RateLimit rateLimit = new RateLimit(limit, timeSeconds);
        new RateLimitHelper("UserA", rateLimit).start();
        new RateLimitHelper("userB", rateLimit).start();
    }
}

class Request {
    public Instant timeStamp;
    // public Integer count;
    public String ipAddress;
    public Request(Instant timeStamp) {
        this.timeStamp = timeStamp;
        // this.count = count;
    }
}

class RateLimit {

    int rateLimit;
    int limitSeconds;
    Map<String, LinkedList<Request>> userRequestMap = new ConcurrentHashMap<>();

    public RateLimit(int rateLimit, int limitSeconds){
        this.rateLimit = rateLimit;
        this.limitSeconds = limitSeconds;
    }

    public boolean hit(String user, Instant timeStamp){
        if (!userRequestMap.containsKey(user)){
            return addNewUser(user);
        } else {
            if (getTotalElpasedRequests(user) < rateLimit){
                LinkedList<Request> requests = userRequestMap.get(user);
                // requests.add(new Request(timeStamp, 1));
                requests.add(new Request(timeStamp));
                userRequestMap.put(user, requests);
                return true;
            } else {
                boolean actionTaken = false;
                for (int i = 0; i < userRequestMap.get(user).size(); i++) {
                    Duration duration = Duration.between(userRequestMap.get(user).get(i).timeStamp, timeStamp);
                    // long curL = userRequestMap.get(user).get(i).timeStamp.toEpochMilli(); compare to double type of seconds

					// check for elapsed time greater than 1 minute (60 seconds)
					// This can be passed as an argument at runtime to avoid hardcoding
                    if (duration.getSeconds() >= limitSeconds) {
                        userRequestMap.get(user).remove(i);
                        actionTaken = true;
                    } else {
                        break;
                    }
                }

                if (actionTaken) {
                    LinkedList<Request> requests = userRequestMap.get(user);
                    // requests.add(new Request(timeStamp, 1));
                    requests.add(new Request(timeStamp));
                    userRequestMap.put(user, requests);
                    return true;
                }

                return false;
            }
        }
    }

    public boolean addNewUser(String user){
        LinkedList<Request> requests = new LinkedList<>();
        // requests.add(new Request(Instant.now(), 1));
        requests.add(new Request(Instant.now()));
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

            // System.out.println("Thread Name - " + getName() + ", Time - " + Instant.now() + ", rate limit: " + hit(getName(), Instant.now()));
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





