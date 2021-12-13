package Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack caseStack ;
        int action, NodeData;
        boolean quit = false;
        Stack newStack = new Stack();
        for (int i = 1 ; i <=10 ; i++){
            push(i, newStack);
        }
        //System.out.println(newStack.top.data +" "+newStack.bottom.data);

        while (!quit) {
            printActions();
            caseStack = newStack;
            System.out.println("Enter Action :\t");
            action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 1:
                    System.out.print("\nStack :\t");
                    printStack(caseStack);
                    break;
                case 2:
                    System.out.println("\n(Push) Enter data :\t");
                    NodeData = scanner.nextInt();
                    scanner.nextLine();
                    push(NodeData, caseStack);
                    break;
                case 3:
                    pop(caseStack);
                    break;
                case 4:
                    System.out.println(peek(caseStack));
                    break;
                case 5:
                    int searchElement;
                    System.out.println("Enter the data to search:\t");
                    searchElement = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(search(caseStack, searchElement));
                    break;
                case 6:
                    if(sizeOfStack(caseStack)-1 == -1){
                        System.out.println("Size : "+ 0);
                    }
                    else 
                    System.out.println("\nSize : "+ (sizeOfStack(caseStack)-1));
                    break;
                case 7:
                    quit = true;
                    System.out.println("LEFT STACK!");
                    break;
                default:
                    System.out.println("\nInvalid action!");

            }
            
        }

        

        scanner.close();
       

    }

    private static void printActions(){
        System.out.println("\nAvailable Actions:\n"+
                           "1 - print stack\n"+
                           "2 - push\n"+
                           "3 - pop\n"+
                           "4 - peek\n"+
                           "5 - search\n"+
                           "6 - Size of Stack\n"+
                           "7 - quit");
    }



    // print Stack.
    private static void printStack(Stack Stack){
        LinkedListNode pointer;
        pointer = Stack.bottom;
        if (pointer == null){
            System.out.println("\n+++++++++++++++");
            System.out.println("+ Empty Stack +");
            System.out.println("+++++++++++++++");
            return;
        }
        while (pointer != null) {
            if(pointer.next != null){
                System.out.print(pointer.data+"-->");
            }
            else{
                System.out.println(pointer.data);
            }
            pointer = pointer.next;
        }
    }

    // Push operation.
    private static void push(int data, Stack stack){
        LinkedListNode newNode = new LinkedListNode(data);
        if (stack.bottom == null) {
            stack.bottom = newNode;
        }
        else{
            stack.top.next= newNode;
        }
        stack.top = newNode;
        System.out.println("PUSH SUCCESS!");
    }

    //Pop operation.
    private static void pop (Stack stack){
        LinkedListNode pointer;
        pointer = stack.bottom;
        if (stack.bottom == null) {
            System.out.println("+++++++++++++++");
            System.out.println("+ Empty Stack +");
            System.out.println("+++++++++++++++");
            return;
        }
        else if (stack.top == stack.bottom){
            stack.bottom = null;
            stack.top = null;
            System.out.println("POP SUCCESS!");
            return;
        }
        
        while (pointer.next != stack.top) {
            pointer = pointer.next;
        }
        pointer.next = null;
        stack.top = pointer;
        System.out.println("POP SUCCESS!");
    }

    // Peek.
    private static String peek(Stack stack ){
        if (stack.top != null) {
            return "Top : "+Integer.toString(stack.top.data);
        }
        return "+++++++++++++++\n+ Empty Stack +\n+++++++++++++++";
    }

    // searching 
    private static String search(Stack stack, int data){
        LinkedListNode pointer;
        pointer = stack.bottom;
        int bottomCount = 0;
        while (pointer != null){
            bottomCount ++;
            if (pointer.data == data){
                return "Found data at Position "+ Integer.toString(sizeOfStack(stack)-bottomCount)+" from the Top.";
            }
            pointer = pointer.next;
        }
        return "Not Found";
        
    }
    
    // Size of Stack.
    private static int sizeOfStack(Stack stack){
        LinkedListNode pointer;
        pointer = stack.bottom;
        int size = 1;
        if (stack.bottom == null) {
            return 0;
        }
        while(pointer != null){
            size++;
            pointer = pointer.next;
        }
        return size;
        
    }

}
