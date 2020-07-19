package SinglyLinkedList;

public class SinglyLinkedList {
    public Node head;
    int size;

    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        } else{
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
            System.out.println(value);
            this.size++;
        }
    }

    public void remove(int value){
        if(head == null){
            System.out.println("List is Empty");
        }
        Node runner = this.head;
        if(value == 0 && this.size > 1){
            this.head = runner.next;
        } else{
            int counter = 0;
            while (runner.next != null){
                if(counter == value - 1){
                    runner.next = runner.next.next;
                    return;
                }
                runner = runner.next;
                counter++;
            }
        }
    }

    public void printValues(){
        if (this.head == null) {
            System.out.println("List is empty");
        }
        Node runner = this.head;
        int counter = 0;
        while (runner != null) {
            if (counter < 1) {
              System.out.println("Root: " + runner.value);
              counter++;
              runner = runner.next;
            } else {
              System.out.println("Node " + counter + " : " + runner.value);
              runner = runner.next;
              counter++;
            }
        }
    }
}