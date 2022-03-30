import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Location curLoc = Locations.cubicle;
    private static final ArrayList<Interactable> inv = new ArrayList<>();
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
        System.out.println(promptManager(loc));
    }

    public static boolean inputManager(String input){
        String[] inputSplit = input.split(" ", 2);
        switch (inputSplit[0]){
            case "north":
            case "n":
                if(curLoc.NESW.get(0).name.equals("empty")){
                    System.out.println(Text.DIRECTION_ERROR + "north");
                    return false;
                } else {
                    curLoc = curLoc.NESW.get(0);
                    return true;
                }
            case "east":
            case "e":
                if(curLoc.NESW.get(1).name.equals("empty")){
                    System.out.println(Text.DIRECTION_ERROR + "east");
                    return false;
                } else {
                    curLoc = curLoc.NESW.get(1);
                    return true;
                }
            case "south":
            case "s":
                if(curLoc.NESW.get(2).name.equals("empty")){
                    System.out.println(Text.DIRECTION_ERROR + "south");
                    return false;
                } else {
                    curLoc = curLoc.NESW.get(2);
                    return true;
                }
            case "west":
            case "w":
                if(curLoc.NESW.get(3).name.equals("empty")){
                    System.out.println(Text.DIRECTION_ERROR + "west");
                    return false;
                } else {
                    curLoc = curLoc.NESW.get(3);
                    return true;
                }
            case "analyze":
            case "investigate":
            case "inspect":
                if(inputSplit.length == 1){
                    System.out.println(Text.INTERACTABLE_ERROR_EMPTY);
                    return false;
                }
                for(Interactable i : curLoc.interactables){
                    for(String s : i.references) {
                        if (inputSplit[1].equals(s)) {
                            System.out.println(i.description);
                            return false;
                        }
                    }
                }
                System.out.println(Text.INTERACTABLE_ERROR.concat(inputSplit[1]));
                return false;
            case "take":
            case "grab":
            case "pickup":
                if(inputSplit.length == 1){
                    System.out.println(Text.TAKE_ERROR_EMPTY);
                    return false;
                }
                for(Interactable i : curLoc.interactables){
                    for(String s : i.references) {
                        if (inputSplit[1].equals(s)) {
                            System.out.println(Text.TAKE_SUCCESS.concat(i.name));
                            inv.add(i);
                            curLoc.remove(i, curLoc);
                            return false;
                        }
                    }
                }
                System.out.println(Text.INTERACTABLE_ERROR.concat(inputSplit[1]));
                return false;
            case "inventory":
            case "inv":
                if(inv.isEmpty()){
                    System.out.println(Text.INVENTORY_ERROR_EMPTY);
                }
                for(Interactable i : inv){
                    if(inv.indexOf(i) != inv.size() - 1) {
                        System.out.print(i.name.concat(", "));
                    } else {
                        System.out.println(i.name);
                    }
                }
                return false;
            case "location":
            case "loc":
                return true;
            default:
                System.out.println(Text.ERROR);
                return false;
        }
    }

    public static String promptManager(Location loc){
        String prompt = "";
        for(Location l : loc.NESW){
            if(!l.name.equals("empty")){
                if(prompt.equals("")){
                    prompt = prompt.concat("T");
                } else {
                    prompt = prompt.concat(", t");
                }
                prompt = prompt.concat("o your " + getNESW(loc.NESW.indexOf(l)) + " is " + l.name);
            }
        }
        prompt = prompt.concat(".");
        if(!loc.interactables.isEmpty()) {
            prompt = prompt.concat(" Around you there is");
            for (Interactable i : loc.interactables) {
                prompt = switch (i.toPrint.size()) {
                    case 0 -> prompt.concat(" " + i.name);
                    case 1 -> prompt.concat(" " + i.toPrint.get(0) + i.name);
                    case 2 -> prompt.concat(" " + i.toPrint.get(0) + i.name + i.toPrint.get(1));
                    default -> prompt;
                };
            }
            prompt = prompt.concat(".");
        }
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
}