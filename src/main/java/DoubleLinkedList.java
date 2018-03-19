
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

    public void SortedInsert(int data) {
        Node n = new Node(data);
        if(first == null) {
            first = n;
            return;
        }
            
        
        Node curr = first;
        while(curr.next != null && (Integer)data >= (Integer)curr.next.data){
            curr = curr.next;
        }
      
        if(curr.next == null)
        {
            n.prev = curr;
            n.next = null;
            curr.next = n;
        }
        else
        {
            n.prev = curr;
            n.next = curr.next;
            curr.next.prev = n;
            curr.next = n;
        }

    }
    
    
    public void reverseList(Node curr) {
    	
   	
    	if(first == curr)
    		last = curr;
    	
    	if(curr.next != null) {
    		Node next = curr.next;
    		curr.next = curr.prev;
    		curr.prev = next;    		
    		reverseList(next);
    	}else {
    		curr.next = curr.prev;
    		curr.prev = null;
    		first = curr;
    	}
    	
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
        ll.SortedInsert(1);
        ll.SortedInsert(12);
        ll.SortedInsert(5);
        ll.SortedInsert(20);
        ll.reverseList(ll.first);
        ll.displayList();
        
    }
    
    
}