package com.robot.model;

public class Coordinates {
    int xCord;
    int yCord;

    public Coordinates(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    Coordinates addCoordinates(Coordinates coordinate) {
        int coordinateX = this.xCord + coordinate.xCord;
        int coordinateY = this.yCord + coordinate.yCord;

        return new Coordinates(coordinateX, coordinateY);
    }

    @Override
    public String toString() {
        return "[" + this.xCord + ", " + this.yCord + "]";
    }
}