package Company.Coinbase;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TextEditorManager {
    public String sharedClipBoard;
    Map<String, TextEditor> textEditorMap;
    Stack<TextEditor> activeTextEditorStack;
    public TextEditorManager() {
        this.sharedClipBoard = "";
        this.textEditorMap = new HashMap<>();
        this.activeTextEditorStack = new Stack<>();
    }
    
    public void create(String name) {
        // Empty file name?
        TextEditor textEditor = textEditorMap.getOrDefault(name, new TextEditor(this));
        textEditorMap.putIfAbsent(name, textEditor);
        activeTextEditorStack.push(textEditor);
        System.out.println("");
     }

     public TextEditor switchEditor(String name) {
        // Empty file name?
        

        if (textEditorMap.containsKey(name)) {
            TextEditor textEditor = textEditorMap.get(name);
            System.out.println(textEditor.content.toString());
            return textEditor;
        } else {
            System.out.println("");

            return null;
        }
     } 
    
    public void close() {
        TextEditor textEditor = activeTextEditorStack.pop();
        textEditor.close();
     }
     
     public TextEditor getCurrentActiveTextEditor() {
        return activeTextEditorStack.peek();
    }
}

public class TextEditor {
    class State {
        int cursor;
        int selectedLength;
        String content;

        public State(int cursor, int selectedLength, String content){
            this.cursor = cursor;
            this.selectedLength = selectedLength;
            this.content = content;
        }
    }



    private TextEditorManager textEditorManager;
    // Stores the content of the text editor
    public StringBuilder content;

    private int cursor;
    private int selectedLength;

    private Stack<State> previousStateStack;
    private Stack<State> undoStack;
    
    public TextEditor(TextEditorManager textEditorManager) {
        // Empty content when the editor is opened.
        this.content = new StringBuilder();
        this.cursor = 0;
        this.selectedLength = 0;
        previousStateStack = new Stack<>();
        undoStack = new Stack<>();
        this.textEditorManager = textEditorManager;       
    }

    public String append(String input) {
        if (input == "") {
            return content.toString();
        }
        saveCurrentState();
        clearUndoStack();
        int start = cursor - selectedLength;
        content.replace(start, cursor, input);
        cursor = start + input.length();
        selectedLength = 0;
        System.out.println(content.toString());

        return content.toString();
    }     

    public String delete() {
        saveCurrentState();
        clearUndoStack();
        int start = cursor - selectedLength;
        if (content.length() == 0 || start == 0) {
            return content.toString();
        }
        if (start == cursor) {
            content.deleteCharAt(start - 1);
        } else {
            content.delete(start, cursor);
        }

        cursor = start - 1;
        selectedLength = 0;
        
        System.out.println(content.toString());
        return content.toString();
    }

    public void move(int position) {
        // Single cursor move clears the selected length.
        selectedLength = 0;
        if (position <= 0) {
            cursor = 0;
            return;
         }

        if (cursor > content.length()) {
              cursor = content.length();
              return;
        }
        cursor = position;
        System.out.println(content.toString());
    }


    public String select(int selectPointer1, int selectPointer2) {
        int lowerBound = Math.min(selectPointer1, selectPointer2);
        int upperBound = Math.max(selectPointer1, selectPointer2);
        lowerBound = Math.max(0, lowerBound);
        upperBound = Math.min(content.length(), upperBound);
            // Set cursor to the upper bound.
        cursor = upperBound;
        selectedLength = upperBound - lowerBound;
        System.out.println(content.toString());
        return content.toString();
        // return content.substring(lowerBound, upperBound);
    }

    public String copy() {
        textEditorManager.sharedClipBoard = content.substring(cursor - selectedLength, cursor);
        System.out.println(textEditorManager.sharedClipBoard);
        return textEditorManager.sharedClipBoard;
    }
    
    public String paste() {
        return append(textEditorManager.sharedClipBoard);
    }

    public String undo() {
        // Push the current state to the undo stack.
        State currentState = new State(cursor, selectedLength, content.toString());
        undoStack.push(currentState);
        if (!previousStateStack.isEmpty()) {
            State previousState = previousStateStack.pop();
            content = new StringBuilder(previousState.content);
            cursor = previousState.cursor;
            selectedLength = previousState.selectedLength;
        } else {
         // Set to initial state.
            content = new StringBuilder();
            cursor = 0;
            selectedLength = 0;
         }

         System.out.println(content.toString());
         return content.toString();
    }
        

    public String redo() {
         if (undoStack.isEmpty()) {
            throw new RuntimeException("Cannot Redo!");
         }
         // Push current state to previous state
         previousStateStack.push(new State(cursor, selectedLength, content.toString()));
         State beforeUndo = undoStack.pop();
         content = new StringBuilder(beforeUndo.content);
         cursor = beforeUndo.cursor;
         selectedLength = beforeUndo.selectedLength;
         System.out.println(content.toString());

         return content.toString();
    }

    public void close() {
        selectedLength = 0;
        cursor = content.length();
        previousStateStack.clear();
        undoStack.clear();
    }

    private void saveCurrentState() {
        previousStateStack.push(new State(cursor, selectedLength, content.toString()));
    }

    private void clearUndoStack() {
        undoStack.clear();
    }  
    
    public static void main(String[] args){
        TextEditorManager ma  = new TextEditorManager();
        TextEditor textEditor = new TextEditor(ma);

        // textEditor.append("Hey you");
        // textEditor.move(3);
        // textEditor.append(",");

        // textEditor.append("Hey you");
        // textEditor.delete();
        // textEditor.delete();


        // textEditor.append("!");
        // textEditor.delete();
        // textEditor.delete();
    
        // textEditor.append("Hello cruel world!");
        // textEditor.select(5, 11);
        // textEditor.append(",");

        // textEditor.append("Hello");
        // textEditor.select(2, 5);
        // textEditor.append("y there");

        // textEditor.append("Hello, world!");
        // textEditor.select(5, 12);
        // textEditor.copy();
        // textEditor.move(12);
        // textEditor.paste();
        // textEditor.paste();

        // textEditor.append("Hello, world!");
        // textEditor.select(7, 13);
        // textEditor.delete();
        // textEditor.undo();
        // textEditor.append("you");

        // textEditor.append("Hello, world!");
        // textEditor.select(7, 12);
        // textEditor.delete();
        // textEditor.move(6);
        // textEditor.undo();
        // textEditor.undo();
        // textEditor.redo();
        // textEditor.redo();

        ma.create("document1");
        ma.create("document2");
        ma.create("document1");
        textEditor =  ma.switchEditor("document1");
        textEditor.append("Hello, world!");
        textEditor.select(7, 12);
        textEditor.copy();

        textEditor =  ma.switchEditor("document2");
        textEditor.paste();
        textEditor =  ma.switchEditor("document1");
        textEditor.delete();
    }
          
}
    
