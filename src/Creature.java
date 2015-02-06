import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: The Creature class contains attributes for each creature
//          and each artifact and treasure that it possesses

public class Creature extends CaveElement {
    private final int index;
    private String type;
    private String name;
    private int partyID;
    private int empathy;
    private int fear;
    private int carryingCapacity;
    private double age;
    private double height;
    private double weight;
    private ArrayList<Treasure> treasures;
    private HashMap<Integer, Treasure> treasuresKeyValue;
    private ArrayList<Artifact> artifacts;
    private HashMap<Integer, Artifact> artifactsKeyValue;

    /**
     * The complete constructor containing every possible attribute
     * @param index
     * @param type
     * @param name
     * @param partyID
     * @param empathy
     * @param fear
     * @param carryingCapacity
     * @param age
     * @param height
     * @param weight
     */
    public Creature(int index, String type, String name, int partyID,
                    int empathy, int fear, int carryingCapacity,
                    double age, double height, double weight) {
        this.index = index;
        this.type = type;
        this.name = name;
        this.partyID = partyID;
        this.empathy = empathy;
        this.fear = fear;
        this.carryingCapacity = carryingCapacity;
        this.age = age;
        this.height = height;
        this.weight = weight;

        treasures = new ArrayList<Treasure>();
        treasuresKeyValue = new HashMap<Integer, Treasure>();
        artifacts = new ArrayList<Artifact>();
        artifactsKeyValue = new HashMap<Integer, Artifact>();
    }

    /**
     * A constructor for creatures which do not have optional attributes
     * @param index
     * @param type
     * @param name
     * @param partyID
     * @param empathy
     * @param fear
     * @param carryingCapacity
     */
    public Creature(int index, String type, String name, int partyID,
                    int empathy, int fear, int carryingCapacity) {
        this(index, type, name, partyID, empathy, fear, carryingCapacity, 0, 0, 0);
    }


    /**
     * Searches for either a treasure or artifact by index
     * using the HashMaps
     * @param index
     * @return
     */
    public CaveElement searchByIndex(int index) {
        if (treasuresKeyValue.containsKey(index)) {
            return treasuresKeyValue.get(index);
        }
        else if (artifactsKeyValue.containsKey(index)) {
            return artifactsKeyValue.get(index);
        }

        return null;
    }

    /**
     * Search for a treasure and/or an artifact by name
     * @param name
     * @return
     */
    public ArrayList<CaveElement> searchByName(String name) {
        ArrayList<CaveElement> elements = new ArrayList<CaveElement>();
        for (Artifact artifact : artifacts) {
            if (artifact.getName().equals(name))
                elements.add(artifact);
        }

        return elements;
    }

    /**
     * Search for a treasure and/or an artifact by type
     * @param type
     * @return
     */
    public ArrayList<CaveElement> searchByType(String type) {
        ArrayList<CaveElement> elements = new ArrayList<CaveElement>();

        for (Artifact artifact : artifacts) {
            if (artifact.getType().equals(type))
                elements.add(artifact);
        }

        for (Treasure treasure : treasures) {
            if (treasure.getType().equals(type))
                elements.add(treasure);
        }

        return elements;
    }

    /**
     * Return an iterable of all the artifacts
     * @return
     */
    public Iterable<Artifact> getArtifacts() {
        return artifacts;
    }

    /**
     * Add an artifact to a creature
     * @param artifact
     */
    public void addArtifact(Artifact artifact) {
        artifacts.add(artifact);
        artifactsKeyValue.put(artifact.getIndex(), artifact);
    }

    /**
     * Return an iterable of all the treasures
     * @return
     */
    public Iterable<Treasure> getTreasures() {
        return treasures;
    }

    /**
     * Add a treasure to a creature
     * @param treasure
     */
    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
        treasuresKeyValue.put(treasure.getIndex(), treasure);
    }

    private ArrayList<Treasure> cloneTreasures(ArrayList<Treasure> treasuresToClone) {
        ArrayList<Treasure> clonedTreasureList = new ArrayList<Treasure>();

        for (Treasure treasure : treasuresToClone)
            clonedTreasureList.add(new Treasure(treasure));

        return clonedTreasureList;
    }

    public ArrayList<Treasure> sortTreasuresByWeight() {
        ArrayList<Treasure> treasuresSortedByWeight = cloneTreasures(treasures);
        Collections.sort(treasuresSortedByWeight, new TreasureWeightComparator());

        return treasuresSortedByWeight;
    }

    //public ArrayList<Treasure> sortTreasuresByValue() {

    //}


    public int getFear() {
        return fear;
    }

    public void setFear(int value) {
        this.fear = fear;
    }

    public int getEmpathy() {
        return empathy;
    }

    public void setEmpathy(int empathy) {
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

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return("c: " + index + " : " + type + " : " + name + " : " + empathy + " : " +
                fear + " : " + carryingCapacity + " : " + age + " : " + height +
                " : " + weight);
    }
}