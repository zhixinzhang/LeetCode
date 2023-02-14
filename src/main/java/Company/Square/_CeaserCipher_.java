package Company.Square;

// https://www.1point3acres.com/bbs/thread-919874-1-1.html
//电面 Pair Coding: Ceaser Cipher
// 就是给了efg，我记得也会告诉你每个character对应什么character，把efg map回abc
public class _CeaserCipher_ {
    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String message, int shiftKey) {
      message = message.toLowerCase();
      String cipherText = "";
      for (int ii = 0; ii < message.length(); ii++) {
        int charPosition = alpha.indexOf(message.charAt(ii));
        int keyVal = (shiftKey + charPosition) % 26;
        char replaceVal = alpha.charAt(keyVal);
        cipherText += replaceVal;
      }
      return cipherText;
    }
  
    public static void main(String[] args) {
      String message = "abc";
      int key = 3;
      System.out.println("\nEncrpyted msg:" + encrypt(message, key));
    } //main method ends
}
