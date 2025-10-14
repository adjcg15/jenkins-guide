const API_URL = "http://localhost:8081/api/todos";

document.getElementById("addBtn").addEventListener("click", addTodo);
window.addEventListener("DOMContentLoaded", loadTodos);

async function loadTodos() {
  const res = await fetch(API_URL);
  const todos = await res.json();
  const list = document.getElementById("todoList");
  list.innerHTML = "";
  todos.forEach(todo => {
    const li = document.createElement("li");
    li.textContent = todo.title;
    const del = document.createElement("button");
    del.textContent = "×";
    del.onclick = () => deleteTodo(todo.id);
    li.appendChild(del);
    list.appendChild(li);
  });
}

async function addTodo() {
  const title = document.getElementById("newTodo").value.trim();
  if (!title) return;
  await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, completed: false })
  });
  document.getElementById("newTodo").value = "";
  loadTodos();
}

async function deleteTodo(id) {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
  loadTodos();
}
