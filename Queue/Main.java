package Queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int action ;
        Queue newQueue = new Queue();
        for (int i = 1 ; i <= 5; i++ ){
            enqueue(newQueue, i);
        }

        while(!quit){
            printActions();
            System.out.println("Enter Actions:");
            action = scanner.nextInt();
            scanner.nextLine();
            Queue caseQueue = newQueue;

            switch(action){
                case 1: 
                    System.out.print("Queue :\t");
                    printQueue(caseQueue);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("(Enqueue) Enter Data :");
                    int enqueueData = scanner.nextInt();
                    scanner.nextLine();
                    enqueue(caseQueue, enqueueData);
                    System.out.println();
                    break;
                case 3:
                    dequeue(caseQueue);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter number to search :");
                    int searchItem = scanner.nextInt();
                    scanner.nextLine();
                    searchQueue(caseQueue, searchItem);
                    break;
                case 5:
                    quit = true;
                    System.out.println("Left Queue");
                    break;
                default:
                    System.out.println("Invalid Action!");
                    System.out.println();

            }
        }



       scanner.close();

    }
    private static void printActions(){
        System.out.println("Available Actions:\n"+
                           "1 - print queue\n"+
                           "2 - Enqueue\n"+
                           "3 - Dequeue\n"+
                           "4 - Search Data\n"+
                           "5 - Quit");
    }
    //print Queue.
    private static void printQueue(Queue queue){
        LinkedListNode pointer;
        pointer = queue.front;
        if (queue.front == null) {
            System.out.println("\n+++++++++++++++");
            System.out.println("+ Empty Queue +");
            System.out.println("+++++++++++++++");
            return;
        }

        while(pointer != null){
            if(pointer.next == null){
                System.out.println(pointer.data);
            }
            else{
                System.out.print(pointer.data +"-->");
            }
            pointer = pointer.next;
        }
    }





    // insert Element in queue
    private static void enqueue(Queue queue,int data){
        LinkedListNode newNode = new LinkedListNode(data);
        if(queue.front == null){
            queue.front = newNode;
        }
        else{
            queue.rear.next = newNode;
        }
        queue.rear = newNode;
        System.out.println("Enqueue Successfull!");
    }


    // delete from queue(dequeue)
    private static void dequeue(Queue queue){
        LinkedListNode dNode ;
        dNode = queue.front;
        if(queue.front == null){
            System.out.println("+++++++++++++++");
            System.out.println("+ Empty Queue +");
            System.out.println("+++++++++++++++");
            return;
        }
        queue.front = queue.front.next;
        dNode.next = null;
        System.out.println("Dequeue Successsfull!");
    }

    // Search Element from the Queue.
    private static void searchQueue(Queue queue , int searchData){
        LinkedListNode pointer;
        pointer = queue.front;
        int searchCount = 0;
        while (pointer != null) {
            searchCount++;
            if (pointer.data == searchData) {
                System.out.println("Data Found at Position "+searchCount+" from Front\n");
                return;
            }
            pointer = pointer.next;
        }
        if (pointer == null) {
            System.out.println("Not Found!\n");
        }
    }
    
}
