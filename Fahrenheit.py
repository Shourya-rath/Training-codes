import tkinter as tk from tkinter import messagebox

def fahrenheit_to_celsius():

{x}

fahrenheit entry.get()

if fahrenheit.replace('.,", 1).isdigit() or (fahrenheit.s fahrenheit = float(fahrenheit) celsius (fahrenheit 32) 5/9

messagebox.showinfo("Result", f"{fahrenheit) Fahrenheit

else:

messagebox.showerror("Invalid input", "Please enter a val root = tk. Tk()

root.title("Fahrenheit to Celsius Converter")

label tk.Label(root, text="Enter temperature in Fahrenheit:")

label.pack(pady=10)

entry tk. Entry (root)

entry.pack(pady=5)
button = tk.Button(root, text="Convent", command=fahrenheit_to_celsi

button.pack(pady-10)

root.mainloop()