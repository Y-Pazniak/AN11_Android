package parts;

import base.Drinkable;

public class CoffeeLiquor extends AlcoDecorator{
    public CoffeeLiquor(final Drinkable drinkable) {
        super(drinkable, "Kalua", 100);
    }
}
