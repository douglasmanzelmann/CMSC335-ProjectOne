// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: The Artifact class contains attributes for each artifact

public class Artifact extends CaveElement {
    private final int index;
    private String type;
    private int creatureIndex;
    private String name;

    /**
     * Constructor
     * @param index Unique id
     * @param type The type of artifact
     * @param creatureIndex The index of the Creature the artifact belongs
     * @param name The name of the artifact
     */
    public Artifact(int index, String type, int creatureIndex, String name) {
        this.index = index;
        this.type = type;
        this.creatureIndex = creatureIndex;
        this.name = name;
    }

    /**
     * A constructor without the name parameter
     * @param index
     * @param type
     * @param creatureIndex
     */
    public Artifact(int index, String type, int creatureIndex) {
        this(index, type, creatureIndex, "");
    }

    /**
     * Copy constructor
     * @param artifact The artifact to copy
     */
    public Artifact(Artifact artifact) {
        this.index = artifact.index;
        this.type = artifact.type;
        this.creatureIndex = artifact.creatureIndex;
        this.name = artifact.name;
    }

    /**
     * Get the index of the artifact
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the type of the artifact
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Get the name of the artifact
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * The toString method for Artifact
     * @return the string representation
     */
    public String toString() {
        return("a: " + index + " : " + type + " : " + creatureIndex + " : " + name);
    }

}
