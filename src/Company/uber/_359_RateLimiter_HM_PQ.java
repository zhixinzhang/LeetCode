package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/12.
 * http://www.1point3acres.com/bbs/thread-431942-1-1.html
 */
public class _359_RateLimiter_HM_PQ {

    /**
     *          class structure
     *     server {HashMap -> all the client(id)}
     *     client -> id, have PQ(minHeap) size smaller than 100
     *     limit 5
     *     1 2 3 4 5 6
     */
    static class Server{
        HashMap<Integer, Client> hm = new HashMap<>();

        public void addClient(Client client){
            hm.put(client.id, client);
        }
        public boolean request(Client client){
            System.out.println(client.id + "   " + client.timeStamp);
            if (!hm.containsKey(client.id))
                return false;
            Client c = hm.get(client.id);
            if (c.range.size() < 5){
                c.range.addLast(client.timeStamp);
                return true;
            } else {
                long smallestTime = c.range.pollFirst();
                client.range.addLast(client.timeStamp);
                if (client.timeStamp - smallestTime > 1000){
                    return true;
                }else {
                    return false;
                }
            }
        }
    }
    static class Client{
        int id;
        long timeStamp;
        Deque<Long> range = new LinkedList<>();
        public Client(int id){
            this.id = id;
        }
    }

    public static void main(String[] args){
        Server server = new Server();
        server.addClient(new Client(1));
        server.addClient(new Client(2));

        Client testClient = new Client(1);
//        Date date = new Date();
        for (int i = 0; i < 10; i++){
            if (i >= 7 ){
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    System.out.print("something wrong");
                }
            }

            testClient.timeStamp = System.currentTimeMillis();
            boolean res = server.request(testClient);
            System.out.println("idx --- " + i +   "     Time  : " + testClient.timeStamp + " result    :"+ res);
        }
    }
}
