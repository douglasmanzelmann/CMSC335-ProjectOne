import java.util.Comparator;

// File: CreatureAgeComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The CreatureAgeComparator compares two Creatures using their age field.

public class CreatureAgeComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return Double.compare(one.getAge(), two.getAge());
    }
}
