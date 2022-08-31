import java.util.*;

// Write a java program for LinkList?
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class LinkList {
    Scanner sc = new Scanner(System.in);
    Node head;
    Node currentNode = head;
    static int size = 0;

    // Construct a Linked List .....!
    void constructLL() {
        System.out.println("Enter the No. to create how many nodes.....!");
        int noOfNodes = sc.nextInt();
        for (int i = 1; i <= noOfNodes; i++) {
            System.out.println("Enter the value to put into Nodes");
            int inputData = sc.nextInt();
            Node newNode = new Node(inputData);
            if (head == null) {
                head = newNode;
                currentNode = head;
            } else {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            size++;
        }
    }

    // Add at first position.......!
    void addfirst() {
        System.out.println("Enter the data at first added newNode");
        int inputdata = sc.nextInt();
        Node newNode = new Node(inputdata);
        int i = 0;
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    void removefirst() {
        head = head.next;
        size--;
    }

    // add at last position......!
    void addlast() {
        System.out.println("Enter the data at last added newNode");
        int inputdata = sc.nextInt();
        Node newNode = new Node(inputdata);
        if (head == null) {
            head = newNode;
            currentNode = head;
        }
        currentNode = currentNode.next;
        if (currentNode.next == null) {
            currentNode.next = newNode;
            newNode = currentNode;
            size++;
        }
    }
    // Remove at last position.......!
    void removelast() {
        Node previousNode = head;
        Node currentNode = head.next;
        while (currentNode.next != null) {
            previousNode = previousNode.next;
            currentNode = currentNode.next;
        }
        if (currentNode.next == null) {
            previousNode.next = null;
            size--;
        }
    }
    // Add element in between the Linked List.....!
    void addMid(int position) {
        System.out.println("Enter the data at middle added newNode");
        int inputdata = sc.nextInt();
        Node newNode = new Node(inputdata);
        Node currentNode = head;
        int i = 0;
        while (i != position - 1) {
            currentNode = currentNode.next;
            i++;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }
// Remove the element in between the Linked List.......!
    void removeMid(int position) {
        Node currentNode = head;
        Node previousNode = head.next;
        if (position == 1) {
            head = head.next;
            return;
        }
        int i = 0;
        while (i < position - 1) {
            currentNode = currentNode.next;
            previousNode = previousNode.next;
            i++;
        }
        currentNode.next = previousNode.next;
    }
    // Insert element just after the head node.....!
    void insertAfterNode(){
        Node currentNode = head;
        int inputdata = sc.nextInt();
        Node newNode = new Node(inputdata);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }
    // Delete element after the head node.......!
    void deleteAfterNode(){
        Node currentNode = head;
        head.next = currentNode.next.next;
        currentNode = currentNode.next;
        size--;
    }
    // Read the data of Linked List by giving position......!
    void getLL(int position) {
        Node currentNode = head;
        for (int i = 1; i <= size; i++) {
            if (i == position) {
                System.out.println(currentNode.data);
            }
            currentNode = currentNode.next;
        }
    }
    // Find the Size of the Linked List........!
    void getSize() {
        System.out.println(size);
    }
    // Printing the Linked List......!
    void printLinkList() {
        System.out.println("Printing LinkList");
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.printf("%d , ", currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }
}
public class LinkedList {
    public static void main(String[] args) {
        LinkList l1 = new LinkList();
        System.out.println("Before Manipulation of LL");
        l1.constructLL();
        l1.printLinkList();
        l1.getSize();
        l1.getLL(2);
        System.out.println("After Manipulation of LL by insert element at first");
        l1.addfirst();
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by insert element at last");
        l1.addlast();
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by remove element at first");
        l1.removefirst();
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by remove element at last");
        l1.removelast();
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by insert element in between LL");
        l1.addMid(3);
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by remove element in between LL");
        l1.removeMid(4);
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by add after Node");
        l1.insertAfterNode();
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by remove after Node");
        l1.deleteAfterNode();
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL completed and want to read any data at any position.");
        l1.getLL(2);
        l1.getLL(3);
    }}