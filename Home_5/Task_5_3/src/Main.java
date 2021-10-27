import jacket.DownJacket;
import jacket.LeatherJacket;
import shoes.CowboyShoes;
import shoes.FeltBoots;
import shoes.SneakersShoes;
import trouses.CargoPantsTrousers;
import trouses.JeansTrousers;

public class Main {
    public static void main(String[] args) {
        Human terminator = new Human(new LeatherJacket(), new CowboyShoes(), new JeansTrousers(), "Terminator T800");
        Human tableDancer = new Human(new LeatherJacket(), new SneakersShoes(), new CargoPantsTrousers(), "Jim the Table Dancer");
        Human fromTheNorth = new Human(new DownJacket(), new FeltBoots(), new CargoPantsTrousers(), "Man from the north");

        terminator.getDressed();
        terminator.undressed();

        tableDancer.undressed();
        tableDancer.getDressed();

        fromTheNorth.getDressed();
        fromTheNorth.undressed();
        fromTheNorth.getDressed();
    }
}
