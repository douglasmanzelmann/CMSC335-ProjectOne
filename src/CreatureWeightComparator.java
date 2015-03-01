import java.util.Comparator;

// File: CreatureWeightComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The CreatureWeightComparator compares two Creatures using their weight field.

public class CreatureWeightComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return Double.compare(one.getWeight(), two.getWeight());
    }
}
