public class RegionalManager extends Employee {

	// Create private variables that will be used for the Regional Manager type
	private int RegionNum;
	private Employee[] subordinates;
	private int minimumTask;

	/** Constructor for ReginalManager type when the manager has subordinates
	 * @param int IDNumber
	 * @param String name
	 * @param Task[] taskList
	 * @param int RegionNum
	 * @param Employee[] subordinates
	 * @param int minimumTask
	 */
	public RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, Employee[] subordinates, int minimumTask) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.RegionNum = RegionNum;
		this.subordinates = subordinates;
		this.minimumTask = minimumTask;
	}

	/** Constructor for ReginalManager type when the manager does not have subordinates
	 * @param int IDNumber
	 * @param String name
	 * @param Task[] taskList
	 * @param int RegionNum
	 * @param int minimumTask
	 */
	public RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, int minimumTask) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.RegionNum = RegionNum;
		this.minimumTask = minimumTask;
	}

	/** Getter for regional number
	 * @return int RegionNum
	 */
	public int getRegionNum() {
		return RegionNum;
	}

	/** Setter for regional number
	 * @param int RegionNum
	 */
	public void setRegionNum(int RegionNum) {
		this.RegionNum = RegionNum;
	}

	/** Getter for array of subordinates
	 * @return Employee[] subordinates
	 */
	public Employee[] getSubordinates() {
		return subordinates;
	}

	/** Setter for array of subordinates
	 * @param Employee[] subordinates
	 */
	public void setSubordinates(Employee[] subordinates) {
		this.subordinates = subordinates;
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
		String format = "Regional Manager\nName: " + super.getName() + "\nID: " + super.getIDNumber() + "\nTask List:";

		for (int i = 0; i < super.getTaskList().length; i++) {
			format += "\n" + super.getTaskList()[i].toString();
		}

		format += "\nRegion Number: " + RegionNum + "\nMinimum Task Level: " + minimumTask + "\nEmployees:\n";

		for (int i = 0; i < subordinates.length; i++) {
			format += subordinates[i].toString() + "\n";
		}

		return format;
	}

	/** Equals Method
	 * @param RegionalManager r
	 * @return boolean equals
	 */
	public boolean equals(RegionalManager r) {
		boolean equal = super.equals(r);
		equal = equal && (r.getRegionNum() == RegionNum);
		equal = equal && (r.getMinimumTask() == minimumTask);
		for (int i = 0; i < subordinates.length; i++) {
			equal = equal && (subordinates[i].equals(r.getSubordinates()[i]));
		}
		return equal;
	}
}