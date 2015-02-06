// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: The Artifact class contains attributes for each artifact

public class Artifact extends CaveElement {
    private final int index;
    private String type;
    private int creatureIndex;
    private String name;

    public Artifact(int index, String type, int creatureIndex, String name) {
        this.index = index;
        this.type = type;
        this.creatureIndex = creatureIndex;
        this.name = name;
    }

    public Artifact(int index, String type, int creatureIndex) {
        this(index, type, creatureIndex, "");
    }

    public int getIndex() {
        return index;
    }
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return("a: " + index + " : " + type + " : " + creatureIndex + " : " + name);
    }

}
