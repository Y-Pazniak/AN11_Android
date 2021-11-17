import base.*;
import parts.*;

public class Main {
    public static void main(String[] args) {
        CoffeeLiquor whiteRussian = new CoffeeLiquor(new Cream(new Vodka(new Ice(new Cocktail("White russian", 0)))));
        Beer yorsh = new Beer(new Vodka(new Cocktail("Yorsh", 0)));

        System.out.println(whiteRussian.getName());
        System.out.println("The price is: " + whiteRussian.getPrice());

        System.out.println(yorsh.getName());
        System.out.println("The price is: " + yorsh.getPrice());
    }
}
