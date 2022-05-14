package Company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/21/19
 * Time: 11:10 PM
 * Description:
 */


public class ArrayStack {
    int size;
    int top;
    int[] array;
    public ArrayStack(int size){
        this.size = size;
        array = new int[size];
        top = -1;
    }

    public void push(int val){
        if (top >= size)
            throw new NullPointerException("stack is full");
        array[++top] = val;
    }
    public int pop(){
        if (top < 0)
            throw new NullPointerException("stack is empty");
        return array[top--];

    }
}

