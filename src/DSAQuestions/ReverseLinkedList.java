package DSAQuestions;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

}

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("The original list is: ");
        list.display();

        list.reverse();
        System.out.print("The reverse list is: ");
        list.display();

    }
}
