import java.util.Comparator;

// File: CreatureFearComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The CreatureFearComparator compares two Creatures using their fear field.

public class CreatureFearComparator implements Comparator<Creature>{
    public int compare(Creature one, Creature two) {
        return Integer.compare(one.getFear(), two.getFear());
    }
}
