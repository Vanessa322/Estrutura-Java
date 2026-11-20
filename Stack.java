import java.util.ArrayList;

public class Stack<T> {

    private static final int DEFAULT_LIMIT = 100;

    private ArrayList<T> data;
    private ArrayList<T> historyData;
    private int limit;

    public Stack() {
        this(DEFAULT_LIMIT);
    }

    public Stack(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("O limite deve ser maior que zero.");
        }
        this.data = new ArrayList<T>();
        this.historyData = new ArrayList<T>();
        this.limit = limit;
    }

    public void push(T val){
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia: limite de " + this.limit + " elementos.");
        }
        this.data.add(val);
    }

    public T pop(){
        if(isEmpty()) return null;
        T removed = this.data.remove(this.data.size() - 1);
        this.historyData.add(removed);
        return removed;
    }

    public ArrayList<T> getHistory(){
        return new ArrayList<T>(this.historyData);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    public boolean isFull(){
        return this.data.size() >= this.limit;
    }

    public T peek(){
        if(isEmpty()) return null;
        return this.data.get(this.data.size() - 1);
    }

    public String print(){
        return this.data.toString();
    }
}