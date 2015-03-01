import java.util.Comparator;

// File: CreatureEmpathyComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The CreatureEmpathyComparator compares two Creatures using their empathy field.

public class CreatureEmpathyComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return Integer.compare(one.getEmpathy(), two.getEmpathy());
    }
}
