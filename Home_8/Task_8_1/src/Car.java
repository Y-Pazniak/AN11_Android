public class Car {
    private String brand;
    private int speed;
    private int price;

    public Car() {
    }

    public Car(final String brand, final int speed, final int price) {
        this.brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public void startEngine() throws EngineNotStartException {
        if (((int) (Math.random() * 20) % 2) == 0) {
            throw new EngineNotStartException(getBrand() + " failed to start engine.");
        } else {
            System.out.println("Auto " + getBrand() + " engine starts.");
        }
    }
}
