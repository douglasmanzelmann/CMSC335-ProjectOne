import java.util.Comparator;

/**
 * Created by dmanzelmann on 2/6/15.
 */
public class TreasureValueComparator implements Comparator<Treasure> {
    public int compare(Treasure one, Treasure two) {
        return Integer.compare(one.getValue(), two.getValue());
    }
}
