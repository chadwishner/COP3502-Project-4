//import java.util.Collections;

public class Sorter {
	public static void sort(Employee[] workers) {
	
		 Employee temporary;

	       for(int i = 0; i < workers.length-1; i++){
	            for(int j = 1; j < (i-1); j++){
	                if(workers[j-1].getName().compareToIgnoreCase(workers[j].getName()) > 0){
	                    temporary = workers[j-1];
	                    workers[j-1] = workers[j];
	                    workers[j] = temporary;
	                }
	            }
	       }
	   }
		
		
		
//		for (int i = 1; i < workers.length; i++){
//			for (int x = 0; x < workers[i].getName().length(); x++){
//				if ((int)workers[i-1].getName().charAt(x) != (int)workers[i].getName().charAt(x)){
//					if ((int)workers[i-1].getName().charAt(x) < (int)workers[i].getName().charAt(x)){
//						
//					}
//				}
//			}	
//		}
		
			
		
//		public int compareTo(workers[].getName, otherObject)		
//		Collections.sort(workers);

		
//		Employee[] workersSorted = new Employee[workers.length];
//		Employee first;
//		Employee second;
//		Employee nextAlphabetically;
//		int indexFirst = 0;
//		int indexSecond = 0;
//		
//		for(int i = 0; i<workers.length; i++){
//			for(int j = 0; j<workers.length; j++){
//				if(workers[j] != null){
//					first = workers[j];
//					indexFirst = j;
//				}
//			}
//			
//			for(int j = indexFirst+1; j<workers.length; j++){
//				if(workers[j] != null){
//					second = workers[j];
//					indexSecond = j;
//				}
//			}
//			
//			if first
//		}
//	}
}