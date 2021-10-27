package jacket;

public class WindbreakerJacket implements IJacket{
    @Override
    public void putOn() {
        System.out.println("Put on a sports windbreaker");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a sports windbreaker");
    }
}
