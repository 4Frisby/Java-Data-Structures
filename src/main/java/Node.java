
public class Node<T> {
        public T data;
        public Node next;
        public Node prev;

        public Node(T data) {
            this.data = data;
        }

        public void displayNode() {
            System.out.print(data + " ");
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }