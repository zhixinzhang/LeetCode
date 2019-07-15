package DataStructure.Integer;

public class _693_BinaryNumberwithAlternatingBits_Binary{

	    public boolean hasAlternatingBits(int n) {
        String cheat = Integer.toBinaryString(n);
        if (cheat.length() < 2) return true;  
        for (int i = 0; i < cheat.length() - 1; i++) {      //1010
            if (cheat.charAt(i) == cheat.charAt(i+1))       // 0 1 , 1,2 ,2 3
                return false;
        }
        return true;
    }
}