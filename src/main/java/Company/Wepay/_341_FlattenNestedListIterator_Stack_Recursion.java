package Company.Wepay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * 
*/
public class _341_FlattenNestedListIterator_Stack_Recursion implements Iterator<Integer> {

    /**User arraylist to maintain all integer and we can keep all integer records   O(N + D) space  and O (N + L) time  O(1) for hasNext and next()*/
    private List<Integer> integers = new ArrayList<Integer>();
    private int position = 0; // Pointer to next integer to return.
    
    public _341_FlattenNestedListIterator_Stack_Recursion(List<NestedInteger> nestedList) {
        flattenList(nestedList);
    }

        // Recursively unpacks a nested list in DFS order.
    private void flattenList(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                integers.add(nestedInteger.getInteger());
            } else {
                flattenList(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        // As per Java specs, we should throw an exception if no more ints.
        // if (!hasNext()) throw new NoSuchElementException();
        // Return int at current position, and then *after*, increment position.
        if (!hasNext()) {
            return null;
        }
        
        return integers.get(position++); 
    }

    @Override
    public boolean hasNext() {
        return position < integers.size();
    }


    /**User Stack to store all nestInteger  The worst-case occurs when the initial input nestedList consists entirely of integers and empty lists (everything is in the top-level).
     *  In this case, every item is reversed and stored, giving a total time complexity of O(N+L)O(N + L)O(N+L).time  O(1) for hasNext and next()*/
    
    // private Stack<NestedInteger> stack;

    // public NestedIterator(List<NestedInteger> nestedList) {
    //     stack = new Stack<>();
    //     flattenList(nestedList);
    // }

    // @Override
    // public Integer next() {
    //     return hasNext() ? stack.pop().getInteger() : null;
    // }

    // @Override
    // public boolean hasNext() {
    //     while (!stack.isEmpty()) {
    //         if (stack.peek().isInteger()) return true;
    //         flattenList(stack.pop().getList());
    //     }
    //     return false;
    // }

    // private void flattenList(List<NestedInteger> list) {
    //     for (int i = list.size() - 1; i >= 0; i--) {
    //         stack.push(list.get(i));
    //     }
    // }

}
