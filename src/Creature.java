import java.util.ArrayList;

/**
 * Created by test on 1/24/15.
 */
public class Creature {
    private static int numberOfCreatures = 0;
    private final int index;
    private String type;
    private String name;
    private double empathy;
    private double value;
    ArrayList<Treasure> treasures;
    ArrayList<Artifact> artifacts;

    public Creature() {
        index = numberOfCreatures++;
    }

    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(ArrayList<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getEmpathy() {
        return empathy;
    }

    public void setEmpathy(double empathy) {
        this.empathy = empathy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
