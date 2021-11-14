import java.io.*;

public class Main {
    public static void main(String[] args) {
        String pathToSave = "D:/car.ser";
        Car volvo = new Car("Volvo", 220, 15000);
        serialize(volvo, pathToSave);
        Car newVolvo = deserialize(pathToSave);
        System.out.println(newVolvo.getBrand());
        System.out.println(newVolvo.getPrice());
        System.out.println(newVolvo.getSpeed());
    }

    public static void serialize(final Car car, final String pathToSave){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToSave))) {
            objectOutputStream.writeObject(car);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static Car deserialize(final String pathToLoad){
        Car car;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToLoad))){
            car = (Car)objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException exc){
            car = null;
            exc.printStackTrace();
        }
        return car;
    }
}
