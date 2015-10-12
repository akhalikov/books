package basics.locks;

import java.util.HashMap;
import java.util.Map;

/**
 * Reentrant ReadWriteLock
 *
 * {@see https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReadWriteLock.html}
 */
public class FullyReentrantReadWriteLock implements ReadWriteLock {

    private Map<Thread, Integer> readingThreads = new HashMap();

    private int writeAccesses = 0;
    private int writeRequests = 0;
    private Thread writingThread = null;

    @Override
    public synchronized void lockRead() {
        Thread callingThread = Thread.currentThread();
        while (! canGrantReadAccess(callingThread)) {
            try {
                wait();
            } catch (InterruptedException e) {
                // ...
            }
        }

        readingThreads.put(callingThread, getAccessCount(callingThread) + 1);
    }

    @Override
    public void unlockRead() {
        Thread callingThread = Thread.currentThread();
        if (!isReader(callingThread)) {
            throw new IllegalMonitorStateException("Calling Thread does not" +
                    " hold a read lock on this ReadWriteLock");
        }
        int accessCount = getReadAccessCount(callingThread);
        if (accessCount == 1) {
            readingThreads.remove(callingThread);
        }
        else {
            readingThreads.put(callingThread, accessCount - 1);
        }
        notifyAll();
    }

    @Override
    public void lockWrite() {
        writeRequests++;
        Thread callingThread = Thread.currentThread();
        while (! canGrantWriteAccess(callingThread)) {
            try {
                wait();
            } catch (InterruptedException e) {
                // ...
            }
        }
        writeRequests--;
        writeAccesses++;
        writingThread = callingThread;
    }

    @Override
    public void unlockWrite() {

    }

    private int getReadAccessCount(Thread callingThread){
        Integer accessCount = readingThreads.get(callingThread);
        return (accessCount == null) ? 0: accessCount.intValue();
    }

    private boolean canGrantReadAccess(Thread thread){
        if (isWriter(thread)) return true;
        if (hasWriter()) return false;
        if (isReader(thread)) return true;
        if (hasWriteRequests()) return false;
        return true;
    }

    private boolean canGrantWriteAccess(Thread thread) {
        if (isOnlyReader(thread)) return true;
        if (hasReaders()) return false;
        if (writingThread == null) return true;
        if (!isWriter(thread)) return false;
        return true;
    }

    private boolean hasReaders(){
        return readingThreads.size() > 0;
    }

    private boolean isReader(Thread thread){
        return readingThreads.get(thread) != null;
    }

    private boolean isOnlyReader(Thread callingThread){
        return readingThreads.size() == 1 && readingThreads.get(callingThread) != null;
    }

    private int getAccessCount(Thread thread) {
        Integer accessCount = readingThreads.get(thread);
        return (accessCount == null) ? 0 : accessCount.intValue();
    }

    private boolean hasWriter(){
        return writingThread != null;
    }

    private boolean isWriter(Thread callingThread){
        return writingThread == callingThread;
    }

    private boolean hasWriteRequests(){
        return this.writeRequests > 0;
    }
}
