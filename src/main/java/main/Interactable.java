package main;

import java.util.ArrayList;

public class Interactable {
    public String name;
    public String description;
    public ArrayList<String> references;
    public ArrayList<String> toPrint;

    public Interactable(String name, String description, ArrayList<String> references, ArrayList<String> toPrint) {
        this.name = name;
        this.description = description;
        this.references = references;
        this.toPrint = toPrint;
    }
}
