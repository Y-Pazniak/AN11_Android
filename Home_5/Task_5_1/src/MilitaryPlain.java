public class MilitaryPlain extends AirTransport{ //реализация военной авиации
    private final boolean isEjectable;
    private int rocketsCount;

    public MilitaryPlain(int horsePower, int maxSpeed, int massVehicle, String brand, double wingspan, int minLengthToFly, boolean isEjectable, int rocketsCount) {
        super(horsePower, maxSpeed, massVehicle, brand, wingspan, minLengthToFly);
        this.isEjectable = isEjectable;
        this.rocketsCount = rocketsCount;
    }

    public boolean isEjectable() {
        return isEjectable;
    }

    public int getRocketsCount() {
        return rocketsCount;
    }

    public void setRocketsCount(int rocketsCount) {
        this.rocketsCount = rocketsCount;
    }

    public String description() {
        return String.format("""
                        MilitaryPlain horse power is %d,
                        max speed is %d,
                        mass vehicle is %d,
                        brand is %s,
                        wingspan is %.1f,
                        length to takeoff is %d,
                        rockets capacity is %d,
                        is plain have eject: %b,
                        kW power is: %.2f.""",
                getHorsePower(), getMaxSpeed(), getMassVehicle(), getBrand(), getWingspan(),
                getMinLengthToFly(), getRocketsCount(), isEjectable(), countKW());
    }

    private double countKW() {
        return getHorsePower() * 0.74;
    }

    public void rocketLaunch(){
        if (rocketsCount > 0){
            System.out.println("Ракета пошла…");
            rocketsCount--;
        } else {
            System.out.println("Ракеты закончились.");
        }
    }

    public void eject(){
        System.out.println(isEjectable() ? "Катапультирование прошло успешно" : "У вас нет такой системы");
        System.out.println("*****");
    }
}
