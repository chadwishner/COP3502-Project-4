import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TheOffice {
	
	// create an array of Emplyees
	private Employee[] workers;

	// Constructor
	TheOffice() {
	}

	TheOffice(String fileLoc) throws TaskLevelException {

		// This is used to read a file
		Scanner fs = null;
		File f = null;

		// Try Catch on file
		try {
			f = new File(fileLoc);
			fs = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: The file \"" + fileLoc + "\" could not be found.");
		}

		// First Line is number of employees
		int size = Integer.parseInt(fs.nextLine());

		// set the size of the array to the number of employees
		workers = new Employee[size];

		// Create variables to use later
		RegionalManager manager = null;
		int supremum = 0;
		AssistantRegionalManager assistantManager = null;
		int ATRM = 0;

		// Loops through file
		for (int i = 0; i < size; i++) {
			
			// Sets temp variables for all possible member variables
			int IDNumber = -1;
			String name = null;
			Task[] taskList = null;
			int RegionNum = -1;
			int minimumTask = -1;
			int numClients = -1;
			String[] products = null;
			int maxTaskComplexityLevel = -1;

			// Check which type of employee
			String type = fs.nextLine().trim();

			// Get Standard information (id, name)
			IDNumber = Integer.parseInt(fs.nextLine().trim());
			name = fs.nextLine();

			// Gets number of tasks and makes a task array based on the size
			int tasks = Integer.parseInt(fs.nextLine().trim());
			taskList = new Task[tasks];

			// Fills up Task List
			for (int j = 0; j < tasks; j++) {
				// Gets information for task
				String work = fs.nextLine();
				int num = Integer.parseInt(fs.nextLine().trim());

				// Sets task at array spot
				taskList[j] = new Task(work, num);
			}

			// Scanner read for Regional Manager
			if (type.equals("RegionalManager")) {
				
				// Gets Region Number and Minimum Task Level
				RegionNum = Integer.parseInt(fs.nextLine().trim());
				minimumTask = Integer.parseInt(fs.nextLine().trim());

				// Loop through the Task list
				for (int j = 0; j < taskList.length; j++) {
					
					// If a task is below the minimum task level, throw exception
					if (taskList[j].getLevel() < minimumTask) {
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}

				// Set manager to new regional manager
				manager = new RegionalManager(IDNumber, name, taskList, RegionNum, minimumTask);

				// Set workers[i] to regional manager
				workers[i] = manager;

				// Set supremum in order to make sure that the minimum task level for subordinates is not higher then their superior
				supremum = minimumTask;
			
				// Scanner read for Assistant Regional Manager
			} else if (type.equals("AssistantRegionalManager")) {
				
				// Gets the Minimum Task Level
				minimumTask = Integer.parseInt(fs.nextLine().trim());
				
				// Loop through the Task list
				for (int j = 0; j < taskList.length; j++) {
					// If a task is below the minimum task level, throw exception
					if (taskList[j].getLevel() < minimumTask || minimumTask > supremum) {
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}
				
				// If this is the first Assistant Manager, then make assistantManager the new Employee
				if (assistantManager == null){
					assistantManager = new AssistantRegionalManager( IDNumber,  name, taskList,  manager,  minimumTask);
					workers[i] = assistantManager;
				
				// Else make a new Employee and add the employee to the array of Employees
				} else {
					AssistantRegionalManager assMan = new AssistantRegionalManager( IDNumber,  name, taskList,  manager,  minimumTask);
					workers[i] = assMan;
				}
			
			// Scanner read for Sales Associate
			} else if (type.equals("SalesAssociate")) {
				
				// Gets number of clients and number of products
				numClients = Integer.parseInt(fs.nextLine().trim());
				int numProducts = Integer.parseInt(fs.nextLine().trim());
				
				// Loop through the Task list
				for (int j = 0; j < taskList.length; j++) {
					// If a task is below the minimum task level, thrown exception
					if (taskList[j].getLevel() < 1) {
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}
				
				// Set the String array of products to the size of the amount of products
				products = new String[numProducts];
				
				// Run through the products and add them to the String array of products
				for (int j = 0; j < numProducts; j++){
					products[j] = fs.nextLine().trim();
				}
				
				// Create the Sales Associate and add them to the array of employees
				SalesAssociate salAss = new SalesAssociate(IDNumber, name, taskList, numClients, products, manager);
				workers[i] = salAss;
				
			// Scanner read for Receptionist
			} else if (type.equals("Receptionist")) {
				
				// Get the Max Task Level
				maxTaskComplexityLevel = Integer.parseInt(fs.nextLine().trim());
				
				// Loop through the Task list
				for (int j = 0; j < taskList.length; j++) {
					
					// If a task is below the minimum task level, throw exception
					if (taskList[j].getLevel() < 1 || taskList[j].getLevel() > maxTaskComplexityLevel) {
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}
				
				// Create the new Receptionist and add them to the array of Employees
				Receptionist ass = new Receptionist(IDNumber, name, taskList,  assistantManager,  maxTaskComplexityLevel); 
				workers[i] = ass;
			}
		}

		// Set up Employee Arrays for regional manager
		Employee[] a = new Employee[size - 1];
		for (int i = 0, j = 0; i < workers.length; i++) {
			if (!(workers[i] instanceof RegionalManager)) {
				a[j++] = workers[i];
			}
		}

		// If there is a manager, set the subordinate array
		if (manager != null) {
			manager.setSubordinates(a);
		}
	}

	/** Getter Method for the array of Employees 
	 * @return Array of Employees
	 */
	public Employee[] getWorkers() {
		return workers;
	}

	/** Setter Method for the array of Employees 
	 * @param Array of Employees
	 */
	public void setWorkers(Employee[] workers) {
		this.workers = workers;
	}

	/** toString method 
	 * @return String with formatting
	 */
	public String toString() {
		
		// Create and initialize String
		String format = "";
		
		// Run through the list of Regional Managers and call their toString methods
		for(int i = 0; i < workers.length; i++){
			if(workers[i] instanceof RegionalManager){
				RegionalManager manager = (RegionalManager) workers[i];
				format += manager.toString() + "\n";
			}
		}
		
		// Trim whitespace
		format = format.substring(0, format.length() - 1);
		
		return format;
	}

	/** Method to create a formatted display of Employees with their Minimum Task
	 * @return String with formatting
	 */
	public String levelDisplay() {
		
		// Create and initialize a String display
		String display = "";

		// Run through the array of workers
		for (int i = 0; i < workers.length; i++) {
			
			// Set of if/else/else if statements in order to appropriately display the Employee's name and level
			if (workers[i] instanceof RegionalManager) {
				RegionalManager manager = (RegionalManager) workers[i];
				display += "Name: " + manager.getName() + "\tLevel: " + manager.getMinimumTask() + "\n";
			} else if (workers[i] instanceof AssistantRegionalManager) {
				AssistantRegionalManager manager = (AssistantRegionalManager) workers[i];
				display += "Name: " + manager.getName() + "\tLevel: " + manager.getMinimumTask() + "\n";
			} else {
				display += "Name: " + workers[i].getName() + "\tLevel: 1\n";
			}
		}
		
		// Trim whitespace
		display = display.trim();

		return display;
	}

	/** Main method opens .txt file and calls TheOffice method
	 *  Calls levelDisplay twice in order to print once in order of hierarchy and in order of name in alphabetical order
	 * @param args
	 * @throws TaskLevelException
	 */
	public static void main(String[] args) throws TaskLevelException{
		// Gets location for file
		TheOffice o = new TheOffice((args[0]+".txt"));
		
		// Prints office, then the current level display
		System.out.println(o + "\n\n\n" + o.levelDisplay());
		
		// Sorts(by name) the employee array
		Sorter.sort(o.getWorkers());
		
		// Prints the sorted(by name) level display
		System.out.println("\n\n\n" + o.levelDisplay());
	}
}