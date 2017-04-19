public class Sorter {
	
	/** Method to sort the array of employees by their name alphabetically using bubble sort
	 * @param Employee[] workers
	 */
	public static void sort(Employee[] workers) {
		// Create an Employee variable to share as a temporary holder
		Employee temporary;

		// For loop to run through all of the employees
		for(int i = 0; i < workers.length - 1; i++){
			// For loop to compare 2 employees at a time
			for(int j = 1; j < (i - 1); j++){
				
				// If the first worker's name is more lexicographically (ignoring case) then switch the slots of the two workers
				if(workers[j-1].getName().compareToIgnoreCase(workers[j].getName()) > 0){
					
					// Store the first worker in temporary
					temporary = workers[j-1];
					
					// Move the second worker to the first worker slot
					workers[j-1] = workers[j];
					
					// Place the first worker in the second worker's slot
					workers[j] = temporary;
				}
			}
		}
	}	
}