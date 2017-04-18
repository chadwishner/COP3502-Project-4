public class AssistantRegionalManager extends Employee {

	private RegionalManager manager;
	private int minimumTask;

	public AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager, int minimumTask) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.manager = manager;
		this.minimumTask = minimumTask;
	}

	public RegionalManager getManager() {
		return manager;
	}

	public void setManager(RegionalManager manager) {
		this.manager = manager;
	}

	public int getMinimumTask() {
		return minimumTask;
	}

	public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}

	public String toString() {
		String format = "Assitant Regional Manager\nName: " + super.getName() + "\nID: " + super.getIDNumber()
				+ "\nTask List:";

		for (int i = 0; i < super.getTaskList().length; i++) {
			format += "\n" + super.getTaskList()[i].toString();
		}

		format += "\nMinimum Task Level: " + minimumTask;

		return format;
	}

	// equals method. Do not edit!
	public boolean equals(AssistantRegionalManager r) {
		boolean equal = super.equals(r);
		equal = equal && (r.getMinimumTask() == minimumTask);
		equal = equal && (r.getManager().equals(manager));
		return equal;
	}
}