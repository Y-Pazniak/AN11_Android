package parts;

import base.Drinkable;

public class Beer extends AlcoDecorator{
    public Beer(final Drinkable drinkable) {
        super(drinkable, "Beer", 25);
    }
}
