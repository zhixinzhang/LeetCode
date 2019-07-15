package Algo_Summary;

import DataStructure.LinkList.ListNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/15/19
 * Time: 2:13 PM
 * Description:
 */


public class DataStructure {

    public static void main(String[] args){
        /**Operation
         * 4.位与运算符（&）
         *
         * 运算规则：两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。
         *
         * 比如：129&128.
         *
         * 129转换成二进制就是10000001，128转换成二进制就是10000000。从高位开始比较得到，得到10000000，即128.
         * **/
        //Character
        Character.isDigit('c');
        Character.isLetterOrDigit('c');
        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(1);
        result.addFirst(2);
        result.addFirst(3);

        /**
         BigInteger实现了任意精度的整数运算;
         BigDecimal实现了任意精度的浮点数运算。
         * **/
        //DataStructure.Integer
        int val = Integer.valueOf("123456".substring(0, 2));
        int val2 = Integer.compare(3,4);
        int val3 = Integer.parseInt("123");

        //Double            123.456
        double a = Double.parseDouble("123.456");



        //String
        String s1 = "USD124.4";
        String s2 = s1.substring(2);   // D124.4
        s2.toLowerCase();
        s2.toUpperCase();
        s2.toCharArray(); // D 1 2 3 . 4
        s2.indexOf("D");  // 0
        String s4 = String.valueOf(1233);
        String s3 = Arrays.toString(new int[]{1,2,3});

        StringBuilder sb = new StringBuilder();
        sb.append(0);  //"0"
        sb.append("(");
        sb.insert(0, "(");  //在0的位置插入
        sb.deleteCharAt(0);
        sb.delete(2,3);
        //int[]
        int[] A = new int[]{1,2,3,4,5};
        Arrays.sort(A);



        // Lists
        List<int[]> res = new ArrayList<>();
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> qqq = new ArrayDeque<>();

        Deque<Integer> dq = new LinkedList<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        Deque<Integer> dq3 = new ArrayDeque<>();

        // TOP K  找Top K小 用大根maxHeap
        // 找Top K 大 用小跟 minHeap
        LinkedList<Integer> qq = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((aa, bb) -> bb[1] - aa[1]);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((entry1, entry2) -> entry2.getValue() - entry1.getValue());
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });




        //MAP
        Map<Integer, Integer> disMap = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : disMap.entrySet()) {
            int aa = entry.getKey(), b = entry.getValue();
        }
        for (int i : disMap.keySet())   continue;
        for (int i : disMap.values())   continue;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int c1 = tm.higherKey(1);        //不包含1的 比1大一点的key 比如 2
        int cc1 = tm.ceilingKey(1);        //包含1的 有1会输出1
        int ccc1 = tm.lowerKey(1);
        int cccc1 = tm.floorKey(1);

        char cc = 'a';
        switch (cc){
            case '(' :
                break;
            case ')':
                break;
             default:
                 break;
        }
    }

    public void BuildUpListNode (){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int i = 0;
        while (i < arr.length){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
            i++;
        }
//        start(head.next, 3);
    }
    public static ListNode BuildUpListNode_Recursion (ListNode head, int i, int[] arr){
        if (i < arr.length){
            head = new ListNode(arr[i]);
            head.next = BuildUpListNode_Recursion(new ListNode(0), ++i, arr);
        }
        return head;
    }
}
