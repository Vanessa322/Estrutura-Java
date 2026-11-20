import java.util.ArrayList;

public class Deque<T> {

    private static final int DEFAULT_LIMIT = 100;

    private ArrayList<T> data;
    private int limit;

    public Deque() {
        this(DEFAULT_LIMIT);
    }

    public Deque(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("O limite deve ser maior que zero.");
        }
        this.data = new ArrayList<T>();
        this.limit = limit;
    }

    public void insertFront(T val) {
        checkInsertion(val);
        this.data.add(0, val);
    }

    public void insertBack(T val) {
        checkInsertion(val);
        this.data.add(val);
    }

    private void checkInsertion(T val) {
        if (isFull()) {
            throw new IllegalStateException("Deque cheio: limite de " + this.limit + " elementos.");
        }
        if (this.data.contains(val)) {
            throw new IllegalArgumentException("Elemento duplicado: " + val + " já existe no deque.");
        }
    }

    public T removeFront() {
        if (isEmpty()) {
            return null;
        }
        return this.data.remove(0);
    }

    public T removeBack() {
        if (isEmpty()) {
            return null;
        }
        return this.data.remove(this.data.size() - 1);
    }

    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        return this.data.get(0);
    }

    public T peekBack() {
        if (isEmpty()) {
            return null;
        }
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public boolean isFull() {
        return this.data.size() >= this.limit;
    }

    public String print() {
        StringBuilder output = new StringBuilder("[ ");
        for (int i = 0; i < this.data.size(); i++) {
            if (output.length() > 2) {
                output.append(", ");
            }
            output.append("(")
                    .append(i)
                    .append("): ")
                    .append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}