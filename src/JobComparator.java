import java.util.Comparator;

// File: JobComparator.java
// Date: February 22, 2015
// Author: Douglas Manzelmann
// Purpose: The JobComparator compares two Jobs by their ID.

public class JobComparator implements Comparator<Job> {
    public int compare(Job one, Job two) {
        return(Integer.compare(one.getIndex(), two.getIndex()));
    }
}
