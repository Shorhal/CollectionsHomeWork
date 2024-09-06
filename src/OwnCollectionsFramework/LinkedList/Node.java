package OwnCollectionsFramework.LinkedList;

public class Node<T> implements Comparable<T> {
    Node previous;
    T value;
    Node next;

    public Node(T value) {
        this.value = value;
    }

    public Node() {
        previous = null;
        next = null;
        value = null;
    }

    public Node(Node previous, T value, Node next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }


    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
