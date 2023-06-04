package Company.Square.OOP.TextEditor;

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



public class _Design_Text_Editor {


   static class Node {
        private Character value;
        private Node next;
        private Node previous;
        
        private Node(Character value){
            this.value = value;
        }

        private Node (Character value, Node pre, Node next){
            this.value = value;
            this.previous = pre;
            this.next = next;
        }
    }


    private Node head = new Node(null);
    private Node tail = new Node(null);
    private Node cursor = new Node('|');

    public _Design_Text_Editor(){
        this.head.next = this.cursor;
        this.cursor.previous = this.head;
        this.tail.previous = this.cursor;
        this.cursor.next = this.tail;
    }

    public void typeIn(String word){
        char[] cs = word.toCharArray();
        for (Character c : cs){
            Node newNode = new Node(c, this.cursor.previous, this.cursor);
            this.cursor.previous.next = newNode;
            this.cursor.previous = newNode;
        }
    }

    public int backspace(int k){
        int deleted = 0;
        Node current = this.cursor.previous;

        while(deleted < k && current.previous != null && current.value != null) {
            current = current.previous;
            deleted++;
        }

        current.next = this.cursor;
        this.cursor.previous = current;

        return deleted;
    }

    public void backspace(){
        Node current = this.cursor.previous;
        if (current == null || current.value == null) {
            return;
        }

        current = current.previous; 
        current.next = this.cursor;
        this.cursor.previous = current;
    }

    // HELL|O   -> HELL  |O
    public void newLine(){
        Node current = this.cursor.previous;
        if (current == null || current.value == null) {
            
            return;
        }

        current = current.previous; 
        current.next = this.cursor;
        this.cursor.previous = current;
    }


    // HE|LL
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
                break;
        }

    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        Node current = this.head.next;
        while(current != null && current.value != null) {
           text.append(current.value);
           current = current.next;
        }

        return text.toString();
    }




    public static void main(String[] args) {
        _Design_Text_Editor editor = new _Design_Text_Editor();
        editor.typeIn("H");
        editor.typeIn("E");
        editor.typeIn("L");
        editor.typeIn("L");
        String ans = editor.toString();
        System.out.println(ans);
        editor.moveCursor("left");
        editor.moveCursor("left");
        editor.moveCursor("right");
        editor.backspace();
        editor.backspace();
        editor.backspace();
        editor.backspace();
        editor.backspace();
        editor.backspace();
        editor.moveCursor("right");
        editor.moveCursor("right");
        ans = editor.toString();
        System.out.println(ans);
    }
}