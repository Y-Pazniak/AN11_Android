package by.teachmeskills.robot.heads;

public class SamsungHead implements IHead{
    private int price;

    public SamsungHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Samsung head speaks");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
