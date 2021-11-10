import java.io.Serial;
import java.io.Serializable;

public class Car implements Serializable {
    private String brand;
    private int speed;
    private int price;

    @Serial
    private static final long serialVersionUID = 1L;

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
}
