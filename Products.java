class Products {
    protected int id;
    protected String name;
    protected int quantity;
    protected double price;

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

class Node {
    protected Products data;
    protected Node prev;
    protected Node next;

    // Default constructor
    public Node(Products data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Constructor with linked nodes
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

class LinkedList {
    protected Node head;
    protected Node tail;

    // Method to insert a new node at the end
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

    // Method to delete a node with specific data
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

    // Method to print the list
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

    // Method to sort the list using Insertion Sort
    public void insertionSort(LinkedList list) {
        // Your code for insertion sort here
        list = InsertionSort.insertionSort(list);
    }

    // Method to sort the list using Merge Sort
    public void mergeSort(LinkedList myList) {
        // Your code for merge sort here
        myList = MergeSort.mergeSort(myList);
    }

    public static void main(String[] args) {
        LinkedList productList = new LinkedList();

        productList.append(new Products(1, "skis", 3, 600));
        productList.append(new Products(2, "snowboard", 4, 800));
        productList.append(new Products(3, "gloves", 3, 50));
        productList.append(new Products(4, "helmet", 3, 159.99));
        productList.append(new Products(5, "snowshoes", 2, 149.99));
        productList.append(new Products(6, "jacket", 1, 349.99));
        productList.append(new Products(7, "thermal pants", 4, 250));
        productList.append(new Products(8, "snow goggles", 3, 99.50));
        productList.append(new Products(9, "thermal shirt", 5, 300));
        productList.append(new Products(10, "thermal vest", 2, 264.99));

        // Printing the list
        productList.printList();
    }
}
