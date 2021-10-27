package shoes;

public class FeltBoots implements IShoes {
    @Override
    public void putOn() {
        System.out.println("Put on a warm felt boots");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a warm felt boots");
    }
}
