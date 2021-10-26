public abstract class AirTransport extends Transport{
    private final double wingspan;
    private final int minLengthToFly;

    public AirTransport(int horsePower, int maxSpeed, int massVehicle, String brand, double wingspan, int minLengthToFly) {
        super(horsePower, maxSpeed, massVehicle, brand);
        this.wingspan = wingspan;
        this.minLengthToFly = minLengthToFly;
    }

    public double getWingspan() {
        return wingspan;
    }

    public int getMinLengthToFly() {
        return minLengthToFly;
    }
}
