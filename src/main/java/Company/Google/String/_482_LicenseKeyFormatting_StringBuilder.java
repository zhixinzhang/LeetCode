package Company.Google.String;

/**
 * Created by zhang on 2018/8/5.
 */
public class _482_LicenseKeyFormatting_StringBuilder {
    public String licenseKeyFormatting_SB(String S, int K) {
        if (S == null || S.length() == 0 || K == 0)    return S;
        StringBuilder sb = new StringBuilder();
        S = S.replaceAll("-","");
        S = S.toUpperCase();
//        S = S.toLowerCase();
        for (char c : S.toCharArray())
            sb.append(c);
        int len = S.length();
        for (int i = K; i<len; i+=K){
            sb.insert(len - i, "-");
        }
        return sb.toString();
    }
}
