package base;

public class Cocktail implements Drinkable{
    private final String name;
    private final int price;

    public Cocktail(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
