package shoes;

public class CowboyShoes implements IShoes {
    @Override
    public void putOn() {
        System.out.println("Put on a cool cowboy shoes");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a cool cowboy shoes");
    }
}
