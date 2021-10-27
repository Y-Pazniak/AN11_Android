package jacket;

public class DownJacket implements IJacket{
    @Override
    public void putOn() {
        System.out.println("Put on a warm down jacket");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a warm down jacket");
    }
}
