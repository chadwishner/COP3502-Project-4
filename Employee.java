
public abstract class Employee {	
	
	private int IDNumber;
	private String name;
	private Task[] taskList;
	
	Employee(int IDNumber, String name, Task[] taskList){
		this.IDNumber = IDNumber;
		this.name = name;
		this.taskList = taskList;
	}
	
	public static int getIDNumber(){
		return IDNumber;
	}
	
	public static void setIDNumber(int IDNumber){
		this.IDNumber = IDNumber;
	}
	
	public static String getName(){
		return name;
	}
	
	public static void setName(){
		this.name = name;
	}
	
	public static Task[] getTaskList(){
		return taskList;	
	}
	
	public static void setTaskList(){
		this.taskList = taskList;
	}
	
	public static String toString(){
		String format = "Name: " + name + "\nID: " + IDNumber + "\nTask List:";
		
		for(int i = 0; i < taskList.length; i++){
			format = format + "\n\tTask: " + taskList[i].getName + "\tLevel: " + taskList[i].getLevel;
		}
		
		return format;
	}
	
	//equals method. Do not edit!
	public boolean equals(Employee e){
		boolean equal = true;
		equal = equal && (e.getIDNumber() == IDNumber);
		equal = equal && (e.getName().equals(name));
		for(int i = 0; i < taskList.length; i++){
			equal = equal && (taskList[i].equals(e.getTaskList()[i]));
		}
		return equal;
	}
}