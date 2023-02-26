package com.robot.service;

import com.robot.constant.Direction;
import com.robot.constant.TableTop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RobotUtility {

    public boolean placeRobot(String command, List<String> inputString, RobotOperations robotOperations) {

        if (Boolean.TRUE.equals(validateCommandParams(command, inputString))) {
            Direction direction;
            try {
                int xCord = Integer.parseInt(inputString.get(0));
                int yCord = Integer.parseInt(inputString.get(1));
                direction = Direction.faces.get(inputString.get(2));
                if (xCord <= TableTop.MAX_WIDTH && yCord <= TableTop.MAX_HEIGHT && Optional.ofNullable(direction).isPresent()) {
                    robotOperations.placeRobot(xCord, yCord, direction);
                    return true;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("The PLACE command params are not valid, " + command);
                return false;
            }
        }
        return false;
    }

    private boolean validateCommandParams(String command, List<String> input) {

        String[] splitCommands = command.split(" ");
        if (splitCommands.length == 2) {
            String[] params = splitCommands[1].split(",");
            if (params.length == 3) {

                String xCor = params[0];
                String yCor = params[1];
                String face = params[2];
                input.addAll(Arrays.asList(xCor, yCor, face));
                return true;
            }
        }
        return false;
    }

}
