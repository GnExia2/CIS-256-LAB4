/**
 * The Products class represents a product with attributes such as ID, name, quantity, and price.
 * This class is used to encapsulate product information.
 */
class Products {
    protected int id;
    protected String name;
    protected int quantity;
    protected double price;

    /**
     * Constructs a new Products object with the specified attributes.
     *
     * @param id       The unique identifier of the product.
     * @param name     The name of the product.
     * @param quantity The quantity of the product available.
     * @param price    The price of the product.
     */
    public Products(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

/**
 * The Node class represents a node in a doubly linked list. Each node contains data
 * of type Products and references to the previous and next nodes in the list.
 */
class Node {
    protected Products data;
    protected Node prev;
    protected Node next;

    /**
     * Constructs a new Node object with the specified product data and initializes
     * the previous and next references to null.
     *
     * @param data The product data to be stored in the node.
     */
    public Node(Products data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    /**
     * Constructs a new Node object with the specified product data and links it
     * to the previous and next nodes.
     *
     * @param data The product data to be stored in the node.
     * @param prev The previous node in the list.
     * @param next The next node in the list.
     */
    public Node(Products data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Products getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

/**
 * The LinkedList class represents a doubly linked list of Products. It provides
 * methods for appending, deleting, printing, and sorting the list using insertion sort
 * and merge sort algorithms.
 */
class LinkedList {
    protected Node head;
    protected Node tail;

    /**
     * Appends a new product node with the specified data to the end of the linked list.
     *
     * @param data The product data to be added to the list.
     */
    public void append(Products data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    /**
     * Deletes the first occurrence of a product node with the specified data from the list.
     *
     * @param data The product data to be deleted from the list.
     */
    public void delete(Products data) {
        Node current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    tail = current.getPrev();
                }

                return; // Exit after deletion
            }
            current = current.getNext();
        }
    }

    /**
     * Prints the contents of the linked list, displaying product information for each node.
     */
    public void printList() {
        Node current = head;

        if (current == null) {
            System.out.println("The list is empty.");
            return;
        }

        while (current != null) {
            Products product = current.getData();
            System.out.println(product.getId() + ": " + product.getName() + " - Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
            current = current.getNext();
        }
    }

    /**
     * Sorts the linked list in ascending order using the insertion sort algorithm.
     *
     * @param list The linked list to be sorted.
     */
    public static LinkedList insertionSort(LinkedList list) {
        // Your code for insertion sort here
        return InsertionSort.insertionSort(list);
    }

    /**
     * Sorts the linked list in ascending order using the insertion sort algorithm.
     *
     * @param list The linked list to be sorted.
     */
    public static LinkedList mergeSort(LinkedList myList) {
        // Your code for merge sort here
        return MergeSort.mergeSort(myList);
    }

    /**
     * The main method creates a linked list of products, appends products to it,
     * and prints the list.
     *
     * @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {
        LinkedList productList = new LinkedList();

        productList.append(new Products(6, "jacket", 1, 349.99));
        productList.append(new Products(7, "thermal pants", 4, 250));
        productList.append(new Products(8, "snow goggles", 3, 99.50));
        productList.append(new Products(9, "thermal shirt", 5, 300));
        productList.append(new Products(10, "thermal vest", 2, 264.99));
        productList.append(new Products(1, "skis", 3, 600));
        productList.append(new Products(2, "snowboard", 4, 800));
        productList.append(new Products(3, "gloves", 3, 50));
        productList.append(new Products(4, "helmet", 3, 159.99));
        productList.append(new Products(5, "snowshoes", 2, 149.99));


        // Printing the list
        productList.printList();
        
        boolean sorter = false;
        if (sorter == true) {
            productList = mergeSort(productList);
            System.out.println("MERGE SORT RESULT:");
            productList.printList();
        } else {
            productList = insertionSort(productList);
            System.out.println("INSERTION SORT RESULT:");
            productList.printList();
        }

    }
}
