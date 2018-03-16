
public class DoubleLinkedList<T> {

    public Node first = null;
    public Node last = null;

    public void addFirst(T data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            newNode.next = null;
            newNode.prev = null;
            first = newNode;
            last = newNode;

        } else {
            first.prev = newNode;
            newNode.next = first;
            newNode.prev = null;
            first = newNode;
        }
    }
    
    
    public void addLast(T data) {
    	Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = null;
            newNode.prev = null;
            first = newNode;
            last = newNode;

        } else {
            first.next = newNode;
            newNode.prev = last;
            newNode.next = null;
            last = newNode;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void removeFirst() {
        if (!isEmpty()) {
            Node temp = first;

            if (first.next == null) {
                first = null;
                last = null;
            } else {
                first = first.next;
                first.prev = null;
            }
            System.out.println(temp.toString() + " is popped from the list");
        }
    }

    public void removeLast() {
        Node temp = last;

        if (!isEmpty()) {

            if (first.next == null) {
                first = null;
                last = null;
            } else {
                last = last.prev;
                last.next = null;
            }
        }
        System.out.println(temp.toString() + " is popped from the list");
    }
    
    public static void main(String[] args) {
		
    	DoubleLinkedList<Integer> ll = new DoubleLinkedList<Integer>();
    	ll.addFirst(1);
    	ll.addFirst(12);
    	ll.addFirst(5);
    	ll.addFirst(20);
    	ll.displayList();
    	
	}
    
    
}