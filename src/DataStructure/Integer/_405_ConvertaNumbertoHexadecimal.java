package DataStructure.Integer;

// 转成16进制
public class _405_ConvertaNumbertoHexadecimal{
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, map[num & 0b1111]);
            num = num >>> 4;
        }
        return sb.toString();
    }

}