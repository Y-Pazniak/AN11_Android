public class Main {
    public static void main(String[] args) {
        PassengerTransport passengerTransport = new PassengerTransport(170, 200,
                2200, "Volvo", 4, 12, "sedan", 5);
        System.out.println(passengerTransport.description());
        passengerTransport.countLength(2.1111);

        CargoTransport cargoTransport = new CargoTransport(440, 124,
                60000, "Scania", 6, 32, 44000);
        System.out.println(cargoTransport.description());
        cargoTransport.loadTheTruck(100);
        cargoTransport.loadTheTruck(44001);

        CivilAircraft civilAircraft = new CivilAircraft(175000, 955,
                166881, "Boeing", 65, 3700, 550, true);
        System.out.println(civilAircraft.description());
        civilAircraft.loadThePlain(400);
        civilAircraft.loadThePlain(600);

        MilitaryPlain militaryPlain = new MilitaryPlain(10000, 2000, 15000, "F16", 9.5, 2500, true, 6);
        System.out.println(militaryPlain.description());
        for (int i = 0; i < 7; i++) {
            militaryPlain.rocketLaunch();
        }
        militaryPlain.eject();
    }
}
