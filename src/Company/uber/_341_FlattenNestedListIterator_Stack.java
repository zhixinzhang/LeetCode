package Company.uber;

/**
 * Created by zhang on 2018/9/16.
 */


//public class NestedIterator implements Iterator<DataStructure.Integer> {
//    private int counter;
//    private List<DataStructure.Integer> flattenedList = new DataStructure.ArrayList<>();
//    public NestedIterator(List<NestedInteger> nestedList) {
//        this.counter = 0;
//        flatten(nestedList);
//    }
//
//    @Override
//    public DataStructure.Integer next() {
//        int result = flattenedList.get(counter);
//        counter++;
//        return result;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return counter < flattenedList.size();
//    }
//
//    private void flatten(List<NestedInteger> list) {
//        for(NestedInteger l : list) {
//            if (l.isInteger()) {
//                flattenedList.add(l.getInteger());
//            } else {
//                flatten(l.getList());
//            }
//        }
//    }
//}
public class _341_FlattenNestedListIterator_Stack {
//    private Stack<NestedInteger> stack;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        stack = new Stack<>();
//        flattenList(nestedList);
//    }
//
//    @Override
//    public Integer next() {
//        return hasNext() ? stack.pop().getInteger() : null;
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (!stack.isEmpty()) {
//            if (stack.peek().isInteger()) return true;
//            flattenList(stack.pop().getList());
//        }
//        return false;
//    }
//
//    private void flattenList(List<NestedInteger> list) {
//        for (int i = list.size() - 1; i >= 0; i--) {
//            stack.push(list.get(i));
//        }
//    }
}
