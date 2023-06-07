package Company.Square.Algo.StringWord;

// https://www.1point3acres.com/bbs/thread-989586-1-1.html
/**
 * Pig Latin
transfer form string and add "ay" at the end
w/ 4 steps
1.
// hello --> ellohay
// hello world --> ellohay orldway
2.
// hello World --> ellohay Orldway
3.
// hello, won't World! --> ellohay, on'‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌tway Orldway!
4.
// apple --> appleway
// Oval! --> Ovalway!
// Egg --> Eggway
 * 
 * 
*/
public class _PigLatin_ {
    static boolean isVowel(char ch)  {   
        return (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u');   
    }   
    // Step 1
    /**
     * // hello --> ellohay
        hello world --> ellohay orldway
     * 
    */
    static String pigLatinWord(String words)  {   
    //the index of the first vowel is stored  
        String[] wordArray = words.split(" ");
        String newWords = "";
        for (String word : wordArray){
            String curNewWord = "";
            int stringlength = word.length();   
            int index = -1;   
            for (int i = 0; i < stringlength; i++){   
                if (isVowel(word.charAt(i))) {   
                    index = i;   
                    if (i == 0) {
                        curNewWord = word + "ay";           
                    } else {
                        // Take all characters after index (including index). Append all characters which are before index. Finally append "ay"
                        curNewWord = word.substring(index) + word.substring(0, index) + "ay";
                    }

                    newWords += curNewWord + " ";
                    break;   
                }   
            }

            if(index == -1)   
                newWords += curNewWord + " ";   
        }        

        return newWords.trim();   
    }   

    // Step 2
    /**
     * hello World --> ellohay Orldway
     * 
    */
    static String pigLatinWordWithUpperCase(String words)  {   
        //the index of the first vowel is stored  
            String[] wordArray = words.split(" ");
            String newWords = "";
            for (String word : wordArray){
                String curNewWord = "";
                int stringlength = word.length(); 
                boolean charUpper = Character.isUpperCase(word.charAt(0));  
                int index = -1;   
                for (int i = 0; i < stringlength; i++){   
                    if (isVowel(word.charAt(i))) {   
                        index = i;
                        if (i == 0) {
                            curNewWord = word + "ay";           
                        } else {
                            // Take all characters after index (including index). Append all characters which are before index. Finally append "ay"
                            // World -> Orldway
                            curNewWord = word.substring(index) + word.substring(0, index) + "ay";
                            if (charUpper) {
                                String a = curNewWord.substring(0, 1).toUpperCase();
                                curNewWord = a + curNewWord.substring(1).toLowerCase();                                
                            }
                        }
    
                        newWords += curNewWord + " ";
                        break;   
                    }   
                }
    
                if(index == -1)   
                    newWords += curNewWord + " ";   
            }        
    
            return newWords.trim();   
        }   

       
// step 3 hello, won't World! --> ellohay, on'‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌tway Orldway!  ellohay, on'tway Orldway!

static String pigLatinWordWithSign(String words)  {
        String[] wordArray = words.split(" ");
        String newWords = "";
        for (String word : wordArray){
            String curNewWord = "";
            boolean charUpper = Character.isUpperCase(word.charAt(0));  
            int index = -1;   

            for (int i = 0; i < word.length(); i++){   
                if (isVowel(word.charAt(i))) {   
                    index = i;
                    if (i == 0) {
                        if (Character.isAlphabetic(word.charAt(word.length() - 1))) {
                            curNewWord = word + "ay";       
                        } else {
                            curNewWord = word.substring(0, word.length() - 1) + "ay" + word.charAt(word.length() - 1);  // apple,  appleay,  
                        }   
                    } else {
                        // Take all characters after index (including index). Append all characters which are before index. Finally append "ay"
                        // hello,  -> ellohay,
                        // World -> Orldway
                        // won't  -> on'tway
                        // index = 1
                        if (Character.isAlphabetic(word.charAt(word.length() - 1))) {
                            curNewWord = word.substring(index) + word.substring(0, index) + "ay";      
                        } else {
                            curNewWord = word.substring(index, word.length() - 1) + word.substring(0, index) + "ay" + word.charAt(word.length() - 1);  // apple,  appleay,  
                        }  

                        if (charUpper) {
                            String a = curNewWord.substring(0, 1).toUpperCase();
                            curNewWord = a + curNewWord.substring(1).toLowerCase();
                        }
                    }

                    newWords += curNewWord + " ";
                    break;   
                }   
            }

            if(index == -1)   
                newWords += curNewWord + " ";   
        }        

        return newWords.trim();   
    }   

    //step 4 
    /**
     * // apple --> appleway
// Oval! --> Ovalway!
// Egg --> Eggway
     * 
    */

    static String pigLatinWordWithSignFour(String words)  {
        String[] wordArray = words.split(" ");
        String newWords = "";
        for (String word : wordArray){
            String curNewWord = "";
            boolean charUpper = Character.isUpperCase(word.charAt(0));  
            int index = -1;   

            for (int i = 0; i < word.length(); i++){   
                if (isVowel(word.charAt(i))) {   
                    index = i;
                    if (i == 0) {
                        if (Character.isAlphabetic(word.charAt(word.length() - 1))) {
                            curNewWord = word + "way";       
                        } else {
                            curNewWord = word.substring(0, word.length() - 1) + "way" + word.charAt(word.length() - 1);  // apple,  appleay,  
                        }   
                    } else {
                        // Take all characters after index (including index). Append all characters which are before index. Finally append "ay"
                        // hello,  -> ellohay,
                        // World -> Orldway
                        // won't  -> on'tway
                        // index = 1
                        if (Character.isAlphabetic(word.charAt(word.length() - 1))) {
                            curNewWord = word.substring(index) + word.substring(0, index) + "ay";      
                        } else {
                            curNewWord = word.substring(index, word.length() - 1) + word.substring(0, index) + "ay" + word.charAt(word.length() - 1);  // apple,  appleay,  
                        }  

                        if (charUpper) {
                            String a = curNewWord.substring(0, 1).toUpperCase();
                            curNewWord = a + curNewWord.substring(1).toLowerCase();
                        }
                    }

                    newWords += curNewWord + " ";
                    break;   
                }   
            }

            if(index == -1)   
                newWords += curNewWord + " ";   
        }        

        return newWords.trim();   
    } 

    //Driver code   
    public static void main(String args[]) {   
        String plstring1 = pigLatinWord("hello");
        String plstring2 = pigLatinWord("hello world");

        System.out.println(plstring1);  
        System.out.println(plstring2);  

        String plstring3 = pigLatinWordWithUpperCase("hello");
        String plstring4 = pigLatinWordWithUpperCase("hello World");
        System.out.println(plstring3);  
        System.out.println(plstring4);  

        System.out.println("Step 3  ******** "); 
        String plstring5 = pigLatinWordWithSign("hello, won't World!"); // ellohay, on'tway Orldway!
        String plstring6 = pigLatinWordWithSign("hello World");
        System.out.println(plstring5);  
        System.out.println(plstring6);  

        System.out.println("Step 4 ******** "); 
        String plstring7 = pigLatinWordWithSignFour("apple"); // ellohay, on'tway Orldway!
        String plstring8 = pigLatinWordWithSignFour("Oval!");
        String plstring9 = pigLatinWordWithSignFour("Egg");

        System.out.println(plstring7);  
        System.out.println(plstring8);
        System.out.println(plstring9);  

        // String plstring1=pigLatinWord("butter"); //begin with consonant   
        // String plstring2=pigLatinWord("apple"); //begin with vowel   appleway
        // String plstring4=pigLatinWord("child"); //consonant cluster word  
        // String plstring5=pigLatinWord("egg"); //begin with vowel    eggway
        // String plstring6=pigLatinWord("store"); //consonant cluster word  
        // String plstring7=pigLatinWord("eunoia"); //contains all vowels  
        // String plstring8=pigLatinWord("nymphly"); //contains no vowel  ?
        // if (plstring1=="-1")   
        //     System.out.println("Pig Latin is not possible, the string must have at least a vowel.");   
        // else  
        //     System.out.println(plstring1);  

        // System.out.println(plstring2);  
        // System.out.println(plstring4);  
        // System.out.println(plstring5);  
        // System.out.println(plstring6);  
        // System.out.println(plstring7);  
        // System.out.println(plstring8);  


        // String p = pigLatinWord("hello");  
        // System.out.println(p); 
        // String pp = pigLatinWord("hello world");  
        // System.out.println(pp); 

        // String p3 = pigLatinWord("hello,");  
        // System.out.println(p3); 


        // String p9 = pigLatinWord("apple");  
        // System.out.println(p9); 
    }   



      
      
}
