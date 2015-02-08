import java.util.Comparator;

/**
 * Created by douga_000 on 2/7/2015.
 */
public class CreatureCarryingCapacityComparator implements Comparator<Creature> {
    public int compare(Creature one, Creature two) {
        return Integer.compare(one.getCarryingCapacity(), two.getCarryingCapacity());
    }
}
