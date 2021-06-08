package DataStructure.Design;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Luke Zhang
 * @Date 2021-06-07 14:24
 *
 * https://www.1point3acres.com/bbs/thread-551222-1-1.html
 */
public class _CombinedInterator_Thumbtack {

    static class IteratorThumb{
        Iterator<Integer> iterator1;
        Iterator<Integer> iterator2;

        Set<Integer> set = new HashSet<>();
        List<Integer> l1 = Arrays.asList(new Integer[]{2, 5, 2, 2, 6, 1});
        List<Integer> l2 = Arrays.asList(new Integer[]{3, 3, 1, 7});

        public IteratorThumb(){
            iterator1 = l1.iterator();
            iterator2 = l2.iterator();
        }

        public boolean hasNext(){
            if (iterator1.hasNext() || iterator2.hasNext())
                return true;
            return false;
        }

        public int next() throws InvalidParameterException{
            while (iterator1.hasNext()){
                int cur = iterator1.next();
                if (!set.contains(cur)) {
                    set.add(cur);
                    return cur;
                }
            }
            while (iterator2.hasNext()){
                int cur = iterator2.next();
                if (!set.contains(cur)) {
                    set.add(cur);
                    return cur;
                }
            }

            throw new InvalidParameterException("a");
        }
    }

    public static void main(String[] args){
        IteratorThumb iteratorThumb = new IteratorThumb();
        iteratorThumb.hasNext();
        System.out.println(iteratorThumb.hasNext());

        System.out.println(iteratorThumb.next());
        System.out.println(iteratorThumb.next());
        System.out.println(iteratorThumb.next());
        System.out.println(iteratorThumb.next());
        System.out.println(iteratorThumb.next());
        System.out.println(iteratorThumb.next());

        System.out.println(iteratorThumb.hasNext());
    }
}
