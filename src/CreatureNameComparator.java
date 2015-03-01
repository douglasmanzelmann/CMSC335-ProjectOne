import java.util.Comparator;

// File: CreatureNameComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The CreatureNameComparator compares two Creatures using their name field.

public class CreatureNameComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return(one.getName().compareTo(two.getName()));
    }
}
