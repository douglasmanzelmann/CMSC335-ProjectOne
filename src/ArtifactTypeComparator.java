import java.util.Comparator;

// File: ArtifactTypeComparator.java
// Date: February 07, 2015
// Author: Douglas Manzelmann
// Purpose: The ArtifactTypeComparator compares two Artifacts using their type field.

public class ArtifactTypeComparator implements Comparator<Artifact> {
    public int compare(Artifact one, Artifact two) {
        return (one.getType().compareTo(two.getType()));
    }
}
