public class MergeTester {
    public static void main(String[] args) {
        // Create a sample linked list with unsorted data
        LinkedList list = new LinkedList();
        list.append(new Products(3, "Product C", 4, 19.99));
        list.append(new Products(1, "Product A", 4, 9.99));
        list.append(new Products(2, "Product B", 3, 15.99));
        list.append(new Products(4, "Product D", 4, 29.99));

        // Sort the list using merge sort
        list = MergeSort.mergeSort(list);

        // Verify that the list is sorted
        Node current = list.head;
        boolean isSorted = true;
        while (current != null && current.next != null) {
            if (current.data.id > current.next.data.id) {
                isSorted = false;
                break;
            }
            current = current.next;
        }

        if (isSorted) {
            System.out.println("Merge Sort Test Passed: The list is sorted.");
        } else {
            System.out.println("Merge Sort Test Failed: The list is not sorted.");
        }
    }
}
