package shoes;

public class SneakersShoes implements IShoes {
    @Override
    public void putOn() {
        System.out.println("Put on a comfortable sneakers shoes");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a comfortable sneakers shoes");
    }
}
