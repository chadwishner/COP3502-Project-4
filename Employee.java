public abstract class Employee {

	// Create private variables that will be used for all Employee types
	private int IDNumber;
	private String name;
	private Task[] taskList;

	/** Default constructor
	 */
	public Employee() {
	}

	/** Employee constructor
	 * @param int IDNumber
	 * @param String name
	 * @param Task[] taskList
	 */
	public Employee(int IDNumber, String name, Task[] taskList) {
		
		// Set the parameters to the global variables
		this.IDNumber = IDNumber;
		this.name = name;
		this.taskList = taskList;
	}

	/** Getter method for IDNumber
	 * @return int IDNumber
	 */
	public int getIDNumber() {
		return IDNumber;
	}

	/** Setter for IDNumber
	 * @param int IDNumber
	 */
	public void setIDNumber(int IDNumber) {
		this.IDNumber = IDNumber;
	}

	/** Getter method for name
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/** Setter for name
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter method for array of tasks
	 * @return Task [] taskList
	 */
	public Task[] getTaskList() {
		return taskList;
	}

	/** Setter method for array of tasks
	 * @param Task [] taskList
	 */
	public void setTaskList(Task[] taskList) {
		this.taskList = taskList;
	}

	/** toString method to format information to be printed out
	 * @return String format
	 */
	public String toString() {
		String format = "Name: " + name + "\nID: " + IDNumber + "\nTask List:";

		for (int i = 0; i < taskList.length; i++) {
			format += "\n" + taskList[i].toString();
		}

		return format;
	}

	/** Equals Method
	 * @param Employee e
	 * @return boolean equals
	 */
	public boolean equals(Employee e) {
		boolean equal = true;
		equal = equal && (e.getIDNumber() == IDNumber);
		equal = equal && (e.getName().equals(name));
		for (int i = 0; i < taskList.length; i++) {
			equal = equal && (taskList[i].equals(e.getTaskList()[i]));
		}
		return equal;
	}
}