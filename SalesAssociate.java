public class SalesAssociate extends Employee {

	// Create private variables that will be used for the Sales Associate type
	private int numClients;
	private String[] products;
	private RegionalManager supervisor;

	/** Constructor for Sales Associate
	 * @param int IDNumber
	 * @param String name
	 * @param Task[] taskList
	 * @param int numClients
	 * @param String[] products
	 * @param RegionalManager supervisor
	 */
	public SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.numClients = numClients;
		this.products = products;
		this.supervisor = supervisor;
	}

	/** Getter for number of clients
	 * @return int numClients
	 */
	public int getNumClients() {
		return numClients;
	}

	/** Setter for number of clients
	 * @param int numClients
	 */
	public void setNumClients(int numClients) {
		this.numClients = numClients;
	}

	/** Getter for list of products
	 * @return String[] products
	 */
	public String[] getProducts() {
		return products;
	}

	/** Setter for list of products
	 * @param String[] products
	 */
	public void setProducts(String[] products) {
		this.products = products;
	}

	/** Getter for supervisor
	 * @return RegionalManager supervisor
	 */
	public RegionalManager getSupervisor() {
		return supervisor;
	}

	/** Setter for supervisor
	 * @param RegionalManager supervisor
	 */
	public void setSupervisor(RegionalManager supervisor) {
		this.supervisor = supervisor;
	}

	/** toString method to format information to be printed out
	 * @return String format
	 */
	public String toString() {
		String format = "Sales Associate\nName: " + super.getName() + "\nID: " + super.getIDNumber() + "\nTask List: ";

		for (int i = 0; i < super.getTaskList().length; i++) {
			format += "\n" + super.getTaskList()[i].toString();
		}

		format += "\nRegional Manager: " + supervisor.getName() + "\nNumber of clients: " + numClients + "\nProducts to sell: ";

		for (int i = 0; i < products.length; i++) {
			format += "\n\t" + products[i];
		}

		return format;
	}

	/** Equals Method
	 * @param AssistantRegionalManager r
	 * @return boolean equals
	 */
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