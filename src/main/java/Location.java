import java.util.ArrayList;

public class Location {
    public String name;
    public String startingText;
    public ArrayList<String> nesw;
    public ArrayList<Interactable> interactables;

    public Location(String name, String startingText, ArrayList<String> nesw) {
        this(name, startingText, nesw, null);
    }

    public Location(String name, String startingText, ArrayList<String> nesw, ArrayList<Interactable> interactables) {
        this.name = name;
        this.startingText = startingText;
        this.nesw = nesw;
        this.interactables = interactables;
    }

    public static Location toLocation(String name){
        for(Location l : Locations.locations) {
            if (l.name.equals(name)) {
                return l;
            }
        }
        return null;
    }
}
