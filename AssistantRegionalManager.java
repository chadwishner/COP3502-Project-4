public class AssistantRegionalManager extends Employee {

	// Create private variables that will be used for the Assistant Regional Manager type
	private RegionalManager manager;
	private int minimumTask;

	/** Constructor for Assistant Regional Manager
	 * @param int IDNumber
	 * @param String name
	 * @param Task[] taskList
	 * @param RegionalManager manager
	 * @param int minimumTask
	 */
	public AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager, int minimumTask) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.manager = manager;
		this.minimumTask = minimumTask;
	}

	/** Getter for manager
	 * @return RegionalManager manager
	 */	
	public RegionalManager getManager() {
		return manager;
	}

	/** Setter for manager
	 * @param RegionalManager manager
	 */
	public void setManager(RegionalManager manager) {
		this.manager = manager;
	}

	/** Getter for minimum task level
	 * @return int minimumTask
	 */
	public int getMinimumTask() {
		return minimumTask;
	}

	/** Setter for minimum task level
	 * @param int minimumTask
	 */
	public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}

	/** toString method to format information to be printed out
	 * @return String format
	 */
	public String toString() {
		String format = "Assitant Regional Manager\nName: " + super.getName() + "\nID: " + super.getIDNumber() + "\nTask List:";

		for (int i = 0; i < super.getTaskList().length; i++) {
			format += "\n" + super.getTaskList()[i].toString();
		}

		format += "\nMinimum Task Level: " + minimumTask;

		return format;
	}

	/** Equals Method
	 * @param AssistantRegionalManager r
	 * @return boolean equals
	 */
	public boolean equals(AssistantRegionalManager r) {
		boolean equal = super.equals(r);
		equal = equal && (r.getMinimumTask() == minimumTask);
		equal = equal && (r.getManager().equals(manager));
		return equal;
	}
}