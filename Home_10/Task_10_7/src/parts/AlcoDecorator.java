package parts;

import base.Drinkable;

public class AlcoDecorator implements Drinkable {
    private final Drinkable drinkable;
    private final String name;
    private final int price;

    public AlcoDecorator(final Drinkable drinkable, final String name, final int price) {
        this.drinkable = drinkable;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return drinkable.getName()   + " with " + name;
    }

    @Override
    public int getPrice() {
        return drinkable.getPrice() + price;
    }
}
