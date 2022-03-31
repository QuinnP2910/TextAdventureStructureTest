package helpers;

import main.Interactable;
import main.Main;
import main.Text;

public class inputManager {
    public static boolean directionManager(int direction){
        if(Main.getCurLoc().NESW.get(direction).name.equals("empty")){
            System.out.println(Text.DIRECTION_ERROR + Main.getNESW(direction));
            return false;
        } else {
            Main.setCurLoc(Main.getCurLoc().NESW.get(direction));
            return true;
        }
    }

    public static boolean inspectManager(String[] input){
        if(input.length == 1){
            System.out.println(Text.INTERACTABLE_ERROR_EMPTY);
            return false;
        }
        for(Interactable i : Main.getCurLoc().interactables){
            for(String s : i.references) {
                if (input[1].equals(s)) {
                    System.out.println(i.description);
                    return false;
                }
            }
        }
        System.out.println(Text.INTERACTABLE_ERROR.concat(input[1]));
        return false;
    }

    public static boolean takeManager(String[] input){
        if(input.length == 1){
            System.out.println(Text.TAKE_ERROR_EMPTY);
            return false;
        }
        for(Interactable i : Main.getCurLoc().interactables){
            for(String s : i.references) {
                if (input[1].equals(s)) {
                    System.out.println(Text.TAKE_SUCCESS.concat(i.name));
                    Main.getInv().add(i);
                    Main.getCurLoc().remove(i, Main.getCurLoc());
                    return false;
                }
            }
        }
        System.out.println(Text.INTERACTABLE_ERROR.concat(input[1]));
        return false;
    }

    public static boolean invManager(){
        if(Main.getInv().isEmpty()){
            System.out.println(Text.INVENTORY_ERROR_EMPTY);
        }
        for(Interactable i : Main.getInv()){
            if(Main.getInv().indexOf(i) != Main.getInv().size() - 1) {
                System.out.print(i.name.concat(", "));
            } else {
                System.out.println(i.name);
            }
        }
        return false;
    }
}
