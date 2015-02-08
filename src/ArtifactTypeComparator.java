import java.util.Comparator;

/**
 * Created by douga_000 on 2/7/2015.
 */
public class ArtifactTypeComparator implements Comparator<Artifact> {
    public int compare(Artifact one, Artifact two) {
        return (one.getType().compareTo(two.getType()));
    }
}
