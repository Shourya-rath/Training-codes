from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

tasks = []

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/tasks', methods=['GET', 'POST', 'DELETE'])
def manage_tasks():
    global tasks
    if request.method == 'POST':
        task = request.json
        task['id'] = len(tasks) + 1
        tasks.append(task)
        return jsonify(task), 201

    elif request.method == 'DELETE':
        task_ids = request.json.get('ids', [])
        tasks = [task for task in tasks if task['id'] not in task_ids]
        return '', 204

    return jsonify(tasks)

if __name__ == '__main__':
    app.run(debug=True)
