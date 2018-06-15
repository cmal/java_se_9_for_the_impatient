package ch05.ex;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantAutoCloseLock extends ReentrantLock {

    public class AutoCloseableLock implements AutoCloseable {
        public void close() {
            try {
                ReentrantAutoCloseLock.super.unlock();
            } catch (IllegalMonitorStateException e) {
                e.printStackTrace();
            }
        }
    }

    public AutoCloseable helper() {
        super.lock();
        AutoCloseable a = new AutoCloseableLock();
        return a;
    }

}
