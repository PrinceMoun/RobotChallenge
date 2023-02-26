package com.robot.model;

import com.robot.constant.Direction;
import com.robot.constant.TableTop;
import com.robot.controller.RobotController;

import java.util.List;

public class Robot {
    Coordinates coordinates;
    Direction direction;

    public void placeRobot(Coordinates coordinates, Direction direction) {

        if (validatePosition(coordinates)) {
            System.out.println("Invalid PLACE: cannot PLACE robot to these coordinates: "
                    + coordinates);
        } else {
            this.coordinates = coordinates;
            this.direction = direction;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case NORTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.NORTH;
            default -> {
            }
        }
    }

    public void turnRight() {
        switch (direction) {
            case NORTH -> direction = Direction.EAST;
            case WEST -> direction = Direction.NORTH;
            case SOUTH -> direction = Direction.WEST;
            case EAST -> direction = Direction.SOUTH;
            default -> {
            }
        }
    }

    public void move() {
        Coordinates newCoordinates = RobotController.initialSteps.get(this.direction);
        Coordinates newCord = this.coordinates.addCoordinates(newCoordinates);

        if (validatePosition(newCord)) {
            System.out.println("Invalid MOVE : Cannot MOVE robot to these coordinates: "
                    + newCord);
        } else
            this.coordinates = newCord;
    }

    public String report() {
        return "[" + this.coordinates.xCord + ", " + this.coordinates.yCord + ", " + this.direction + "]";
    }

    public boolean validatePosition(Coordinates coordinates) {
        return coordinates.xCord < 0 || coordinates.xCord > TableTop.MAX_WIDTH
                || coordinates.yCord < 0 || coordinates.yCord > TableTop.MAX_HEIGHT;
    }

}
