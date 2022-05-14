package DataStructure.Integer;

public class _507_PerfectNumber{
    public boolean checkPerfectNumber(int num) {
    	if(num == 1) return false;
    	int sum = 0;
    	for(int i = 0 ;i <= Math.sqrt(num);i++){
    		if(num % i == 0){
    			sum += i + num/i;
    		}
    	}
    	sum++;

    	return sum == num;
    }	
}