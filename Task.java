public class Task {

	private String name;
	private int level;

	public Task(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public String toString() {
		String format = "Task: " + name + "\tLevel: " + level;

		return format;
	}

	// equals method. Do not edit!
	public boolean equals(Task t) {
		return ((t.getLevel() == level) && (t.getName().equals(name)));
	}
}