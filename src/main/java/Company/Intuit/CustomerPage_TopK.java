package Company.Intuit;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/22/19
 * Time: 1:11 PM
 * Description:
 *https://www.1point3acres.com/bbs/thread-517161-1-1.html
 *
 * coding是，customerID对应pageID。一个pageID可以对应多个customerID，但是一个customerID只能对应一个pageID。
 * 问如何求被访问最多(并且是被distinct的costumer访问)的pageID？follow up 是，如果有很多个customer，并且要求的是top k个被访问最多的pageID。怎么求？时间复杂度是多少？
 */


public class CustomerPage_TopK {
    class Customer{
        int id;
        List<String> pageIds;
        public Customer(int id){
            this.id = id;
            pageIds = new ArrayList<>();
        }
    }
    class Page{
        int id;
        public Page(int id){
            this.id = id;
        }
    }

    public Customer findMaxPage(List<Customer> customers){
        int max = 0;
        Customer ans = null;
        for (Customer c : customers){
            HashSet<String> hs = new HashSet<>(c.pageIds);
            if (hs.size() > max)
                ans = c;
        }
        return ans;
    }

    public List<Customer> findMaxPage_TopK(List<Customer> customers, int k) {
        List<Customer> ans = new ArrayList<>();
        PriorityQueue<Customer> pq = new PriorityQueue<Customer>(new Comparator<Customer>(){
            @Override
            public int compare(Customer c1, Customer c2){
                return c1.pageIds.size() - c2.pageIds.size();
            }
        });

        for (Customer c : customers){
            pq.add(c);
            if (pq.size() > k)
                pq.poll();
        }
        
        while (!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}
