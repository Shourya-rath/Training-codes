from flask import Flask, render_template, request, redirect, url_for
import csv
import os

app = Flask(__name__)

# Function to read and return data from CSV
def read_csv():
    todo_list = []
    if os.path.isfile('eventj.csv'):
        with open('eventj.csv', 'r') as file:
            reader = csv.reader(file)
            next(reader)  # Skip header
            for row in reader:
                todo_list.append({'task': row[0], 'date': row[1]})
    return todo_list

# Function to write data to CSV
def write_csv(todo_list):
    with open('eventj.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['event or task', 'date'])
        for item in todo_list:
            writer.writerow([item['task'], item['date']])

@app.route('/')
def index():
    todo_list = read_csv()
    return render_template('index.html', todo_list=todo_list)

@app.route('/add', methods=['POST'])
def add():
    task = request.form['task']
    date = request.form['date']
    todo_list = read_csv()
    todo_list.append({'task': task, 'date': date})
    write_csv(todo_list)
    return redirect(url_for('index'))

@app.route('/delete/<int:index>')
def delete(index):
    todo_list = read_csv()
    todo_list.pop(index)
    write_csv(todo_list)
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
