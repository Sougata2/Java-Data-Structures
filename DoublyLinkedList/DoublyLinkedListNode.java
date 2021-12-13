package DoublyLinkedList;

public class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}