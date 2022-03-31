package main;

import java.util.ArrayList;
import java.util.List;

public class Text {
    //main.Locations
    //Cubicle
    public static final String CUBICLE_NAME = "your cubicle";
    public static final String CUBICLE_STARTING = "You sit at your desk, letting the light from the computer screen in front of you penetrate your tired eyes. You need a break.";
    //Break Room
    public static final String BREAK_ROOM_NAME = "the break room";
    public static final String BREAK_ROOM_STARTING = "Fluorescent lights give this room a sterile glow. It doesn't feel like much of a break. You want to leave.";
    //main.Interactables
    //Photo
    public static final String PHOTOGRAPH_NAME = "photograph";
    public static final ArrayList<String> PHOTOGRAPH_PRINT = new ArrayList<>(List.of("a "));
    public static final ArrayList<String> PHOTOGRAPH_REFERENCES = new ArrayList<>(List.of("photo", "photograph", "photo graph"));
    public static final String PHOTOGRAPH_DESCRIPTION = "It's a photograph of some trees you took years ago.";
    //Postcard
    public static final String POSTCARD_NAME = "postcard";
    public static final ArrayList<String> POSTCARD_PRINT = new ArrayList<>(List.of("a ", ", hanging by a magnet to the fridge"));
    public static final ArrayList<String> POSTCARD_REFERENCES = new ArrayList<>(List.of("postcard", "card"));
    public static final String POSTCARD_DESCRIPTION = "On the postcard you see a forest. Its magnificence and color make it stand out from the rest of the room. Across the top it reads 'Canopy Heart Forest'. To you, it looks like a breath of fresh air.";
    //Take
    public static final String TAKE_SUCCESS = "You open your backpack and throw in the ";
    //Errors
    public static final String TAKE_ERROR_EMPTY = "Please provide an object to take";
    public static final String DIRECTION_ERROR = "There is nothing to your ";
    public static final String INTERACTABLE_ERROR = "There are no interactables with the name ";
    public static final String INTERACTABLE_ERROR_EMPTY = "Please provide an object to inspect";
    public static final String INVENTORY_ERROR_EMPTY = "YOu have nothing in your inventory";
    public static final String ERROR = "what";
}
