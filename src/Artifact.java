/**
 * Created by test on 1/24/15.
 */
public class Artifact {
    private static int numberOfArtifacts = 0;
    private final int index;
    private String type;
    private int creatureByIndex;

    public Artifact() {
        index = numberOfArtifacts++;
    }

    public Artifact(String type, int creatureByIndex) {
        index = numberOfArtifacts++;
        this.type = type;
        this.creatureByIndex = creatureByIndex;
    }

    public int getIndex() {
        return index;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCreatureByIndex() {
        return creatureByIndex;
    }

    public void setCreatureByIndex(int creatureByIndex) {
        this.creatureByIndex = creatureByIndex;
    }
}
