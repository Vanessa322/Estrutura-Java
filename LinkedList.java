import java.util.ArrayList;
import java.util.Objects;

public class LinkedList<T> {

    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T val) {
            this.data = val;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int count;
    private ArrayList<T> removedHistory; // Exercício 6

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
        this.removedHistory = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int getCount() {
        return this.count;
    }

    public void insert(int pos, T val) {

        Node<T> inserted = new Node<>(val);

        if (isEmpty()) {
            this.head = inserted;
            this.tail = inserted;
        }

        else if (pos == 0) {
            inserted.next = this.head;
            this.head = inserted;
        }

        else if (pos >= this.count) {
            this.tail.next = inserted;
            this.tail = inserted;
        }
        else {
            Node<T> before = this.head;

            for (int i = 1; i < pos; i++)
                before = before.next;

            Node<T> after = before.next;
            inserted.next = after;
            before.next = inserted;
        }

        this.count++;

    }

    public void insertHead(T val) {
        this.insert(0, val);
    }

    public void insertTail(T val) {
        this.insert(this.count, val);
    }

    public T remove(int pos) {
        if (isEmpty() || pos < 0 || pos > this.count - 1)
            return null;

        Node<T> removed;

        if (pos == 0) {
            removed = this.head;
            this.head = this.head.next;

            if (this.count == 1)
                this.tail = null;
        }

        else {
            Node<T> before = this.head;
            for (int i = 1; i < pos; i++)
                before = before.next;

            removed = before.next;
            Node<T> after = removed.next;
            before.next = after;

            if (pos == this.count - 1)
                this.tail = before;
        }

        this.count--;
        this.removedHistory.add(removed.data); // Exercício 6
        return removed.data;
    }

    public T removeHead() {
        return this.remove(0);
    }

    public T removeTail() {
        return this.remove(this.count - 1);
    }

    public int indexOf(T val) {

        if (isEmpty())
            return -1;

        Node<T> node = this.head;

        for (int i = 0; i < this.count; i++) {
            if (node.data.equals(val))
                return i;
            node = node.next;
        }
        return -1;
    }

    public T peek(int pos) {

        if (isEmpty() || pos < 0 || pos > this.count - 1)
            return null;

        Node<T> node = this.head;

        for (int i = 0; i < pos; i++)
            node = node.next;

        return node.data;
    }

    public T peekHead() {
        return this.peek(0);
    }

    public T peekTail() {
        return this.peek(this.count - 1);
    }

    public String print() {
        StringBuilder output = new StringBuilder("( ");
        Node<T> node = this.head;
        for (int i = 0; i < this.count; i++) {
            if (output.length() > 2)
                output.append(", ");
            output.append("[").append(i).append("]: ").append(node.data);
            node = node.next;
        }
        output.append(" ), count: ").append(this.count);
        return output.toString();
    }

    // Exercício 6
    public ArrayList<T> getHistory() {
        return new ArrayList<T>(this.removedHistory);
    }

    // Exercício 7
    public void reverse() {
        if (this.count < 2)
            return;

        Node<T> previous = null;
        Node<T> current = this.head;

        this.tail = this.head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.head = previous;
    }

    // Exercício 8
    public int countOccurrences(T val) {
        int occurrences = 0;
        Node<T> node = this.head;

        while (node != null) {
            if (Objects.equals(node.data, val))
                occurrences++;
            node = node.next;
        }

        return occurrences;
    }

    // Exercício 9
    public int removeAll(T val) {
        int removedCount = 0;
        Node<T> previous = null;
        Node<T> current = this.head;

        while (current != null) {
            Node<T> next = current.next;

            if (Objects.equals(current.data, val)) {
                if (previous == null)
                    this.head = next;
                else
                    previous.next = next;

                if (current == this.tail)
                    this.tail = previous;

                this.count--;
                this.removedHistory.add(current.data);
                removedCount++;
            }
            else {
                previous = current;
            }

            current = next;
        }

        return removedCount;
    }

    // Exercício 10
    public ArrayList<T> toArray() {
        ArrayList<T> result = new ArrayList<T>();
        Node<T> node = this.head;

        while (node != null) {
            result.add(node.data);
            node = node.next;
        }

        return result;
    }
}
