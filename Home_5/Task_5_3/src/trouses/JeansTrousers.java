package trouses;

public class JeansTrousers implements ITrousers {
    @Override
    public void putOn() {
        System.out.println("Put on a reliable jeans trousers");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a reliable jeans trousers");
    }
}
