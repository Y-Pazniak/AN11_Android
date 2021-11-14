package parts;

import base.Drinkable;

public class Cream extends AlcoDecorator{
    public Cream(final Drinkable drinkable) {
        super(drinkable, "Cream", 25);
    }
}
