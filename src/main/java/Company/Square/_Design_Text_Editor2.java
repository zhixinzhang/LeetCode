package Company.Square;
import java.util.*;



// https://www.1point3acres.com/bbs/thread-963175-1-1.html
// Design a basic text editor with 2 functions:
// typeIn(char) -> adds a character to the end of the line
// backspace() -> removes a char from the end of the line
// toString() -> prints the line to the string
// ___
// Now add a cursor and the ability to move the cursor left and right in the line.
// e.g.
// editor.typeIn("H")
// editor.typeIn("l")
// editor.moveCursor("left")
// editor.typeIn("e")
// editor.toString() -> "He|l"
// Now add a method
// newLine() -> appends a new line at the end of the cursor
// moveCursor(up, down, left, right)
public class _Design_Text_Editor2 {
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
    
    int col = 0; 
    int row = 0;
    List<Node> text = new ArrayList<>();
    Node head = new Node(null);
    Node tail = new Node(null);
    Node cursor = new Node('|');

    public _Design_Text_Editor2(){
        this.head.next = this.cursor;
        this.cursor.previous = this.head;
        this.tail.previous = this.cursor;
        this.cursor.next = this.tail;

        text.add(head);
    } 

    public void typeIn(String word){
        char[] cs = word.toCharArray();
        for (char c : cs){
            Node newNode = new Node(c, cursor.previous, cursor);
            cursor.previous.next = newNode;
            cursor.previous = newNode;
        }
    }

    // 4|5
    public void backspace(){
        Node cuNode = cursor.previous;
        if (cuNode == null || cuNode.value == null){
            return;
        }

        cuNode = cuNode.previous; // null
        cuNode.next = cursor;
        cursor.previous = cuNode;
    }

    public void backspace(int k){
        int deleted = 0;
        Node cuNode = cursor.previous;
        while (deleted < k && cuNode != null && cuNode.value != null){
            cuNode = cuNode.previous; // null
        }

        cuNode.next = cursor;
        cursor.previous = cuNode;
    }

    // HEL| ->  HEL  |
    // HE|L ->  HE   |L
    public void newline(){
        cursor.previous.next = new Node(null);        
        Node newHead = new Node(null);
        newHead.next = cursor;
        cursor.previous = newHead;
        
        text.add(newHead);
    }

    // HE|LL
    // |L  -> L|
    public void moveCursor(String dir) {        
        Node current = null;
        switch (dir) {
            case "left":
                current = this.cursor.previous;
                if (current.previous != null && current.value != null) {
                    current = current.previous;
                }
                this.cursor.previous.next = this.cursor.next;
                this.cursor.next.previous = this.cursor.previous;
                this.cursor.previous = current;
                this.cursor.next = current.next;
                current.next = this.cursor;
                break;
            case "right":
                current = this.cursor.next;
                if (current.next != null && current.value != null) {
                    current = current.next;
                }
                this.cursor.previous.next = this.cursor.next;
                this.cursor.next.previous = this.cursor.previous;
                this.cursor.previous = current.previous;
                this.cursor.next = current;
                current.previous.next = this.cursor;
                break;
            default:
                try{
                    Exception ex = new IllegalArgumentException("wrong direction input");
                    throw ex;
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    public void moveCursor(String[] dirs){
        
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

    public String lastLineToString(){
        StringBuilder sb = new StringBuilder();
        int len = text.size();
        Node cuNode = text.get(len - 1).next;
        while(cuNode != null && cuNode.value != null){
            sb.append(cuNode.value);
            cuNode = cuNode.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        _Design_Text_Editor2 editor = new _Design_Text_Editor2();
        editor.typeIn("H");
        editor.typeIn("E");
        editor.typeIn("L");
        editor.typeIn("L");
        editor.typeIn("O");
        String ans = editor.toString(); // HELLO|
        System.out.println(ans);

        editor.moveCursor("left");
        ans = editor.toString();
        System.out.println(ans);    // HELL|O
        editor.backspace();         // HEL|O
        editor.moveCursor("right");
        editor.moveCursor("right");
        ans = editor.toString();
        System.out.println(ans);        // HELO|

        editor.moveCursor("up");


        editor.moveCursor("right");
        editor.backspace();         // HELO|
        ans = editor.toString();
        System.out.println(ans);

        editor.moveCursor("left");
        editor.moveCursor("left");
        editor.moveCursor("left");
        editor.moveCursor("left");
        editor.backspace();         
        ans = editor.toString();
        System.out.println(ans);    // |HEL
        editor.moveCursor("right");
        ans = editor.toString();
        System.out.println(ans);    // H|EL

        editor.newline();
        ans = editor.toString();
        System.out.println(ans); 
        ans = editor.lastLineToString();
        System.out.println(ans); 

        editor.moveCursor("right");
        ans = editor.lastLineToString();
        System.out.println(ans); 
    }
}
