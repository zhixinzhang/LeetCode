package Company.Ebay;

/**
 * Here, we will be using Array for better optimization. We will create a array 
 * of given maxSize and we will keep 
 * a Ptr to update our values in array. Based on two conditon of k 
 * we will update the values in array.
 * 
*/
public class _1381_DesignAStackWithIncrementOperation {

    int[] data;
    int ptr=0;
    int max;
    public _1381_DesignAStackWithIncrementOperation(int maxSize) {
        this.data =new int[maxSize];
        this.max=maxSize;
    }
    
    public void push(int x) {
        if(ptr==data.length) return;
        data[ptr++]=x;
    }
    
    public int pop() {
        if(ptr==0){
            return -1;
        }
        return data[--ptr];
    }
    
    public void increment(int k, int val) {
        if(k > ptr){
            for(int i=0 ;i<max ; i++){
                data[i]=data[i]+val;
            }
        }else{
            for(int i=0; i<k ;i++){
                data[i]=data[i]+val;
            }
        }
    }
}
