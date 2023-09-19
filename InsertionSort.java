
/**
 * The InsertionSort class sorts a linked list accordingly with swaps.
 * 
 * Insertion sort is a simple  way for comparisons with a container being split 
 * into a sorted and unsorted part. The values from the unsorted part are
 *  arranged at the proper position in the sorted part.
 * */

public class InsertionSort {
	/**
     *  Sorts a linked list in ascending order with an insertion sort approach.
     *
     * @param list Linked list to be sorted.
     * @return A new linked list with the sorted elements.
     */
     
	 public static LinkedList insertionSort(LinkedList list) {
		// empty list
		 LinkedList sorted = new LinkedList(); 
		
		//while original list not empty 
			while (list.head != null) { 
				// loop for smallest
				//point at first
				 Node current = list.head;
					 Node small = list.head;
					
				while (current != null) {
					// compare current and smallest
					if (small != null && small.data.id > current.data.id) {
						// new memory for small
						small = new Node (current.data); 
					}
					// next node to continue
					current=current.next;
				}
				current=list.head;
				
				// append smallest and remove node on old list 
				if (small != null) {
					sorted.append(small.data);
					
					list.delete(small.data);
				}
			}

			return sorted;
		}
	 
	 
	 public static void main(String[] args) {
	        // Create a sample linked list with unsorted data
	        LinkedList list = new LinkedList();
	        list.append(new Products(5, "snowshoes", 2, 149.99));
	        list.append(new Products(6, "jacket", 1, 349.99));
	        list.append(new Products(7, "thermal pants", 4, 250));
	        list.append(new Products(8, "snow goggles", 3, 99.50));
	        list.append(new Products(9, "thermal shirt", 5, 300));
	        list.append(new Products(10, "thermal vest", 2, 264.99));
	        list.append(new Products(1, "skis", 3, 600));
	        list.append(new Products(2, "snowboard", 4, 800));
	        list.append(new Products(3, "gloves", 3, 50));
	        list.append(new Products(4, "helmet", 3, 159.99));

	        System.out.println("BEFORE: ");
	        list.printList();
			System.out.println();
	        
	        list = insertionSort(list);
	        
	        System.out.println("AFTER: ");
	        list.printList();
  
	 }
}
