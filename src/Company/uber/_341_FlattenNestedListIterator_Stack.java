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
//    Stack<NestedInteger> stack = new Stack<>();
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        for(int i = nestedList.size()-1; i >= 0 ; i--){
//            stack.push(nestedList.get(i));
//        }
//    }
//
//    @Override
//    public DataStructure.Integer next() {
//        NestedInteger cur = stack.pop();
//        return cur.getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while(!stack.isEmpty()){
//            NestedInteger cur = stack.peek();
//            if(cur.isInteger())
//                return true;
//            stack.pop();
//            for(int i = cur.getList().size()-1; i>=0; i--){
//                stack.push(cur.getList().get(i));
//            }
//        }
//        return false;
//    }
}
