package jacket;

public class LeatherJacket implements IJacket{
    @Override
    public void putOn() {
        System.out.println("Put on a cool leather jacket");
    }

    @Override
    public void takeOff() {
        System.out.println("Take off a cool leather jacket");
    }
}
