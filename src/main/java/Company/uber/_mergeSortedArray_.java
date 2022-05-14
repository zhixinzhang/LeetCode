package Company.uber;

import DataStructure.LinkList.ListNode;

import java.util.*;

/**
 * Created by zhang on 2018/9/8.
 */
public class _mergeSortedArray_ {
    public static void main(String[] args){
        int[] array1 = new int[]{3,3,5};
        int[] array2 = new int[]{1,2,4,5,6};
        merge_ListNode(array1,array2);
        merge_TwoPointer(array1,array2);
    }

    public static int[] merge_ListNode(int[] array1, int[] array2){
        ListNode dum = new ListNode(-1);
        dum.next = new ListNode(array1[0]);
        ListNode q = dum.next;
        int sumSize = 1;
        for (int i = 1; i < array1.length;i++){
            if (q == null || q.val != array1[i]){
                q.next = new ListNode(array1[i]);
                sumSize++;
            }
        }
        //  3  5    -   1 2  4 5  6
        ListNode temp = dum.next;
        ListNode prev = dum;
        for (int m = 0; m < array2.length; m++){
            if (array2[m] == temp.val)
                continue;
            if (temp.val >  array2[m]){
                ListNode cur = new ListNode(array2[m]);
                prev.next = cur;
                cur.next = temp;
                prev = prev.next;
                sumSize++;
            }else {
                ListNode cur = new ListNode(array2[m]);
                cur.next = temp.next;
                temp.next = cur;
                prev = cur;
                temp = cur.next;
                sumSize++;
            }
        }
        int[] merge = new int[sumSize];
        int i = 0;
        while (dum.next != null){
            merge[i] = dum.next.val;
            dum = dum.next;
            i++;
        }
        return merge;
    }

    public static int[] merge_TwoPointer(int[] array1, int[] array2){
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        for (;j < array2.length && i < array1.length;){
            if (array1[i] < array2[j]){
                if (res.isEmpty())
                    res.add(array1[i]);
                else if (res.get(res.size() - 1) != array1[i])
                    res.add(array1[i]);
                i++;
            }else if (array1[i] == array2[j]){
                if (res.size() == 0){
                    res.add(array1[i]);
                }else if (res.get(res.size()-1) != array1[i]){
                    res.add(array1[i]);
                }
                i++;j++;
            }else if (array1[i] > array2[j]){
                if (res.size() == 0){
                    res.add(array2[j]);
                }else if (res.get(res.size() - 1) != array2[j]){
                    res.add(array2[j]);
                }
                j++;
            }
        }
        while (i < array1.length){
            res.add(array1[i]);
            i++;
        }
        while (j < array2.length){
            res.add(array2[j]);
            j++;
        }
        int[] n = new int[res.size()];
        for (int k = 0; k < n.length; k++)
            n[k] = res.get(k);
        System.out.println(res);
        return n;
    }
}
