import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> data;
    private int operationCount = 0;

    public Queue() {
        this.data = new ArrayList<T>();
    }

    public void enqueue(T val){
        this.data.add(val);
        this.operationCount++;
    }

    public T dequeue(){
        this.operationCount++;
        if(isEmpty()){
            return null;
        }
        return this.data.remove(0);
    }

    public int getOperationCount(){
        return this.operationCount;
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return this.data.get(0);
    }

    public String print(){
        StringBuilder output = new StringBuilder("[ ");
        for (int i = 0; i < this.data.size(); i++){
            if(output.length() > 2){
                output.append(", ");
            }
            output.append("(")
                    .append(i+1)
                    .append("º): ")
                    .append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}