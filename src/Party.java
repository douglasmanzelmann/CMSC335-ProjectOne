import java.util.ArrayList;

/**
 * Created by test on 1/24/15.
 */
public class Party {
    private static int numberOfParties = 0;
    private final int index;
    private String name;
    ArrayList<Creature> creatures;

    public Party() {
        index = numberOfParties++;
    }

}
