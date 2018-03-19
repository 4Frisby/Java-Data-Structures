import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

class SingleLinkedList {
	// Class variables for the Linked List
	private static Node head;
	private static Node sortedHead;
	private static int numNodes;

	public static void main(String[] args) {
		System.out.println("/=/=/=/= TESTING /=/=/=/=");
		SingleLinkedList ll = new SingleLinkedList(10);
		ll.addAtTail(15);
		ll.addAtTail(10);
		ll.addAtTail(29);
		ll.addAtTail(5);
		//ll.reverseList();
		//ll.insertionSortList();
		//ll.reverseListWithStack();
		ll.reverseListWithRecursion();
		ll.printList();
		
	}

	public SingleLinkedList(Object dat) {
		head = new Node(dat);
		sortedHead = null;
	}

	public void addAtHead(Object dat) {
		Node temp = head;
		head = new Node(dat);
		head.next = temp;
		numNodes++;
	}

	public void addAtTail(Object dat) {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(dat);
		numNodes++;
	}

	public void addAtIndex(int index, Object dat) {
		Node temp = head;
		Node holder;
		for (int i = 0; i < index - 1 && temp.next != null; i++) {
			temp = temp.next;
		}
		holder = temp.next;
		temp.next = new Node(dat);
		temp.next.next = holder;
		numNodes++;
	}

	public void deleteAtIndex(int index) {
		Node temp = head;
		for (int i = 0; i < index - 1 && temp.next != null; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		numNodes--;
	}

	public static int find(Node n) {
		Node t = head;
		int index = 0;
		while (t != n) {
			index++;
			t = t.next;
		}
		return index;
	}

	public static Node find(int index) {
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public static void reverseList() {
		Long startTime = startTime();
		Boolean stillHas = true;
		Node currentNode = head.next;
		Node prevNode = head;
		Node nextNode;
		head.next = null;
		while (stillHas) {
			if (currentNode == null) {
				stillHas = false;
				head = prevNode;
			} else {
				nextNode = currentNode.next;
				currentNode.next = prevNode;
				prevNode = currentNode;
				currentNode = nextNode;

			}

		}
		stopAndPrintExecutionTime(startTime);
	}
	
	public static void reverseListWithStack() {
		Long startTime = startTime();
	    Node reverseHead;
	    Stack<Node> s = new Stack<Node>();
	    Node curr = head;
	    while(curr != null){
	        s.push(curr);
	        curr = curr.next;
	    }
	    
	    reverseHead = s.pop();
	    Node revCurr = reverseHead;
	    while(!s.isEmpty()) {
	    	revCurr.next = s.pop();
	    	revCurr = revCurr.next;
	    }
	    revCurr.next = null;
	    head = reverseHead;
		stopAndPrintExecutionTime(startTime);
	}
	
	public static void reverseListWithRecursion() { 
		Long startTime = startTime();
	    Node headN = head.next;
	    head.next = null;
	    reverseRecursive(head,headN);
	    stopAndPrintExecutionTime(startTime);
	}
	
	public static void reverseRecursive(Node curr,Node next) {
	    if(next != null) {
			Node childNext = next.next;
			next.next = curr;
		    reverseRecursive(next,childNext);
	    }
	    else
	    	head = curr;
	    
	}
	

	public static void insertionSortList() {
		sortedHead = null;
		Node current = head;

		while (current != null) {
			// Store next for next iteration
			Node next = current.next;
			sortedInsert(current);
			current = next;
		}
		// sıralanmış dizinin başını head olarak ata.
		head = sortedHead;
	}

	public static void sortedInsert(Node newnode) {
		// ilk eleman gelmişse veya gelen eleman head'den küçükse onu head yap.
		if (sortedHead == null || (Integer) sortedHead.data >= (Integer) newnode.data) {
			newnode.next = sortedHead;
			sortedHead = newnode;
		} else {
			Node current = sortedHead;
			// büyük olduğu ilk yeri sapta.
			while (current.next != null && (Integer) current.next.data < (Integer) newnode.data) {
				current = current.next;
			}
			
			// büyük olduğu elemanın nexti -> yeni gelen
			// yeni gelenin nexti -> büyük olduğu elemanın nexti
			newnode.next = current.next;
			current.next = newnode;
		}
	}

	public static void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void removeDuplicateValues() {
	    if(head==null || head.next==null) 
	    	return;
	    		
	    Node root = head;
	    Node curr = head;
	    while(curr.next!=null){
	       if(curr.data!=curr.next.data){
	    	   curr = curr.next;
	       }else{
	    	   curr.next = curr.next.next;
	       }
	    }
	    head = root;
	}
	
	public static boolean hasCycle() {
	    HashMap<Node,Boolean> nodeNext = new HashMap<Node,Boolean>();
	    
	    if(head == null || head.next == null)
	        return false;

	    Node curr = head.next;
	    while(curr.next != null){
	        if(nodeNext.get(curr) != null)
	        	nodeNext.put(curr, true);
	        else
	        	return true;
	        curr = curr.next;
	    }
	    return false;
	}
	
	public static boolean floydCycleAlgo() {
	    //floyd-cycle finding algo solution (better) 
	    // one pointer goes one by one other pointer goes two by two if there is a loop they meet that element.

	    if (head == null){
	        return false;
	    }

	    Node slow = head;
	    Node fast = head;

	    while (fast != null && fast.next != null){
	        slow = slow.next;
	        fast = fast.next.next;

	        if (slow == fast){
	            return true;
	        }
	    }

	    return false;
	}

	Object FindMergeNode(Node headA, Node headB) {
		// Complete this function
		// Do not write the main method.

		ArrayList<Node> pointedList = new ArrayList<Node>();

		Node curr = headA;
		while (curr != null) {
			pointedList.add(curr);
			curr = curr.next;
		}

		curr = headB;
		while (curr != null) {
			if (pointedList.contains(curr))
				return curr.data;
			curr = curr.next;
		}

		return 0;

	}
	
	
	
	
	
	public static int getSize() {
		return numNodes;
	}

	public static Long startTime() {
		return System.nanoTime();
	}
	
	public static void stopAndPrintExecutionTime(Long startTime) {
	      long stopTime = System.nanoTime();
	      long elapsedTime = stopTime - startTime;
	      System.err.println("\nexecution time : "+  elapsedTime + "\n");
	}
	
	
	class Node {
		// Declare class variables
		private Node next;
		private Object data;

		public Node(Object dat) {
			data = dat;
		}

		public Object getData() {
			return data;
		}
	}
}