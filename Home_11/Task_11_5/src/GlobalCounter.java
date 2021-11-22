import java.util.concurrent.atomic.AtomicInteger;

public class GlobalCounter {
    public AtomicInteger count;

    public GlobalCounter() {
        count = new AtomicInteger(0);
    }

    public int getAndIncrement(){
        return count.getAndIncrement();
    }
}
