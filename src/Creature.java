import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: The Creature class contains attributes for each creature
//          and each artifact and treasure that it possesses

public class Creature extends CaveElement implements Runnable {
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
    private ArrayList<Job> jobs;
    private PriorityBlockingQueue<Job> pqJobs;

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
        jobs = new ArrayList<>();
        pqJobs = new PriorityBlockingQueue<>();
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

    /**
     * A method to sort the treasures by their weight field
     */
    public void sortTreasuresByWeight() {
        Collections.sort(treasures, new TreasureWeightComparator());
    }

    /**
     * A method to sort treasures by their value field
     */
    public void sortTreasuresByValue() {
        Collections.sort(treasures, new TreasureValueComparator());
    }

    /**
     * A method to sort Artifacts by their name field.
     */
    public void sortArtifactByName() {
        Collections.sort(artifacts, new ArtifactNameComparator());
    }

    /**
     * A method to sort Artifacts by their type field
     */
    public void sortArtifactsByType() {
        Collections.sort(artifacts, new ArtifactTypeComparator());
    }

    /**
     * Get the fear field
     * @return fear
     */
    public int getFear() {
        return fear;
    }

    /**
     * Set the fear field
     * @param fear The value of the fear field
     */
    public void setFear(int fear) {
        this.fear = fear;
    }

    /**
     * Get the empathy
     * @return the empathy
     */
    public int getEmpathy() {
        return empathy;
    }

    /**
     * Set the empathy
     * @param empathy value of the empathy
     */
    public void setEmpathy(int empathy) {
        this.empathy = empathy;
    }

    /**
     * Get the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name value of the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the type
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type
     * @param type value of the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the carrying capacity
     * @return the carrying capacity
     */
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    /**
     * Set the carrying capacity
     * @param carryingCapacity the value of the carrying capacity
     */
    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    /**
     * Get the weight
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set the weight
     * @param weight value of the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get the height
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height
     * @param height value of the height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get the age
     * @return the age
     */
    public double getAge() {
        return age;
    }

    /**
     * Set the age
     * @param age value of the age
     */
    public void setAge(double age) {
        this.age = age;
    }

    /**
     * Get the idnex
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * The toString method for Creature
     * @return the toString representation
     */

    public void run() {

    }

    public void addJob(Job job) {
        jobs.add(job);
        Thread jobThread = new Thread(job);
        jobThread.start();
    }

    public Iterable<Job> getJobs() {
        return jobs;
    }

    public String toString() {
        return("c: " + index + " : " + type + " : " + name + " : " + empathy + " : " +
                fear + " : " + carryingCapacity + " : " + age + " : " + height +
                " : " + weight);
    }
}