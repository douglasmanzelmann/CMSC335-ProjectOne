import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

// File: TreasureWeightComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The TreasureWeightComparator compares two Treasures using their weight field.

public class TreasureWeightComparator implements Comparator<Treasure> {
    public int compare(Treasure one, Treasure two) {
        return Double.compare(one.getWeight(), two.getWeight());
    }
}
