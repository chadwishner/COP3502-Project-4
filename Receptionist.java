public class Receptionist extends Employee {

	// Create private variables that will be used for the Receptionist type
	private AssistantRegionalManager supervisor;
	private int maxTaskComplexityLevel;

	/** Constructor for Receptionist type
	 * @param int IDNumber
	 * @param String name
	 * @param Task[] taskList
	 * @param AssistantRegionalManager supervisor
	 * @param int maxTaskComplexityLevel
	 */
	public Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor, int maxTaskComplexityLevel) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.supervisor = supervisor;
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}

	/** Getter for the supervisor
	 * @return AssistantRegionalManager supervisor
	 */
	public AssistantRegionalManager getSupervisor() {
		return supervisor;
	}

	/** Setter for supervisor
	 * @param AssistantRegionalManager supervisor
	 */
	public void setSupervisor(AssistantRegionalManager supervisor) {
		this.supervisor = supervisor;
	}

	/** Getter for maximum task complexity level
	 * @return int maxTaskComplexityLevel
	 */
	public int getMaxTaskComplexityLevel() {
		return maxTaskComplexityLevel;
	}

	/** Setter for maximum task complexity level
	 * @param int maxTaskComplexityLevel
	 */
	public void setmaxTaskComplexityLevel(int maxTaskComplexityLevel) {
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}

	/** toString method to format information to be printed out
	 * @return String format
	 */
	public String toString() {
		String format = "Receptionist\nName: " + super.getName() + "\nID: " + super.getIDNumber() + "\nTask List:";

		for (int i = 0; i < super.getTaskList().length; i++) {
			format += super.getTaskList()[i].toString();
		}

		format += "\nAssistant Regional Manager: " + supervisor + "\nMax Task Level: " + maxTaskComplexityLevel;

		return format;
	}

	/** Equals Method
	 * @param Receptionist r
	 * @return boolean equals
	 */
	public boolean equals(Receptionist r) {
		boolean equal = super.equals(r);
		equal = equal && (r.getSupervisor().equals(supervisor));
		equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
		return equal;
	}
}