import java.util.Comparator;

// File: CreatureCarryingCapacityComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The CreatureCarryingCapacityComparator compares two Creatures using their carrying capacity field.

public class CreatureCarryingCapacityComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return Integer.compare(one.getCarryingCapacity(), two.getCarryingCapacity());
    }
}
