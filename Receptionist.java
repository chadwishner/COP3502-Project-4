public class Receptionist extends Employee {

	private AssistantRegionalManager supervisor;
	private int maxTaskComplexityLevel;

	public Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor,
			int maxTaskComplexityLevel) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.supervisor = supervisor;
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}

	public AssistantRegionalManager getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(AssistantRegionalManager supervisor) {
		this.supervisor = supervisor;
	}

	public int getMaxTaskComplexityLevel() {
		return maxTaskComplexityLevel;
	}

	public void setmaxTaskComplexityLevel(int maxTaskComplexityLevel) {
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}

	public String toString() {
		String format = "Receptionist\nName: " + super.getName() + "\nID: " + super.getIDNumber() + "\nTask List:";

		for (int i = 0; i < super.getTaskList().length; i++) {
			format += super.getTaskList()[i].toString();
		}

		format += "\nAssistant Regional Manager: " + supervisor + "\nMax Task Level: " + maxTaskComplexityLevel;

		return format;
	}

	// equals method. Do not edit!
	public boolean equals(Receptionist r) {
		boolean equal = super.equals(r);
		equal = equal && (r.getSupervisor().equals(supervisor));
		equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
		return equal;
	}
}