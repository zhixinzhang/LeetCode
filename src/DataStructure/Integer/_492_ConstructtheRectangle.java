package DataStructure.Integer;

// 先求平方根
public class _492_ConstructtheRectangle{
	    public int[] constructRectangle(int area) {
	    	int[] res = new int[2];
	    	if(area == 0) return res;
	    	int a = (int)Math.sqrt(area); 		// area 15  --- > 4.....
	    	while(area%a != 0){
	    		a--;
	    	}
	    	res[0]  = area/a;
	    	res[1]  = a;
	    	return res;
	    }
}