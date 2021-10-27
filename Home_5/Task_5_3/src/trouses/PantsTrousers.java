package trouses;

public class PantsTrousers implements ITrousers {
    @Override
    public void putOn() {
        System.out.println("Put on a solid pants trousers");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a solid pants trousers");
    }
}
