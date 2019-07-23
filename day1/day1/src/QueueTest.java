import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
public class QueueTest {
    Queue queue ;
    private int capacity = 8;
    @Before
    public void initialize() {
        this.queue = new Queue(capacity);
        Queue.setDefaultCapacity(3);
    }
    @Test
    public void isConstructorWithDefaultCapacity(){
        assertEquals(3, Queue.getDefaultCapacity());
    }
    @Test
    public void canBeConstructorWithGivenCapacity(){
        queue.setCapacity(4);
        assertEquals(4, queue.getCapacity());
    }
    @Test
    public void checkAdd3RemoveOne(){
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        assertEquals(queue.getQueue().toString(), "[2, 3]");
    }
    @Test
    public void checkAddAllRemoveAll(){
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.remove();
        queue.remove();
        assertEquals(queue.getQueue().toString(), "[]");
    }
    @Test
    public void initialCheck(){
        assertEquals(queue.getQueue().toString(),"[]");
    }
    @Test
    public void isConstructedWithDefaultCapacity() {
        assertEquals(Queue.defaultCapacity, new Queue().getDefaultCapacity());
    }
    @Test
    public void canBeConstructedWithSuppliedCapacity() {
        int capacity = 64;
        assertEquals(capacity, new Queue(capacity).getCapacity());
    }
    @Test
    public void acceptsAValueToAdd() {
        queue.add(10);
        assertEquals(10, queue.remove());
    }
    @Test
    public void acceptsMultipleValuesToAdd() {
        for (int v : new int[]{1, 2, 3}) {
            queue.add(v);
        }
        assertEquals(1, queue.remove());
    }
    @Test
    public void removesValuesInTheSameOrderAsAdded() {
        int[] insertedValues = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int v: insertedValues) {
            queue.add(v);
        }
        for (int v: insertedValues) {
            assertEquals(queue.remove(), v);
        }
    }
    @Test
    public void handlesInterspersedRemoves() {
        int[] insertionLot1 = new int[]{1, 2, 3, 4};
        int[] insertionLot2 = new int[]{9, 10, 11, 12, 13, 14, 15};
        for (int v: insertionLot1) {
            queue.add(v);
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(queue.remove(), insertionLot1[i]);
        }
        for (int v: insertionLot2) {
            queue.add(v);
        }
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void throwsExceptionWhenCapacityIsExhausted() {
        for (int v : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) {
            queue.add(v);
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void andSomeStressTesting() {
        int numLoops = 10;
        var randomSource = new Random();
        for (int counter = 0; counter < numLoops; counter++) {
            int removalsCount = 2; randomSource.nextInt(128);
            int capacity = removalsCount * 3;
            int halfRun = capacity / 2;
            Queue q = new Queue(capacity);
            for (int i = 0; i < halfRun; i++) {
                q.add(i);
            }
            for (int i = 0; i < removalsCount; i++) {
                assertEquals(i, q.remove());
            }
            for (int i = halfRun; i < capacity + removalsCount; i++) {
                q.add(i);
            }
            for (int i = removalsCount; i < capacity + removalsCount; i++) {
                int a = q.remove();
                assertEquals(i, a);
            }
            q.remove();
        }
    }
}