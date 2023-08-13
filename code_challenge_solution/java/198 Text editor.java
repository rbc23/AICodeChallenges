```
public class TextEditor {
    private String text;

    public TextEditor() {
        this.text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void insert(String insertText, int position) {
        if (position < 0 || position > this.text.length()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        this.text = this.text.substring(0, position) + insertText + this.text.substring(position);
    }

    public void delete(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= this.text.length() || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }

        this.text = this.text.substring(0, startIndex) + this.text.substring(endIndex + 1);
    }

    public void replace(String replaceText, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= this.text.length() || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }

        this.text = this.text.substring(0, startIndex) + replaceText + this.text.substring(endIndex + 1);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.setText("Hello, World!");

        System.out.println("Original Text: " + textEditor.getText());

        textEditor.insert("Java ", 7);
        System.out.println("After Insertion: " + textEditor.getText());

        textEditor.delete(7, 11);
        System.out.println("After Deletion: " + textEditor.getText());

        textEditor.replace("JavaScript", 7, 13);
        System.out.println("After Replacement: " + textEditor.getText());
    }
}
```