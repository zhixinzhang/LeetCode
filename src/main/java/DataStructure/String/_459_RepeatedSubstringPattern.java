package DataStructure.String;
//找到和第一个字符相同的字符，开始比对是否重复，如果重复，那么把字符串中相同的全部替换为空，如果结果为空，那么的确是符合要求的
public class _459_RepeatedSubstringPattern{
	public boolean repeatedSubstringPattern(String str) {
		int l = str.length();
	for(int i=l/2;i>=1;i--) {
		if(l%i==0) {
			int m = l/i;
			String subS = str.substring(0,i);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<m;j++) {
				sb.append(subS);
			}
			if(sb.toString().equals(str)) return true;
		}
	}
	return false;

	}	
}