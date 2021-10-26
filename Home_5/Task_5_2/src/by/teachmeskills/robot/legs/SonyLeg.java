package by.teachmeskills.robot.legs;

public class SonyLeg implements ILeg{
    private int price;

    public SonyLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("One small step for Sony leg, one giant leap for mankind.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
