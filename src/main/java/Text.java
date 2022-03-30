import java.util.ArrayList;
import java.util.List;

public class Text {
    //Locations
    //Cubicle
    public static final String CUBICLE_NAME = "your Cubicle";
    public static final String CUBICLE_STARTING = "You sit at your desk, letting the light from the computer screen in front of you penetrate your tired eyes. You need a break.";
    public static final String CUBICLE_LOCATIONS = "nullN, nullE, nullS, nullW";
    //Interactables
    //Photo
    public static final String PHOTOGRAPH_NAME = "a photograph";
    public static final ArrayList<String> PHOTOGRAPH_REFERENCES = new ArrayList<String>(List.of("photo", "photograph"));
    public static final String PHOTOGRAPH_DESCRIPTION = "It's a photograph of some trees you took years ago.";
    //Errors
    public static final String DIRECTION_ERROR = "There is nothing to your ";
    public static final String INTERACTABLE_ERROR = "There are no interactables with that name";
    public static final String ERROR = "what";
}
