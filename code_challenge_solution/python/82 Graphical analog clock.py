import tkinter as tk
import time

# Function to update the clock
def update_clock():
    current_time = time.strftime('%I:%M:%S %p')
    clock_label.config(text=current_time)
    clock_label.after(1000, update_clock)

# Function to create the clock face
def create_clock_face():
    clock_face.create_oval(50, 50, 250, 250, width=2)
  
    for i in range(1, 13):
        angle = i * 30
        x = 150 + 100 * (0.8 * (angle / 360) * (2 * 3.14))
        y = 150 - 100 * (0.8 * (angle / 360) * (2 * 3.14))
        clock_face.create_text(x, y, text=str(i), font=('Helvetica', 10, 'bold'))

# Function to create the hour hand
def create_hour_hand():
    angle = ((time.localtime().tm_hour % 12) * 30) - 90
    x = 150 + 50 * (0.6 * (angle / 360) * (2 * 3.14))
    y = 150 + 50 * (0.6 * ((angle+90) / 360) * (2 * 3.14))
    clock_face.create_line(150, 150, x, y, width=3, fill='black')

# Function to create the minute hand
def create_minute_hand():
    angle = (time.localtime().tm_min * 6) - 90
    x = 150 + 80 * (0.8 * (angle / 360) * (2 * 3.14))
    y = 150 + 80 * (0.8 * ((angle+90) / 360) * (2 * 3.14))
    clock_face.create_line(150, 150, x, y, width=2, fill='black')

# Function to create the second hand
def create_second_hand():
    angle = (time.localtime().tm_sec * 6) - 90
    x = 150 + 90 * (0.85 * (angle / 360) * (2 * 3.14))
    y = 150 + 90 * (0.85 * ((angle+90) / 360) * (2 * 3.14))
    clock_face.create_line(150, 150, x, y, width=1, fill='red')

# Create the main window
root = tk.Tk()
root.title("Analog Clock")

# Create the clock face canvas
clock_face = tk.Canvas(root, width=300, height=300)
clock_face.pack()

# Create the clock label
clock_label = tk.Label(root, font=('Helvetica', 20, 'bold'), fg='black')
clock_label.pack()

# Call the functions to create the clock components
create_clock_face()
create_hour_hand()
create_minute_hand()
create_second_hand()
update_clock()

# Start the main event loop
root.mainloop()