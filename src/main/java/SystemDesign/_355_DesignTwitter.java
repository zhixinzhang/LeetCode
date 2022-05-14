package SystemDesign;

import java.util.*;

/**
 * Created by zhang on 2018/3/20.
 */
// https://leetcode.com/problems/design-twitter/description/
public class _355_DesignTwitter {
    private int timeStamp = 0;
    private HashMap<Integer,User> userMap;
    class Tweet{
        private int id;
        private int time;
        private Tweet next;
        public Tweet(int id){
            this.id = id;
            time = timeStamp ++;
            next = null;
        }
    }
    class User{
        private int id;
        public HashSet<Integer> followed;
        private Tweet tweetHead;

        public User (int id){
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            followed.remove(id);
        }
        public void post(int id){
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;

        }
    }


    public _355_DesignTwitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId,user);
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)){
           return res;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        HashSet<Integer> users = userMap.get(userId).followed;
        pq = new PriorityQueue<>(users.size(),(a,b)->(b.time - a.time));
        for (int user : users){
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }
        int count = 0;
        while(!pq.isEmpty() && count < 10){
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            count ++;
            if (tweet.next != null)
                pq.offer(tweet.next);
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId,user);
        }
        if (!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId,user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followeeId == followerId){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}
