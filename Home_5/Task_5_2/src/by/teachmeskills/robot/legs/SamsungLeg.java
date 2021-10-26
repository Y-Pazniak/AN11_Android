package by.teachmeskills.robot.legs;

public class SamsungLeg implements ILeg{
    private int price;

    public SamsungLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("One small step for Samsung leg, one giant leap for mankind.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
