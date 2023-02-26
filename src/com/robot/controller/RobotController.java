package com.robot.controller;

import com.robot.constant.Direction;
import com.robot.model.Coordinates;
import com.robot.service.RobotOperations;
import com.robot.service.RobotUtility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class RobotController {

    private static final String QUIT = "quit";
    private static final String PLACE = "PLACE";
    public static Map<Direction, Coordinates> initialSteps = new HashMap<>();
    private static final Map<String, Method> commands = new HashMap<>();


    public static void loadGame(String[] args) {

        RobotOperations robotOperations = new RobotOperations();
        RobotOperations.initialize(initialSteps, commands);
        Scanner in = new Scanner(System.in);

        int flag = 0;
        while (true) {
            String command = in.nextLine();
            if (QUIT.equalsIgnoreCase(command)) {
                return;
            }

            if(flag == 0 && commands.containsKey(command)){
                System.out.println("The robot should be placed on the TableTop to begin the game");
                continue;
            }

            if (!commands.containsKey(command) && !command.startsWith(PLACE)) {
                System.out.println("The command is not valid, " + command);
                continue;
            }

            if (command != null && command.trim().toUpperCase().startsWith(PLACE)) {
                flag++;
                List<String> inputString = new ArrayList<>();
                if (Boolean.FALSE.equals(new RobotUtility().placeRobot(command, inputString, robotOperations))) {
                    System.out.println("The PLACE command params are not valid, " + command);
                }
            } else {
                try {
                    commands.get(command).invoke(robotOperations);
                } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
