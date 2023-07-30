import tkinter as tk
from tkinter import filedialog

class TextEditor:
    def __init__(self, root):
        self.root = root
        self.root.title("Text Editor")
        self.textarea = tk.Text(self.root, undo=True)
        self.textarea.pack(fill=tk.BOTH, expand=1)

        self.menubar = tk.Menu(self.root)
        self.filemenu = tk.Menu(self.menubar, tearoff=0)
        self.filemenu.add_command(label="Open", command=self.open_file)
        self.filemenu.add_command(label="Save", command=self.save_file)
        self.filemenu.add_separator()
        self.filemenu.add_command(label="Exit", command=root.quit)
        self.menubar.add_cascade(label="File", menu=self.filemenu)

        self.editmenu = tk.Menu(self.menubar, tearoff=0)
        self.editmenu.add_command(label="Cut", command=self.cut_text)
        self.editmenu.add_command(label="Copy", command=self.copy_text)
        self.editmenu.add_command(label="Paste", command=self.paste_text)
        self.editmenu.add_separator()
        self.editmenu.add_command(label="Undo", command=self.textarea.edit_undo)
        self.editmenu.add_command(label="Redo", command=self.textarea.edit_redo)
        self.menubar.add_cascade(label="Edit", menu=self.editmenu)

        self.root.config(menu=self.menubar)

    def open_file(self):
        file = filedialog.askopenfilename(defaultextension=".txt", filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")])
        if file:
            self.textarea.delete("1.0", tk.END)
            with open(file, "r") as f:
                self.textarea.insert(tk.END, f.read())

    def save_file(self):
        file = filedialog.asksaveasfilename(defaultextension=".txt", filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")])
        if file:
            with open(file, "w") as f:
                f.write(self.textarea.get(1.0, tk.END))

    def cut_text(self):
        self.textarea.event_generate("<<Cut>>")

    def copy_text(self):
        self.textarea.event_generate("<<Copy>>")

    def paste_text(self):
        self.textarea.event_generate("<<Paste>>")

root = tk.Tk()
text_editor = TextEditor(root)
root.mainloop()
