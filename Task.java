public class Task {

	// Create private variables that will be used for the Task type
	private String name;
	private int level;

	/** Constructor for Task
	 * @param String name
	 * @param int level
	 */
	public Task(String name, int level) {
		this.name = name;
		this.level = level;
	}

	/** Getter for name
	 * @return String name
	 */	
	public String getName() {
		return name;
	}

	/** Getter for level
	 * @return int level
	 */	
	public int getLevel() {
		return level;
	}

	/** toString method to format information to be printed out
	 * @return String format
	 */
	public String toString() {
		String format = "\tTask: " + name + "\tLevel: " + level;

		return format;
	}

	/** Equals Method
	 * @param AssistantRegionalManager r
	 * @return boolean equals
	 */
	public boolean equals(Task t) {
		return ((t.getLevel() == level) && (t.getName().equals(name)));
	}
}