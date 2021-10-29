public class Main {
    public static void main(String[] args) {
        Greeter czech = new Greeter() {
            @Override
            public void wish() {
                System.out.println("Ahoj, kamaráde!");
            }
        };

        Greeter poland = new Greeter() {
            @Override
            public void wish() {
                System.out.println("Witaj, przyjacielu!");
            }
        };

        Greeter belarusian = new Greeter() {
            @Override
            public void wish() {
                System.out.println("Вітаю, дружа!");
            }
        };

        czech.wish();
        poland.wish();
        belarusian.wish();
    }
}