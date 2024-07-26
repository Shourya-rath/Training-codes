// scripts.js

document.addEventListener('DOMContentLoaded', () => {
    const taskForm = document.getElementById('taskForm');
    const subtaskForm = document.getElementById('subtaskForm');
    const taskTableBody = document.getElementById('taskTableBody');
    const deleteSelectedButton = document.getElementById('deleteSelected');
    const assignDateButton = document.getElementById('assignDate');
    const parentTaskSelect = document.getElementById('parentTask');

    let tasks = [];
    let taskIdCounter = 1;

    function renderTasks() {
        taskTableBody.innerHTML = '';
        parentTaskSelect.innerHTML = '<option value="">-- Select Task --</option>';

        tasks.forEach(task => {
            const taskRow = document.createElement('tr');
            taskRow.dataset.taskId = task.id;

            taskRow.innerHTML = `
                <td><input type="checkbox" class="task-checkbox"></td>
                <td>${task.title}</td>
                <td>${task.date || 'No due date'}</td>
                <td><button class="delete-task">Delete</button></td>
            `;

            taskTableBody.appendChild(taskRow);

            const option = document.createElement('option');
            option.value = task.id;
            option.textContent = task.title;
            parentTaskSelect.appendChild(option);
        });
    }

    function addTask(title, date) {
        tasks.push({
            id: taskIdCounter++,
            title,
            date,
            subtasks: []
        });
        renderTasks();
    }

    function deleteTask(id) {
        tasks = tasks.filter(task => task.id !== id);
        renderTasks();
    }

    function addSubtask(parentId, title) {
        const task = tasks.find(task => task.id === parseInt(parentId));
        if (task) {
            task.subtasks.push({ title });
            renderTasks();
        }
    }

    taskForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const title = e.target.taskTitle.value;
        const date = e.target.taskDate.value;
        addTask(title, date);
        e.target.reset();
    });

    subtaskForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const parentId = e.target.parentTask.value;
        const title = e.target.subtaskTitle.value;
        addSubtask(parentId, title);
        e.target.reset();
    });

    taskTableBody.addEventListener('click', (e) => {
        if (e.target.classList.contains('delete-task')) {
            const taskId = parseInt(e.target.closest('tr').dataset.taskId);
            deleteTask(taskId);
        }
    });

    deleteSelectedButton.addEventListener('click', () => {
        document.querySelectorAll('.task-checkbox:checked').forEach(checkbox => {
            const taskId = parseInt(checkbox.closest('tr').dataset.taskId);
            deleteTask(taskId);
        });
    });

    assignDateButton.addEventListener('click', () => {
        const newDate = prompt('Enter the new date (YYYY-MM-DD):');
        if (newDate) {
            document.querySelectorAll('.task-checkbox:checked').forEach(checkbox => {
                const taskId = parseInt(checkbox.closest('tr').dataset.taskId);
                const task = tasks.find(task => task.id === taskId);
                if (task) {
                    task.date = newDate;
                }
            });
            renderTasks();
        }
    });
});
