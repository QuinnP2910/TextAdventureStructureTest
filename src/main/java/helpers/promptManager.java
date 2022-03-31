package helpers;
import main.Interactable;
import main.Location;
import main.Main;

public class promptManager {
    public static String locationPromptHelper(Location loc, String prompt){
        for(Location l : loc.NESW){
            if(!l.name.equals("empty")){
                if(prompt.equals("")){
                    prompt = prompt.concat("T");
                } else {
                    prompt = prompt.concat(", t");
                }
                prompt = prompt.concat("o your " + Main.getNESW(loc.NESW.indexOf(l)) + " is " + l.name);
            }
        }
        return prompt.concat(".");
    }

    public static String locationInteractableHelper(Location loc, String prompt){
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
            return prompt.concat(".");
        }
        return prompt;
    }
}
