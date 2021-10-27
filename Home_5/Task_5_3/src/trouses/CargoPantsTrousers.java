package trouses;

public class CargoPantsTrousers implements ITrousers {
    @Override
    public void putOn() {
        System.out.println("Put on a comfortable cargo pants trousers");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a comfortable cargo pants trousers");
    }
}
