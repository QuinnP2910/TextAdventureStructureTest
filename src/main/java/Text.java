import java.util.ArrayList;
import java.util.List;

public class Text {
    //Locations
    //Cubicle
    public static final String CUBICLE_NAME = "your Cubicle";
    public static final String CUBICLE_STARTING = "You sit at your desk, letting the light from the computer screen in front of you penetrate your tired eyes. You need a break.";
    //Break Room
    public static final String BREAK_ROOM_NAME = "the break room";
    public static final String BREAK_ROOM_STARTING = "Fluorescent lights give this room a sterile glow. It doesn't feel like much of a rest. You want to leave.";
    //Interactables
    //Photo
    public static final String PHOTOGRAPH_NAME = "a photograph";
    public static final ArrayList<String> PHOTOGRAPH_REFERENCES = new ArrayList<>(List.of("photo", "photograph"));
    public static final String PHOTOGRAPH_DESCRIPTION = "It's a photograph of some trees you took years ago.";
    //Postcard
    public static final String POSTCARD_NAME = "a postcard, hanging by a magnet to the fridge";
    public static final ArrayList<String> POSTCARD_REFERENCES = new ArrayList<>(List.of("postcard", "card"));
    public static final String POSTCARD_DESCRIPTION = "On the postcard you see a forest. Its magnificence and color make it stand out from the rest of the room. Across the top it reads 'Canopy Heart Forest'. To you, it looks like a breath of fresh air.";

    //Errors
    public static final String DIRECTION_ERROR = "There is nothing to your ";
    public static final String INTERACTABLE_ERROR = "There are no interactables with that name";
    public static final String ERROR = "what";
}
