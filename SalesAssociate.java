public class SalesAssociate extends Employee {

	private int numClients;
	private String[] products;
	private RegionalManager supervisor;

	public SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.numClients = numClients;
		this.products = products;
		this.supervisor = supervisor;
	}

	public int getNumClients() {
		return numClients;
	}

	public void setNumClients(int numClients) {
		this.numClients = numClients;
	}

	public String[] getProducts() {
		return products;
	}

	public void setProducts(String[] products) {
		this.products = products;
	}

	public RegionalManager getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(RegionalManager supervisor) {
		this.supervisor = supervisor;
	}

	public String toString() {
		String format = "Sales Associate\nName: " + super.getName() + "\nID: " + super.getIDNumber() + "\nTask List:";

		for (int i = 0; i < super.getTaskList().length; i++) {
			format += "\n" + super.getTaskList()[i].toString();
		}

		format += "Regional Manager: " + supervisor.getName() + "\nNumber of clients:" + numClients + "\nProducts to sell:";

		for (int i = 0; i < products.length; i++) {
			format += "\n" + products[i];
		}

		return format;
	}

	// equals method. Do not edit!
	public boolean equals(SalesAssociate s) {
		boolean equal = super.equals(s);
		equal = equal && (s.getNumClients() == numClients);
		equal = equal && (s.getSupervisor().equals(supervisor));

		for (int i = 0; i < products.length; i++) {
			equal = equal && (products[i].equals(s.getProducts()[i]));
		}
		return equal;
	}

}