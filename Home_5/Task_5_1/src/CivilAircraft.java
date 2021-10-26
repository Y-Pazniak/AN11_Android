public class CivilAircraft extends AirTransport{ //реализация самолетов гражданской авиации - от одномоторных кукурузников до крупных лайнеров
    private final int passengersCount;
    private boolean isBusiness;

    public CivilAircraft(int horsePower, int maxSpeed, int massVehicle, String brand, double wingspan, int minLengthToFly, int passengersCount, boolean isBusiness) {
        super(horsePower, maxSpeed, massVehicle, brand, wingspan, minLengthToFly);
        this.passengersCount = passengersCount;
        this.isBusiness = isBusiness;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(boolean business) {
        isBusiness = business;
    }

    public String description() {
        return String.format("""
                        CivilAircraft horse power is %d,
                        max speed is %d,
                        mass vehicle is %d,
                        brand is %s,
                        wingspan is %.1f,
                        length to takeoff is %d,
                        passengers capacity is %d,
                        is plain have business-class: %b,
                        kW power is: %.2f.""",
                getHorsePower(), getMaxSpeed(), getMassVehicle(), getBrand(), getWingspan(),
                getMinLengthToFly(), getPassengersCount(), isBusiness(), countKW());
    }

    private double countKW() {
        return getHorsePower() * 0.74;
    }

    public void loadThePlain(int passengersCount) {
        System.out.println(passengersCount > getPassengersCount() ? "Вам нужен самолет побольше." : "Самолет загружен.");
        System.out.println("*****");
    }
}
