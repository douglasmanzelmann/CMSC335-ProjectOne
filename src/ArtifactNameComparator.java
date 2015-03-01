import java.util.Comparator;

// File: ArtifactNameComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The ArtifactNameComparator compares two Artifacts using their name field.

public class ArtifactNameComparator implements Comparator<Artifact> {
    public int compare(Artifact one, Artifact two) {
        return one.getName().compareTo(two.getName());
    }
}
