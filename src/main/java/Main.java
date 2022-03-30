import java.util.Scanner;

public class Main {
    private static Location curLoc = Locations.start;
    private static boolean running = true;

    public static void main(String[] args) {
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
        String[] inputSplit = input.split(" ");
        switch (inputSplit[0]){
            case "north":
            case "n":
                if(curLoc.nesw.get(0).equals("nullN")){
                    System.out.println(Text.DIRECTION_ERROR + "north");
                    return false;
                } else {
                    curLoc = Location.toLocation(curLoc.nesw.get(0));
                    return true;
                }
            case "east":
            case "e":
                if(curLoc.nesw.get(1).equals("nullE")){
                    System.out.println(Text.DIRECTION_ERROR + "east");
                    return false;
                } else {
                    curLoc = Location.toLocation(curLoc.nesw.get(1));
                    return true;
                }
            case "south":
            case "s":
                if(curLoc.nesw.get(2).equals("nullS")){
                    System.out.println(Text.DIRECTION_ERROR + "south");
                    return false;
                } else {
                    curLoc = Location.toLocation(curLoc.nesw.get(2));
                    return true;
                }
            case "west":
            case "w":
                if(curLoc.nesw.get(3).equals("nullW")){
                    System.out.println(Text.DIRECTION_ERROR + "west");
                    return false;
                } else {
                    curLoc = Location.toLocation(curLoc.nesw.get(3));
                    return true;
                }
            case "analyze":
            case "investigate":
            case "inspect":
                if(inputSplit.length == 1){
                    System.out.println(Text.INTERACTABLE_ERROR);
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
                System.out.println(Text.INTERACTABLE_ERROR);
                return false;
            default:
                System.out.println(Text.ERROR);
                return false;
        }
    }

    public static String promptManager(Location loc){
        String prompt = "";
        for(String l : loc.nesw){
            if(!l.startsWith("null")){
                if(prompt.equals("")){
                    prompt = prompt.concat("T");
                } else {
                    prompt = prompt.concat(", t");
                }
                prompt = prompt.concat("o your " + getNESW(loc.nesw.indexOf(l)) + " is " + l);
            }
        }
        prompt = prompt.concat(".");
        if(loc.interactables != null) {
            prompt = prompt.concat(" Around you there is");
            for (Interactable i : loc.interactables) {
                prompt = prompt.concat(" " + i.name);
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