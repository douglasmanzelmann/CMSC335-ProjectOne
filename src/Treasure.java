// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: The Creature class contains attributes for each creature
//          and each artifact and treasure that it possesses

import java.util.ArrayList;
import java.util.Comparator;

public class Treasure extends CaveElement {
    private final int index;
    private String type;
    private int creatureIndex;
    private double weight;
    private int value;

    public Treasure(int index, String type, int creatureIndex, double weight, int value) {
        this.index = index;
        this.type = type;
        this.creatureIndex = creatureIndex;
        this.weight = weight;
        this.value = value;
    }

    //copy constructor
    public Treasure (Treasure treasure) {
        this.index = treasure.index;
        this.type = treasure.type;
        this.creatureIndex = treasure.creatureIndex;
        this.weight = treasure.weight;
        this.value = treasure.value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return("t: " + index + " : " + type + " : " + creatureIndex + " : " +
                weight + " : " + value);
    }

}
