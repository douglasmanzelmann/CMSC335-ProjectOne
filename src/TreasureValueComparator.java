import java.util.Comparator;

// File: TreasureValueComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The TreasureValueComparator compares two Treasures using their value field.

public class TreasureValueComparator implements Comparator<Treasure> {
    public int compare(Treasure one, Treasure two) {
        return Integer.compare(one.getValue(), two.getValue());
    }
}
