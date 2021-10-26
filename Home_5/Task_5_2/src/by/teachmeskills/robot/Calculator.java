package by.teachmeskills.robot;

public class Calculator {
    private int maxPrice;

    public String findMaxPrice(Robot[] robots) { //если 2 или более робота с одинаковой ценой - все равно возвращаем первого
        maxPrice = 0;
        String robotName = null;

        for (Robot robot : robots) {
            int currentPrice = robot.getPrice();
            if (currentPrice > maxPrice) {
                maxPrice = currentPrice;
                robotName = robot.getName();
            }
        }
        return robotName;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
}
