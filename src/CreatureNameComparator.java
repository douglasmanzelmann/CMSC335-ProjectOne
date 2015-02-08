import java.util.Comparator;

/**
 * Created by douga_000 on 2/7/2015.
 */
public class CreatureNameComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return(one.getName().compareTo(two.getName()));
    }
}
