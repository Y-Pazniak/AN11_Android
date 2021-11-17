public class Global {
    int count = 0;

    public synchronized void increaseSec() {
        count++;
        notifyAll();
    }

    public synchronized int getSec() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}
