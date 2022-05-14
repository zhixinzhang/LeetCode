package DataStructure.Integer;

public class _504_Base7{
		public static void main(String[] args){
			convertTo7(100);
		}
	    public static String convertTo7(int num) {
	    	if(num == 0) return "0";
	    	StringBuilder sb = new StringBuilder();
	        boolean negative = false;
	        
	        if (num < 0) {
	            negative = true;
	        }
	        while (num != 0) {
	            sb.append(Math.abs(num % 7));
	            num = num / 7;
	        }
	        
	        if (negative) {
	            sb.append("-");
	        }
	        
	        return sb.reverse().toString();
	    }
}