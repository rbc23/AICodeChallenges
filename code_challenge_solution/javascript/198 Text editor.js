```javascript
// Create a text editor class
class TextEditor {
  constructor() {
    this.text = '';
  }

  // Set the text
  setText(text) {
    this.text = text;
  }

  // Get the text
  getText() {
    return this.text;
  }

  // Append text to the existing text
  appendText(text) {
    this.text += text;
  }

  // Clear the text
  clearText() {
    this.text = '';
  }
}

// Create an instance of the text editor class
const editor = new TextEditor();

// Set the text
editor.setText('Hello');

// Append text
editor.appendText(', World!');

// Get the text
const text = editor.getText();
console.log(text);

// Clear the text
editor.clearText();

// Get the cleared text
const clearedText = editor.getText();
console.log(clearedText);
```