
public abstract class Employee {

	private int IDNumber;
	private String name;
	private Task[] taskList;


	public Employee() {
	}

	public Employee(int IDNumber, String name, Task[] taskList) {
		this.IDNumber = IDNumber;
		this.name = name;
		this.taskList = taskList;
	}

	public int getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(int IDNumber) {
		this.IDNumber = IDNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task[] getTaskList() {
		return taskList;
	}

	public void setTaskList(Task[] taskList) {
		this.taskList = taskList;
	}

	public String toString() {
		String format = "Name: " + name + "\nID: " + IDNumber + "\nTask List:";

		for (int i = 0; i < taskList.length; i++) {
			format += "\n" + taskList[i].toString();
		}

		return format;
	}

	// equals method. Do not edit!
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