// 22. What is wrong with this code snippet?
//     (string literals are immutable and shared via the VM's String pool,
// so every Stack will use the same lock,
// but the user actually wants to lock on one Stack instance, not
// all instances.
// )
public class Stack {
    private Object myLock = "LOCK"; 

    public void push(Object newValue) {
        synchronized (myLock) {
            ...
        }
    }
    ...
}

23. What is wrong with this code snippet?

public class Stack {
    public void push(Object newValue) {
        synchronized (new ReentrantLock()) {
            ...
        }
    }
    ...
}

24. What is wrong with this code snippet?
Click here to view code image

public class Stack {
    private Object[] values = new Object[10];
    private int size;

    public void push(Object newValue) {
        synchronized (values) {
            if (size == values.length)
                values = Arrays.copyOf(values, 2 * size);
            values[size] = newValue;
            size++;
        }
    }
    ...
}   
