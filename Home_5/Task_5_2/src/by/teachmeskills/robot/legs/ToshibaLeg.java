package by.teachmeskills.robot.legs;

public class ToshibaLeg implements ILeg{
    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("One small step for Toshiba leg, one giant leap for mankind.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
