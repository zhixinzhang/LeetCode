package DataStructure.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/7/19
 * Time: 11:34 PM
 * Description:
 */


public class _281_ZigzagIterator_LinkedList {
    LinkedList<Iterator> list;
    public _281_ZigzagIterator_LinkedList(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();

        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
    public static void main(String[] args){
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        List<Integer> ll = new ArrayList<>();
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);

    }

}
