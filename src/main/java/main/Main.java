package main;

import java.util.ArrayList;
import java.util.Scanner;

import helpers.inputManager;
import helpers.promptManager;

public class Main {

    private static Location curLoc = Locations.cubicle;

    private static ArrayList<Interactable> inv = new ArrayList<>();
    private static boolean running = true;

    public static void main(String[] args) {
        Locations.setDirectionalLocations();
        Scanner input = new Scanner(System.in);
        while(running) {
            printLocation(curLoc);
            boolean inputSuccessful = false;
            while(!inputSuccessful){
                inputSuccessful = inputManager(input.nextLine());
            }
        }
    }

    public static void printLocation(Location loc){
        System.out.println("You are at " + loc.name);
        System.out.println(loc.startingText);
        System.out.println(promptManager());
    }

    public static boolean inputManager(String input){
        String[] inputSplit = input.split(" ", 2);
        switch (inputSplit[0]){
            case "north":
            case "n":
                return inputManager.directionManager(0);
            case "east":
            case "e":
                return inputManager.directionManager(1);
            case "south":
            case "s":
                return inputManager.directionManager(2);
            case "west":
            case "w":
                return inputManager.directionManager(3);
            case "analyze":
            case "investigate":
            case "inspect":
                return inputManager.inspectManager(inputSplit);
            case "take":
            case "grab":
            case "pickup":
                return inputManager.takeManager(inputSplit);
            case "inventory":
            case "inv":
                return inputManager.invManager();
            case "location":
            case "loc":
                return true;
            default:
                System.out.println(Text.ERROR);
                return false;
        }
    }

    public static String promptManager(){
        String prompt = "";
        prompt = promptManager.locationPromptHelper(curLoc, prompt);
        prompt = promptManager.locationInteractableHelper(curLoc, prompt);
        return prompt;
    }

    public static String getNESW(int i){
        return switch (i) {
            case 0 -> "north";
            case 1 -> "east";
            case 2 -> "south";
            case 3 -> "west";
            default -> "ERROR";
        };
    }

    public static void setCurLoc(Location curLoc) {
        Main.curLoc = curLoc;
    }

    public static Location getCurLoc() {
        return curLoc;
    }

    public static ArrayList<Interactable> getInv() {
        return inv;
    }
}