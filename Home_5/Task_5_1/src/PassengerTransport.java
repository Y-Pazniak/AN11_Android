public class PassengerTransport extends LandTransport {//класс для создания конкретных объектов транспорта - легковых машин, автобусов и прочего
    private final String carBody;
    private int passengersCount;

    public PassengerTransport(int horsePower, int maxSpeed, int massVehicle, String brand, int wheelsCount, int fuelConsumption, String carBody, int passengersCount) {
        super(horsePower, maxSpeed, massVehicle, brand, wheelsCount, fuelConsumption);
        this.carBody = carBody;
        this.passengersCount = passengersCount;
    }

    public String getCarBody() {
        return carBody;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public String description() {
        return String.format("""
                        PassengerTransport horse power is %d,
                        max speed is %d,
                        mass vehicle is %d,
                        brand is %s,
                        wheels count is %d,
                        fuel consumption is %s,
                        car body is %s,
                        passengers count is %d,
                        kW power is %.2f.""",
                getHorsePower(), getMaxSpeed(), getMassVehicle(), getBrand(), getWheelsCount(),
                getFuelConsumption(), getCarBody(), getPassengersCount(), countKW());
    }

    private double countKW() {
        return getHorsePower() * 0.74;
    }

    public void countLength(double time) {
        System.out.printf("За время %.1f ч автомобиль %s, двигаясь с максимальной скоростью %d км/ч, проедет %.1f км и израсходует %.1f литров топлива.\n*****\n",
                time, getBrand(), getMaxSpeed(), time * getMaxSpeed(), countFuelConsumption(time));
    }

    private double countFuelConsumption(double time) {
        return time * (getMaxSpeed()/100) * getFuelConsumption();
    }
}
