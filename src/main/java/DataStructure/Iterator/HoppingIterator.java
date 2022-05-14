package DataStructure.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/7/19
 * Time: 10:29 PM
 * Description:
 */


public class HoppingIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;
    private T nextItem;
    private final int numHops;
    private boolean first;

    public HoppingIterator(Iterator<T> iterator, int numHops){
        if (numHops < 0){
            throw new IllegalArgumentException("numHops needs to be >= 0. ");
        }
        this.numHops = numHops;
        this.iterator = iterator;
        nextItem = null;
        first = true;

    }
    @Override
    public T next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        T toReturn = nextItem;
        nextItem = null;
        return toReturn;
    }
    @Override
    public boolean hasNext(){
        if (nextItem != null)
            return true;
        if (!first){
            for (int hop = 0; hop < numHops && iterator.hasNext(); hop++) {
                iterator.next();
            }
        }
        if (iterator.hasNext()) {
            nextItem = iterator.next();
            first = false;
        }

        return nextItem != null;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        HoppingIterator<Integer> hi = new HoppingIterator<Integer>(
                list.iterator(), -1);
        int a = hi.next();
        System.out.println(hi.next());
        System.out.println(hi.next());
        System.out.println(hi.hasNext());
    }
}
