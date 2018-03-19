
public class Node {
        public Object data;
        public Node next;
        public Node prev;

        public Node(Object data) {
            this.data = data;
            prev = null;
            next = null;
        }

        public void displayNode() {
            System.out.print(data + " ");
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }