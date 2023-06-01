package Company.Square;
// https://www.1point3acres.com/bbs/thread-963175-1-1.html


/**
 * No behavioral questions.
Design a basic text editor with 2 functions:
typeIn(char) -> adds a character to the end of the line
backspace() -> removes a char from the end of the line
toString() -> prints the line to the string
 * 
*/
public class _Design_Text_Editor_withoutCursor {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        typeIn('h');
        typeIn('e');
        typeIn('l');
        backspace();
        // toString();

        _Design_Text_Editor_withoutCursor editor = new _Design_Text_Editor_withoutCursor();
        editor.typeIn("H");
        editor.typeIn("E");
        editor.typeIn("L");
        editor.typeIn("L");
        editor.typeIn("O");
        editor.backSpace();
        String ans = editor.toString(); // HELLO|
        System.out.println(ans);
    }

    private static void typeIn(Character c){
        sb.append(c);
        System.out.println(sb.toString());
    }

    private static void backspace(){
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    class Node {
        Character value;
        Node previous;
        Node next;
        
        public Node(Character value){
            this.value = value;
        }

        public Node (Character value, Node pre, Node next){
            this.value = value;
            this.previous = pre;
            this.next = next;
        }
    }

    Node head = new Node(null);
    Node tail = new Node(null);

    public _Design_Text_Editor_withoutCursor(){
        this.head.next = this.tail;
        this.tail.previous = this.head;
    } 

    public void typeIn(String word){
        char[] cs = word.toCharArray();
        for (char c : cs){
            Node newNode = new Node(c, tail.previous, tail);
            tail.previous.next = newNode;
            tail.previous = newNode;
        }
    }

    public void backSpace(){
        Node curNode = tail.previous;
        if (curNode == null || curNode.value == null) {
            return;
        }
        curNode = curNode.previous;
        curNode.next = tail;
        tail.previous = curNode;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node cuNode = head.next;
        while(cuNode != null && cuNode.value != null){
            sb.append(cuNode.value);
            cuNode = cuNode.next;
        }

        return sb.toString();
    }
}
