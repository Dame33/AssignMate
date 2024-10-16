package taskManager;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppManager {

	private static final SimpleDateFormat properDate = new SimpleDateFormat("yyyy-MM-dd"); //import java simpledateformat so that we can make it so any date input has to follow this expectation 
	
	public static void main(String[] args) throws ParseException {
		Manager newManager = new Manager();
		Scanner scanner = new Scanner(System.in);
		
		boolean exit = false;
		
		while (exit != true) {
			System.out.println("Welcome To the Assignment Manager System");
			System.out.println("Please Choose one of the follow \n1. Add Task \n2. Edit Task \n3. Remove Task \n4. View all Tasks \n5. Quit Application");
			System.out.print("Choose an Action: ");
			
			int pick = scanner.nextInt();
			scanner.nextLine();
			
			switch(pick) {
				case 1:
					addTask(newManager, scanner);
					break;
				
				case 2:
					editTask(newManager, scanner);
					break;
					
				case 3:
					deleteTask(newManager, scanner);
					break;
					
				case 4:
					viewTasks(newManager);
					break;
					
				case 5:
					exit = true;
					System.out.println("Exiting Application");
					break;
					
				default:
					System.out.println("Invalid Option");
					break;
			}
			
		}
		scanner.close();
	}
	
	private static Date parseDate(String dateString) throws ParseException {
		try {
			return properDate.parse(dateString);
		}
		catch (ParseException e){
			 System.out.println("Date Format is Invalid, Please use yyyy-MM-dd");
			 return null;
		}
	}

	
	private static void addTask(Manager newManager, Scanner scanner) throws ParseException {
		System.out.println("Enter Assignment Name: ");
		String title = scanner.nextLine();
		
		System.out.println("Enter Assignment Description: ");
		String description = scanner.nextLine();
		
		System.out.println("Enter the due Date (yyyy-MM-dd):");
		Date dueDate = parseDate(scanner.nextLine());
		
		if (dueDate == null) {
            System.out.println("Invalid date, task not updated.");
            return;
        }

		
		System.out.println("Enter the Priority (High, Medium, Low): ");
		String priority = scanner.nextLine();
		
		System.out.println("Enter the Class Code: ");
		String classCode = scanner.nextLine();
		
		System.out.println("Is the assignment complete (True/False): ");
		boolean isFinished = scanner.nextBoolean();
		
		newManager.addTask(title, description, dueDate, priority, classCode, isFinished);
		
		System.out.println("Task has been added successfully");
		
	}
	
	private static void editTask(Manager newManager, Scanner scanner) throws ParseException {
        System.out.println("Enter the Assignment ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter new Assignment Name: ");
        String title = scanner.nextLine();

        System.out.println("Enter new Assignment Description: ");
        String description = scanner.nextLine();

        System.out.println("Enter the new due Date (yyyy-MM-dd): ");
        Date dueDate = parseDate(scanner.nextLine());
        
        if (dueDate == null) {
            System.out.println("Invalid date, task not updated.");
            return;
        }

        System.out.println("Enter the new Priority (High, Medium, Low): ");
        String priority = scanner.nextLine();

        System.out.println("Enter the new Class Code: ");
        String classCode = scanner.nextLine();

        System.out.println("Is the assignment complete (True/False): ");
        boolean isFinished = scanner.nextBoolean();
        
        newManager.editTask(id, title, description, dueDate, priority, classCode, isFinished);
        System.out.println("Task has been updated successfully");
	}
	
	private static void deleteTask(Manager newManager, Scanner scanner) {
		System.out.println("Enter the Assignment ID that you want to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		newManager.deleteTask(id);
		System.out.println("Assignment has been Deleted");
			 
		} 
	
	
	private static void viewTasks(Manager newManager) {
		List<Task> tasks = newManager.listTasks();
		
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } 
        
        else {
        	
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
		
	}
		
}
