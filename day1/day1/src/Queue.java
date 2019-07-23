import java.util.ArrayList;
public class Queue {
    int capacity;
    static int defaultCapacity;
    ArrayList<Integer> queue;
    Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>();
    }
    Queue() {
        this.capacity = defaultCapacity;
        this.queue = new ArrayList<>();
    }
    static int getDefaultCapacity() {
        return defaultCapacity;
    }
    static void setDefaultCapacity(int defaultCapacity) {
        Queue.defaultCapacity = defaultCapacity;
    }
    int getCapacity() {
        return capacity;
    }
    void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    ArrayList<Integer> getQueue() {
        return queue;
    }
    void add(int newElement){
        if(queue.size() < capacity){
            queue.add(newElement);
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    int remove(){
        if(!queue.isEmpty()) {
            int element = queue.get(0);
            queue.remove(0);
            return element;
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    @Override
    public String toString() {
        return "Queue{" +
                "capacity=" + capacity +
                ", queue=" + queue +
                '}';
    }
}