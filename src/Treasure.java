// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: The Creature class contains attributes for each creature
//          and each artifact and treasure that it possesses

public class Treasure extends CaveElement {
    private final int index;
    private String type;
    private int creatureIndex;
    private double weight;
    private int value;

    /**
     * Constructor
     * @param index Unique ID
     * @param type The type of treasure.
     * @param creatureIndex The index of the Creature to which the Treasure belongs
     * @param weight The weight of the treasure
     * @param value The value of the treasure
     */
    public Treasure(int index, String type, int creatureIndex, double weight, int value) {
        this.index = index;
        this.type = type;
        this.creatureIndex = creatureIndex;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Copy constructor
     * @param treasure the Treasure to copy
     */
    public Treasure (Treasure treasure) {
        this.index = treasure.index;
        this.type = treasure.type;
        this.creatureIndex = treasure.creatureIndex;
        this.weight = treasure.weight;
        this.value = treasure.value;
    }

    /**
     * Get the index of the Treasure
     * @return The index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the value of the Treasure
     * @return The value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the type of the Treasure
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * Get the weight of the Treasure
     * @return The weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * The toString method of the Treasure class
     * @return The string representation of the Treasure class
     */
    public String toString() {
        return("t: " + index + " : " + type + " : " + creatureIndex + " : " +
                weight + " : " + value);
    }

}
