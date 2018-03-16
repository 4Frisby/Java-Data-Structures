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
		ll.reverseList();
		//ll.insertionSortList();
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

	public static int getSize() {
		return numNodes;
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