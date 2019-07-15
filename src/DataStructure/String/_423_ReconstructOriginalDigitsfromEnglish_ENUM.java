package DataStructure.String;


//https://www.cnblogs.com/grandyang/p/5996239.html
//用枚举  enum
public class _423_ReconstructOriginalDigitsfromEnglish_ENUM{

 public String originalDigits(String s) {
  int[] count = new int[10];
    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (c == 'z') count[0]++;       //zero
        if (c == 'w') count[2]++;       //two
        if (c == 'x') count[6]++;       //six
        if (c == 's') count[7]++; //7-6 seven six
        if (c == 'g') count[8]++;       // eight
        if (c == 'u') count[4]++;       //four
        if (c == 'f') count[5]++; //5-4 five four
        if (c == 'h') count[3]++; //3-8 three
        if (c == 'i') count[9]++; //9-8-5-6 
        if (c == 'o') count[1]++; //1-0-2-4
    }
    count[7] -= count[6];
    count[5] -= count[4];
    count[3] -= count[8];
    count[9] = count[9] - count[8] - count[5] - count[6];
    count[1] = count[1] - count[0] - count[2] - count[4];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= 9; i++){
        for (int j = 0; j < count[i]; j++){
            sb.append(i);
        }
    }
    return sb.toString();
    }

}