import java.util.ArrayList;
import java.util.List;

public class Locations {
    public static Location empty_location = new Location("empty", "", null);
    public static Location cubicle = new Location(Text.CUBICLE_NAME, Text.CUBICLE_STARTING, null, new ArrayList<>(List.of(Interactables.photo)));
    public static Location break_room = new Location(Text.BREAK_ROOM_NAME, Text.BREAK_ROOM_STARTING, null, new ArrayList<>(List.of(Interactables.postcard)));
    public static ArrayList<Location> locations = new ArrayList<>(List.of(cubicle));
    public static void setDirectionalLocations(){
        cubicle.setNESW(new ArrayList<>(List.of(break_room, empty_location, empty_location, empty_location)));
        break_room.setNESW(new ArrayList<>(List.of(empty_location, empty_location, cubicle, empty_location)));
    }
}