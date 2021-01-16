package company.DataBricks;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://www.1point3acres.com/bbs/thread-702466-1-1.html
 *
 * API:
 * public int insert(int number) --> 插入一个新的顾客
 * public int insert(int number, int referralId) --> 插入一个顾客和它的推荐
 * 一个顾客的rev = 自己的rev + 直接推荐客户rev
 * For example,
 *
 * insert(100)  -> customer0, rev 100
 * insert(200, 0) -> customer 0, rev 300=100+200, customer1, rev 200
 * insert(150, 1) -> customer 0, rev 300=100+200, customer1, rev 350=200+150, customer2, rev 150
 *
 * API:
 * public int[] getKCustomerRevenueBelowThreshold(int threshold) 返回rev小于指定threshold的客户id, 要求按rev从大到小排列 -->  getKCustomerRevenueBelowThreshold(200), return [2]
 *
 * 面试官希望的答案：维持一个客户利润由小到大的数组，插入二分查找，利润小于threshold二分查找。。
 * Key Point:
 *
 *
 */

public class CustomerRevenueBelowThreshold_Design_Heap_Map {
        Map<Integer, Integer> cache = new HashMap<>();              //  index -> rev
        Map<Integer, Set<Integer>> revCache = new HashMap<>();      // rev -> index

        List<Integer> sortedList = new ArrayList<Integer>();

        public void insert(int rev){
            cache.put(0, rev);
            revCache.put(rev, new HashSet<>());
            revCache.get(rev).add(0);
        }

        public void insert(int rev, int index){
            cache.putIfAbsent(index, 0);
            int val = cache.get(index);
            val += rev;
            cache.put(index, val);

            revCache.get(val).remove(index);
            revCache.putIfAbsent(val, new HashSet<>());
            revCache.get(val).add(index);
        }


        private int[] getKCustomerRevenueBelowThreshold(int threshold, int k){
            int[] ans = new int[k];
            Arrays.fill(ans, -1);

            sortedList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            int index = 0;
            finish : for (int i = 0; i < k; i++){
                Set<Integer> indexs = revCache.get(sortedList.get(i));
                for (int in : indexs){
                    ans[++index] = in;
                    if (index == k) {
                        break finish;
                    }
                }
            }

            return ans;
        }



        // Solution 2 : design a customer class and use min heap (priorityQueue)

    static class Customer{
            int id;
            int rev;

            public Customer(int id, int rev){
                this.id = id;
                this.rev = rev;
            }
        }

    static PriorityQueue<Customer> minHeap = new PriorityQueue<>((a, b) -> (a.rev - b.rev));
    static Map<Integer, Customer> visited = new HashMap<>();
        public static void insert_Design(int rev){
            visited.putIfAbsent(0, new Customer(0, rev));
        }

        public static void insert_Design(int rev, int index){
            visited.putIfAbsent(index, new Customer(index, 0));
            Customer customer = visited.get(index);
            minHeap.remove(customer);
            customer.rev += rev;

            visited.put(index, customer);
            minHeap.add(customer);
        }

        private static int[] getKCustomerRevenueBelowThreshold_Design(int threshold, int k) {
            int[] ans = new int[k];
            Arrays.fill(ans, -1);
            PriorityQueue<Customer> tempPQ = new PriorityQueue<>(minHeap);

            for (int i = 0; i < k; i++){
                Customer customer = tempPQ.poll();
                ans[i] = customer.id;
            }
            return ans;
        }

        public static void main(String[] args){
            insert_Design(100);
            insert_Design(200, 0);
            insert_Design(150, 1);
            insert_Design(150, 2);
            insert_Design(150, 3);
            insert_Design(150, 4);
            getKCustomerRevenueBelowThreshold_Design(200, 4);
        }
    }
