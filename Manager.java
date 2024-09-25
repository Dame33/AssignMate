package taskManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Iterator;

public class Manager {
	private List<Task> tasks;
	private int beginId;
	
	public Manager() {
		tasks = new ArrayList<>();
		beginId = 1;
	}
	
	public void addTask(String title, String description, Date dueDate, String priority, String classCode, Boolean isFinished) {
		Task newTask = new Task(beginId++, title, description, dueDate, priority, classCode, isFinished);
		tasks.add(newTask);

	}
	
	public void editTask (int id, String title, String description, Date dueDate, String priority, String classCode, Boolean isFinished) {
		Task task = taskId(id);
		
		if (task != null) {
			task.setTask(title);
			task.setDesc(description);
			task.setdueDate(dueDate);
			task.setCode(classCode);
			task.setIsFinished(isFinished);
			
		}
	}
	
	public Task taskId(int id) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				return task;
			}
			
		}
		return null;
	}
	
	
	public void deleteTask (int id) {
		Iterator<Task> iterate = tasks.iterator();
		
		while(iterate.hasNext()) {
			Task task = iterate.next();
			
			if (task.getId() == id) {
				iterate.remove();
				return;
			}
			
		}
		
		
	}
	
	public List<Task> listTasks() {
		return tasks;
	}

}
