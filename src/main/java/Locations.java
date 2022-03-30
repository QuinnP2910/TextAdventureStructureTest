import java.util.ArrayList;
import java.util.List;

public class Locations {
    public static Location start = new Location(Text.CUBICLE_NAME, Text.CUBICLE_STARTING, new ArrayList<String>(List.of("nullN", "nullE", "nullS", "nullW")), new ArrayList<Interactable>(List.of(Interactables.photo)));
    public static ArrayList<Location> locations = new ArrayList<Location>(List.of(start));
}