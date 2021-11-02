package by.teachmeskills.robot;

public class Calculator {
    private int maxPrice;

    public Robot[] findMaxPrice(Robot[] robots) {
        maxPrice = 0;
        int count = 0;
        Robot[] expensiveRobots = new Robot[robots.length];

        for (Robot robot : robots) {
            int currentPrice = robot.getPrice();
            if (currentPrice > maxPrice) {
                maxPrice = currentPrice;
            }
        }
        for (Robot robot : robots) {
            if (robot.getPrice() == maxPrice) {
                expensiveRobots[count] = robot;
                count++;
            }
        }
        return expensiveRobots;
    }
}