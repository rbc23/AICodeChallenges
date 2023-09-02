import tkinter as tk
from tkinter import filedialog
from PIL import ImageTk, Image

root = tk.Tk()
root.title("Image Viewer")
root.geometry("500x500")

def open_image():
    file_path = filedialog.askopenfilename(filetypes=[("Image files", "*.jpg *.png")])
    if file_path:
        image = Image.open(file_path)
        image = image.resize((400, 400), Image.ANTIALIAS)
        image_tk = ImageTk.PhotoImage(image)
        image_label.configure(image=image_tk)
        image_label.image = image_tk

open_button = tk.Button(root, text="Open Image", command=open_image)
open_button.pack()

image_label = tk.Label(root)
image_label.pack()

root.mainloop()