package google;

public class NegativePlusOne{
	public static void  main(String[] args){
//		plusOne(new char[]{'-','2','1','0','0'});
//		plusOne(new char[]{'1','0','0'});
		plusOne(new char[]{'9','8'});

	}

	public static char[] plusOne(char[] dig){
		if(dig == null || dig.length == 0) return dig;
			boolean needChange = false;
			if(dig[0] == '-'){
				char[] dig2 = new char[dig.length -1];
				// - 2000 ----  - 1999    -1900 ---- -999
				for(int i = dig.length-1;i>=0;i--){
					if(dig[i] == '0'){
						dig[i] = '9';
						dig2[i-1] = '9';
						needChange  = true;
						continue;
						}
					if(needChange){
						dig[i] = (char)(Integer.valueOf(dig[i])-1);
						dig2[i-1]=dig[i];
						needChange = false;
					}else{
						if (i==1 && dig[i] != 0){
							return dig;
						}else{
							return dig2;
						}
					}
			}
		}else{
			char[] dig2 = new char[dig.length +1];
			for(int i = dig.length-1;i>=0;i--){
			//  99  ---- 100   189  ---  190
				if(dig[i] == '9'){
					dig[i] = '0';
					needChange = true;
				}else{
					dig[i] = (char)(Integer.valueOf(dig[i])+1);
					return dig;
				}
			}
				// if digits are 99...99 and the result should be 100...00.
				dig2[0] = '1';
				for (int i = 1; i<dig2.length;i++){
						dig2[i] = dig[i-1];
				}
				return dig2;
			}
		return dig;
	}
}
