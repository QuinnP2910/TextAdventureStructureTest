import java.util.ArrayList;

public class Interactable {
    public String name;
    public String description;
    public ArrayList<String> references;

    public Interactable(String name, String description, ArrayList<String> references) {
        this.name = name;
        this.description = description;
        this.references = references;
    }
}
