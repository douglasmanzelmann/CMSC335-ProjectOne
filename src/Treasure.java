/**
 * Created by test on 1/24/15.
 */
public class Treasure {
    private static int numberOfTreasures = 0;
    private final int index;
    private String type;
    private int creatureByIndex;
    private int weight;
    private int value;

    public Treasure() {
        index = numberOfTreasures++;
    }

    public Treasure(String type, int weight, int value) {
        index = numberOfTreasures++;
        this.weight = weight;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCreatureByIndex() {
        return creatureByIndex;
    }

    public void setCreatureByIndex(int creatureByIndex) {
        this.creatureByIndex = creatureByIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
