package taskManager;
import java.util.*;

public class Task {
	private int id;
    private String title;
    private String description;
    private Date dueDate;
    private String priority;
    private String classCode;
    private Boolean isFinished;
    
    
    public Task(int id, String title, String description, Date dueDate, String priority, String classCode, Boolean isFinished){
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.classCode = classCode;
        this.isFinished = isFinished;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTask(){
        return title;
    }

    public void setTask(String title){
        this.title = title;
    }

    public String getDesc(){
        return description;
    }

    public void setDesc(String description){
        this.description = description;
    }

    public Date getdueDate(){
        return dueDate;
    }

    public void setdueDate (Date dueDate){
        this.dueDate = dueDate;
    }

    public String getPriority(){
        return priority;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public String getCode(){
        return classCode;
    }

    public void setCode(String classCode){
        this.classCode = classCode;
    }

    public Boolean getIsFinished(){
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished){
        this.isFinished = isFinished;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Title: " + title + ", Description: " + description + 
               ", Due Date: " + dueDate + ", Priority: " + priority + 
               ", Class Code: " + classCode + ", Completed: " + isFinished;
    }
    
	
}


