package by.teachmeskills.robot;

import by.teachmeskills.robot.hands.SamsungHand;
import by.teachmeskills.robot.hands.SonyHand;
import by.teachmeskills.robot.hands.ToshibaHand;
import by.teachmeskills.robot.heads.SamsungHead;
import by.teachmeskills.robot.heads.SonyHead;
import by.teachmeskills.robot.heads.ToshibaHead;
import by.teachmeskills.robot.legs.SamsungLeg;
import by.teachmeskills.robot.legs.ToshibaLeg;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        Robot T800 = new Robot(new SamsungHead(200), new SonyHand(200), new ToshibaLeg(200), "T800"); //судя по количеству конечностей, у нас получился не брутальный Т800, а одноногая форма однорукого бандита
        Robot R2D2 = new Robot(new SonyHead(200), new SamsungHand(200), new SamsungLeg(200), "R2D2");
        Robot Walle = new Robot(new ToshibaHead(200), new ToshibaHand(200), new SamsungLeg(200), "Walle");

        Robot[] robots = {T800, R2D2, Walle};

        for (Robot robot : robots) {
            robot.action();
        }

        Calculator calculator = new Calculator();
        Robot[] expensiveRobots = calculator.findMaxPrice(robots);
        System.out.println("The most expensive robots are: ");
        for (Robot robot: expensiveRobots) {
            if (robot != null){
                System.out.println(robot.getName() + " it's price is: " + robot.getPrice());
            }
        }

        //System.out.println("The most expensive robot is: " + calculator.findMaxPrice(robots) + " it's price is: " + calculator.getMaxPrice());


        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */


    }
}
