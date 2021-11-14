package parts;

import base.Drinkable;

public class Ice extends AlcoDecorator{
    public Ice(final Drinkable drinkable) {
        super(drinkable, "Ice", 0);
    }
}
