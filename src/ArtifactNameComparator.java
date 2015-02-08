import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by douga_000 on 2/7/2015.
 */
public class ArtifactNameComparator implements Comparator<Artifact> {
    public int compare(Artifact one, Artifact two) {
        return one.getName().compareTo(two.getName());
    }

    public static void main(String[] args) {
        Artifact one = new Artifact(1, "old", 1, "zob");
        Artifact two = new Artifact(2, "new", 2, "bob");

        ArrayList<Artifact> test = new ArrayList<>();
        test.add(one);
        test.add(two);

        Collections.sort(test, new ArtifactNameComparator());

        for (Artifact element : test)
            System.out.println(element);
    }
}
