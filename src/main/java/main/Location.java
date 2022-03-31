package main;

import java.util.ArrayList;

public class Location {
    public String name;
    public String startingText;
    public ArrayList<Location> NESW;
    public ArrayList<Interactable> interactables;

    public Location(String name, String startingText, ArrayList<Location> NESW) {
        this(name, startingText, NESW, new ArrayList<>());
    }

    public Location(String name, String startingText, ArrayList<Location> NESW, ArrayList<Interactable> interactables) {
        this.name = name;
        this.startingText = startingText;
        this.NESW = NESW;
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

    public void setNESW(ArrayList<Location> NESW){
        this.NESW = NESW;
    }

    public void remove(Interactable i, Location loc){
        loc.interactables.remove(i);
    }
}
