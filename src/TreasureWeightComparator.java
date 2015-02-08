import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dmanzelmann on 2/6/15.
 */
public class TreasureWeightComparator implements Comparator<Treasure> {
    public int compare(Treasure one, Treasure two) {
        return Double.compare(one.getWeight(), two.getWeight());
    }
}
