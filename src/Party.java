import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: Contains every party for the Sorcerer's Cave game
//          each party contains creatures, which have treasures and
//          artifacts


public class Party extends CaveElement{
    private final int index;
    private String name;
    private ArrayList<Creature> creatures;
    private HashMap<Integer, Creature> creaturesKeyValue;

    /**
     * Contructors which receives an index and name.
     * Also intializes the ArrayList and HashMap.
     * @param index
     * @param name
     */
    public Party(int index, String name) {
        this.index = index;
        this.name = name;
        creatures = new ArrayList<Creature>();
        creaturesKeyValue = new HashMap<Integer, Creature>();
    }

    /**
     * Add a creature to the party
     * @param creature
     */
    public void addCreature(Creature creature) {
        creatures.add(creature);
        creaturesKeyValue.put(creature.getIndex(), creature);
    }

    /**
     * Get a creature by index. Sped up by the fact that
     * each creature and its index is stored in a HashMap
     * @param index
     * @return
     */
    public Creature getCreatureByID(int index) {
        if (creaturesKeyValue.containsKey(index))
            return creaturesKeyValue.get(index);

        return null;
    }

    /**
     * Search every creature for a specific index. Each creature
     * then searches its artifacts and treasures for an item with
     * this index
     * @param index
     * @return
     */
    public CaveElement searchByIndex(int index) {
        if (creaturesKeyValue.containsKey(index)) {
            return creaturesKeyValue.get(index);
        }
        else {
            for(Creature creature : creatures) {
                CaveElement result = creature.searchByIndex(index);
                if (result != null)
                    return result;
            }
        }

        return null;
    }

    public void creatureSortByName() {
        Collections.sort(creatures, new CreatureNameComparator());
    }

    public void creatureSortByAge() {
        Collections.sort(creatures, new CreatureAgeComparator());
    }

    public void creatureSortByHeight() {
        Collections.sort(creatures, new CreatureHeightComparator());
    }

    public void creatureSortByWeight() {
        Collections.sort(creatures, new CreatureWeightComparator());
    }

    public void creatureSortByEmpathy() {
        Collections.sort(creatures, new CreatureEmpathyComparator());
    }

    public void creatureSortByFear() {
        Collections.sort(creatures, new CreatureFearComparator());
    }

    public void creatureSortByCarryingCapacity() {
        Collections.sort(creatures, new CreatureCarryingCapacityComparator());
    }

    /**
     * Return the party's index
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * Return an iterable of all the party's creatures
     * @return
     */
    public Iterable<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Return the party's name
      * @return
     */
    public String getName() {
        return name;
    }

    /**
     * toString implementation
     * @return
     */
    public String toString() {
        return("p: " + index + " Name: " + name);
    }
}
