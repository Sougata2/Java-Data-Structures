package DoublyLinkedList;

import java.util.Scanner;


/**
 * Main
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        DoublyLinkedList list = new DoublyLinkedList();

        for (int i = 1; i <= 5; i++) {
            insertNode(i, list);
        }

        //DoublyLinkedList emptyList = new DoublyLinkedList();
        
        while (!quit){
            DoublyLinkedList caseList;
            caseList = list;
            printActions();
            System.out.println("ACTION : ");
            int actions = scanner.nextInt();
            scanner.nextLine();

            switch(actions){
                case 1:
                    System.out.println("List :");
                    printList(caseList);
                    break;
                case 2:
                    System.out.println("Enter Node Data :");
                    int data = scanner.nextInt();
                    scanner.nextLine();
                    insertNode(data, caseList);
                    break;
                case 3:
                    System.out.println("DELETION \nEnter the positon :");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    deleteNode(pos, caseList);
                    break;
                case 4:
                    System.out.println("Size of List :"+sizeOfList(caseList));
                    break;
                case 5:
                    if (sizeOfList(caseList) == 1 || sizeOfList(caseList) == 0) {
                        System.out.println("Sorry, cannot be reversed\neither empty or unity");
                    }
                    else {
                        reverseList(caseList);
                        System.out.println("List Reversed Successfully!");  
                    }
                    break;
                case 6:
                    quit = true;
            }
            

        }






        scanner.close();
    }

    private static void printActions(){
        System.out.println("Available Actions : \n"+
                           "1: print List\n"+
                           "2: insert node\n"+
                           "3: delete node (provide position)\n"+
                           "4: Size of List\n"+
                           "5: Reverse the List\n"+
                           "6: quit!");
    }

    private static void printList(DoublyLinkedList list){
        DoublyLinkedListNode pointer;
        pointer = list.head;
        while (pointer != null){
            if(pointer.next == null){
                System.out.println(pointer.data);
            }
            else{
                System.out.print(pointer.data+"<-->");
            }
            pointer = pointer.next;
        }
    }

    private static void insertNode(int nodeData, DoublyLinkedList list){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(nodeData);
        if (list.head == null){
            list.head = newNode;
        }
        else{
            newNode.prev = list.tail;
            list.tail.next = newNode;
        }
        list.tail = newNode;
    }

    private static void deleteNode(int position, DoublyLinkedList list){
        DoublyLinkedListNode pointer;
        pointer = list.head;
        for(int i = 0 ; i < position-1 ; i++){
            pointer = pointer.next;
        }

        // if head is being removed.
        if (pointer.prev != null){
            pointer.prev.next = pointer.next;
        }
        else{
            list.head = list.head.next;
        }

        // if tail is being removed.
        if (pointer.next != null){
            pointer.next.prev = pointer.prev;
        }
        else{
            list.tail = list.tail.prev;
        }

        pointer.next = null;
        pointer.prev = null;
    }

    private static int sizeOfList(DoublyLinkedList list){
        DoublyLinkedListNode pointer;
        pointer = list.head;
        int count = 0 ;

        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }

        return count;
    }

    private static void reverseList(DoublyLinkedList list){
        DoublyLinkedListNode pointer;
        pointer = list.head;
        DoublyLinkedListNode temp;

        while (pointer != null) {
            temp = pointer.prev;
            pointer.prev = pointer.next;
            pointer.next = temp;

            pointer = pointer.prev;
        }
        if (list.head != null){
            temp = list.head;
            list.head = list.tail;
            list.tail = temp;
        }

    }

}