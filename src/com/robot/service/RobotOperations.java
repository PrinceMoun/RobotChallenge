package com.robot.service;

import com.robot.constant.Direction;
import com.robot.model.Coordinates;
import com.robot.model.Robot;

import java.lang.reflect.Method;
import java.util.Map;

public class RobotOperations {

    Robot robot = new Robot();

    public static void initialize(Map<Direction, Coordinates> initialSteps, Map<String, Method> possibleCommands) {
        initialSteps.put(Direction.NORTH, new Coordinates(0, 1));
        initialSteps.put(Direction.EAST, new Coordinates(1, 0));
        initialSteps.put(Direction.WEST, new Coordinates(-1, 0));
        initialSteps.put(Direction.SOUTH, new Coordinates(0, -1));

        try {
            possibleCommands.put("MOVE", RobotOperations.class.getDeclaredMethod(
                    "move"));
            possibleCommands.put("LEFT", RobotOperations.class.getDeclaredMethod(
                    "left"));
            possibleCommands.put("RIGHT", RobotOperations.class.getDeclaredMethod(
                    "right"));
            possibleCommands.put("REPORT", RobotOperations.class.getDeclaredMethod(
                    "report"));
            possibleCommands.put("", RobotOperations.class.getDeclaredMethod("doNothing"));
        } catch (SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void placeRobot(int x, int y, Direction d) {
        robot.placeRobot(new Coordinates(x, y), d);
    }

    public void move() {
        robot.move();
    }

    public void left() {
        robot.turnLeft();
    }

    public void right() {
        robot.turnRight();
    }

    public void report() {
        System.out.println(robot.report());
    }

    public void doNothing() {

    }
}
