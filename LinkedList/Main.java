package LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int actions, data;
        LinkedList newList = new LinkedList();
        for (int i = 1; i <= 10; i++) {
            insertNode(i, newList);
        }

        //LinkedList emptyList = new LinkedList();




        while (!quit) {
            printActions();
            LinkedList caseList = newList;
            System.out.println("Enter actions");
            actions = scanner.nextInt();
            scanner.nextLine();
            switch (actions) {
                case 1:
                    printList(caseList);
                    break;
                case 2:
                    System.out.println("Enter the node data : ");
                    data = scanner.nextInt();
                    scanner.nextLine();
                    insertNode(data, caseList);
                    System.out.println("Node Added successfully");
                    break;
                case 3:
                    System.out.println("Size of List :" + sizeOfList(caseList));
                    break;
                case 4:
                    System.out.println("Delete by Position or NodeData\n"+
                    "1 - Delete By Position\n"+
                    "2 - DeleteByData"
                    );
                    System.out.println("Your Choice : ");
                    int deleteChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch(deleteChoice){
                        case 1:
                            System.out.println("(Deletion) Enter the position : ");
                            int position = scanner.nextInt();
                            scanner.nextLine();
                            deleteNodeByPos(caseList, position);
                            break;
                        case 2:
                            System.out.println("Enter the Node Value : ");
                            int deleteValue = scanner.nextInt();
                            scanner.nextLine();
                            deleteNodeByData(caseList, deleteValue);
                            break;
                        default:
                            System.out.println("Invalid Choice");
                    }
                    break;
                case 5:
                    reverseList(caseList);
                    break;
                    
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Action!");

            }
        }
        scanner.close();
    }

    // print Actions
    private static void printActions() {
        System.out.println("Available Actions :\n"+
                "1 - print List\n" +
                        "2 - insert node\n" +
                        "3 - size of List\n" +
                        "4 - Delete a node\n" +
                        "5 - Reverse List\n"+
                        "6 - quit!");
    }

    // printing list.
    private static void printList(LinkedList list) {
        LinkedListNode pointer;
        pointer = list.head;

        if (sizeOfList(list) == 0) {
            System.out.println("+++++++++++++++");
            System.out.println("+ Empty list! +");
            System.out.println("+++++++++++++++");
            return;
        }

        // Borders
        for (int i = 0; i < sizeOfList(list); i++) {
            System.out.print("=====");
        }
        System.out.println();

        System.out.print("List :");
        while (pointer != null) {
            if (pointer.next == null) {
                System.out.println(pointer.data);
            } else {
                System.out.print(pointer.data + "-->");
            }
            pointer = pointer.next;
        }

        // Borders
        for (int i = 0; i < sizeOfList(list); i++) {
            System.out.print("=====");
        }
        System.out.println();

    }

    // insert node at the end
    private static void insertNode(int data, LinkedList list) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (list.head == null) {
            list.head = newNode;
        } else {
            list.tail.next = newNode;
        }
        list.tail = newNode;
    }

    // Size of List
    private static int sizeOfList(LinkedList list) {
        LinkedListNode pointer;
        pointer = list.head;
        int count = 0;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }
        return count;
    }

    // Deleting a list. (by Position)
    private static void deleteNodeByPos(LinkedList list, int position) {
        LinkedListNode pointer;
        pointer = list.head;
        int i = 1;
        if(position > sizeOfList(list)){
            System.out.println("Position Not available!");
            return;
        }
        while (i < position - 1) {
            pointer = pointer.next;
            i++;
        }
        // deleting a start of list.
        if (pointer == list.head) {
            list.head = pointer.next;
            pointer.next = null;
        }
        // deleting for last node.
        else if (pointer.next.next == null) {
            pointer.next = null;
            list.tail = pointer;
        } else {
            pointer.next = pointer.next.next;
        }
        System.out.println("Deletion successfull");
    }

    // Deleting a list. (By data)
    private static void deleteNodeByData(LinkedList list, int data){
        LinkedListNode deleteNode;
        LinkedListNode prev;
        deleteNode = list.head;
        prev = null;
        if(list.head.data == data){
            list.head = list.head.next;
            deleteNode.next = null;
            System.out.println("Deletion successfull!");
            return;
        }

        while(deleteNode!= null && deleteNode.data != data){
            prev = deleteNode;
            deleteNode = deleteNode.next;
        }
        
        if (deleteNode == null) {
            System.out.println("Data Not found");
            return;
        }
        prev.next = deleteNode.next;
        deleteNode.next = null;
        System.out.println("Deletion successfull!");
    }

    //Reverse of linked list
    private static void reverseList(LinkedList list){
        if(sizeOfList(list)  < 2){
            System.out.println("+++++++++++++++++++++++++++");
            System.out.println("+ Unity list or null list +\n"+
                               "+ cannot be reversed!     +");
            System.out.println("+++++++++++++++++++++++++++");

            return;
        }
        LinkedListNode c;
        LinkedListNode p;
        LinkedListNode n;
        c = list.head;
        p = list.head;
        n = list.head.next;
        list.head.next = null;
        list.tail = list.tail;
        while (n != null) {
            c = n;
            n = n.next;
            c.next = p;
            p = c;
        }
       list.head = c;
        System.out.println("Reversed successfully!");
    }
}
