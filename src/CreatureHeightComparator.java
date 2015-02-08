import java.util.Comparator;

/**
 * Created by douga_000 on 2/7/2015.
 */
public class CreatureHeightComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return Double.compare(one.getHeight(), two.getHeight());
    }
}