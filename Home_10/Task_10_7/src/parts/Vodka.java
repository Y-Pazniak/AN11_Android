package parts;

import base.Drinkable;

public class Vodka extends AlcoDecorator{
    public Vodka(final Drinkable drinkable) {
        super(drinkable, "Vodka", 50);
    }
}
