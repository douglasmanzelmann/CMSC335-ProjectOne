import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dmanzelmann on 2/6/15.
 */
public class TreasureWeightComparator implements Comparator<Treasure> {
    public int compare(Treasure one, Treasure two) {
        double treasureOneWeight = one.getWeight();
        double treasureTwoWeight = two.getWeight();

        return Double.compare(treasureOneWeight, treasureTwoWeight);
    }

    public static void main(String[] args) {
        Treasure one = new Treasure(1, "gold", 1, 35.0, 100);
        Treasure two = new Treasure(2, "silver", 2, 10.0, 50);

        ArrayList<Treasure> test = new ArrayList<Treasure>();
        test.add(one);
        test.add(two);

        Collections.sort(test, new TreasureWeightComparator());

        for (Treasure item : test)
            System.out.println(item);
    }
}
