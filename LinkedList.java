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
    Node head;
    Node currentNode;
    static int size = 0;
    int noOfNodes;
    LinkList(int noOfNodes){
        this.noOfNodes = noOfNodes;
    }

    // Construct a Linked List .....!
    void constructLL(int inputData) {// head = 10; noOfNodes = 5; size =2; currentNode = 20; inputdata = 20;
            Node newNode = new Node(inputData);
            if (head == null) {
                head = newNode;
                currentNode = head;
            }
            else {
                currentNode.next = newNode;
                currentNode = currentNode.next;
            }
            size++;
    }

    // Add at first position.......!
    void addfirst(int inputData) { // head = 10; size = 5; currentNode = 50; inputdata = 5
        Node newNode = new Node(inputData);
        int i = 0;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++; // head = 5;  size = 6;
    }

    void removefirst() {
        if(head == null){
            System.out.println("LinkedList has No element...!");
            return;
        }
        head = head.next;
        size--;
    }

    // add at last position......!
    void addlast(int inputData) { //head =5; currentNode = 50; size =6; inputdata = 60;
        Node newNode = new Node(inputData);
        if (head == null) {
            head = newNode;
            currentNode = head;
            return;
        }
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;
    }
    // Remove at last position.......!
    void removelast() {
        if(head == null){
            System.out.println("LinkList is empty");
        }
        else {
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
    }
    // Add element in between the Linked List.....!
    void addMid(int inputData, int position) {
        Node newNode = new Node(inputData);
        Node currentNode = head;
        int i = 0;
        if(head == null){
            System.out.println("LinkList is empty");
            return;
        }
        else if(position-1 >=size){
            System.out.println("Linkedlist is null at position " + position);
            return;
        }
        else {
            while (i != position - 1) {
                currentNode = currentNode.next;
                i++;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
// Remove the element in between the Linked List.......!
    void removeMid(int position) {
        if(head == null){
            System.out.println("LinkList is empty");
            return;
        }
        else if(position-1 >=size){
            System.out.println("There is no element at position " + position);
            return;
        }
        else {
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
    }
    // Insert element just after the head node.....!
    void insertAfterNode(int inputData){
        Node newNode = new Node(inputData);
        if(head == null){
            head = newNode;
            return;
        }
        Node currentNode = head;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }
    // Delete element after the head node.......!
    void deleteAfterNode(){
        if(head == null){
            System.out.println("LinkList is empty");
        }
        else {
            Node currentNode = head;
            head.next = currentNode.next.next;
            currentNode = currentNode.next;
            size--;
        }
    }
    // Read the data of Linked List by giving position......!
    void getLL(int position) {
        if(head == null){
            System.out.println("LinkList is empty");
            return;
        }
        else if(position-1 >=size) {
            System.out.println("There is no element at position " + position);
            return;
        }
        else {
            Node currentNode = head;
            for (int i = 1; i <= size; i++) {
                if (i == position) {
                    System.out.println(currentNode.data);
                }
                currentNode = currentNode.next;
            }
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. to create how many nodes.....!");
        int noOfNodes = sc.nextInt();
        LinkList l1 = new LinkList(noOfNodes); // head = null; noOfNodes = 5; size =0;
        System.out.println("Before Manipulation of LL");
        int inputData;
        for (int i = 1; i <= noOfNodes; i++) {
        System.out.println("Enter the data to put into Nodes");
        inputData = sc.nextInt();
            l1.constructLL(inputData);
        }
        l1.printLinkList();
        l1.getSize();
        l1.getLL(2);
        System.out.println("After Manipulation of LL by insert element at first\n Enter the data into Node");
        inputData = sc.nextInt(); // 5
        l1.addfirst(inputData);
        l1.printLinkList();
        l1.getSize(); //6
        System.out.println("After Manipulation of LL by insert element at last.\n Enter the data into Node");
        inputData = sc.nextInt(); //60
        l1.addlast(inputData);
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
        inputData = sc.nextInt();
        l1.addMid(inputData,6);
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by remove element in between LL");
        l1.removeMid(4);
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by add after Node");
        inputData = sc.nextInt();
        l1.insertAfterNode(inputData);
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL by remove after Node");
        l1.deleteAfterNode();
        l1.printLinkList();
        l1.getSize();
        System.out.println("After Manipulation of LL completed and want to read any data at any position.");
        l1.getLL(6);
        l1.getLL(3);
    }}