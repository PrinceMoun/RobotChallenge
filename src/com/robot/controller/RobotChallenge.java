package com.robot.controller;

public class RobotChallenge {

    public static void main(String[] args) {

        System.out.println("\n*******  Robot tabletop game! ****************");

        System.out.println("Available commands (case sensitive) : PLACE (PLACE 0,0,NORTH), LEFT, RIGHT, MOVE, REPORT");

        System.out.println("Available Directions (not case sensitive) : NORTH, SOUTH, EAST, WEST");

        RobotController.loadGame(args);
    }

}