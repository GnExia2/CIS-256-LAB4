public class MergeSort {
    public static LinkedList mergeSort(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            return list; // List is empty or has only one element
        }

        LinkedList left = new LinkedList();
        LinkedList right = new LinkedList();

        Node current = list.head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }

        int mid = size / 2;
        current = list.head;
        for (int i = 0; i < mid; i++) {
            left.append(current.data);
            current = current.next;
        }
        for (int i = mid; i < size; i++) {
            right.append(current.data);
            current = current.next;
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static LinkedList merge(LinkedList left, LinkedList right) {
        LinkedList result = new LinkedList(); // Create a new LinkedList for the result

        Node leftCurrent = left.head;
        Node rightCurrent = right.head;

        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.data.id <= rightCurrent.data.id) {
                result.append(leftCurrent.data);
                leftCurrent = leftCurrent.next;
            } else {
                result.append(rightCurrent.data);
                rightCurrent = rightCurrent.next;
            }
        }

        // Append remaining elements from left and right lists
        while (leftCurrent != null) {
            result.append(leftCurrent.data);
            leftCurrent = leftCurrent.next;
        }
        while (rightCurrent != null) {
            result.append(rightCurrent.data);
            rightCurrent = rightCurrent.next;
        }

        return result;
    }
}
