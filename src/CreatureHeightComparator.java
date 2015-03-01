import java.util.Comparator;

// File: CreatureHeightComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The CreatureHeightComparator compares two Creatures using their height field.

public class CreatureHeightComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return Double.compare(one.getHeight(), two.getHeight());
    }
}
