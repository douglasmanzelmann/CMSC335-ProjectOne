import java.util.ArrayList;
import java.util.HashMap;

// File: Cave.java
// Date: January 25, 2015
// Author: Douglas Manzelmann
// Purpose: The highest level data structure for the Sorcerer's Cave game,
//          the Cave class is linked to every piece of data in the game,
//          and provides some higher level search methods for searching

public class Cave {
    private ArrayList<Party> parties;
    private HashMap<Integer, Party> partyKeyValue;

    /**
     * No-arg constructor. Initializes the ArrayList and a HashMap for quick searching.
     */
    public Cave() {
        parties = new ArrayList<Party>();
        partyKeyValue = new HashMap<Integer, Party>();
    }

    /**
     * Add a party to the cave.
     * @param newParty
     */
    public void addParty(Party newParty) {
        parties.add(newParty);
        partyKeyValue.put(newParty.getIndex(), newParty);
    }

    /**
     * Return an iterable of parties.
     * @return
     */
    public Iterable<Party> getParties() {
        return parties;
    }

    /**
     * Search for a party with a specific index
     * @param index
     * @return
     */
    public Party getPartyByID(int index) {
        if (partyKeyValue.containsKey(index))
            return partyKeyValue.get(index);
        return null;
    }

    /**
     * Search every element in the game (parties, creatures, treasures and artifacts)
     * for a unique index.
     * @param index
     * @return The object with that index
     */
    public CaveElement searchByIndex(int index) {
        if (partyKeyValue.containsKey(index)) {
            return partyKeyValue.get(index);
        } else {
            // Perform the analog of a graph search to find an object with the index
            // Each party searches each of its creatures for the index
            // And each creature searches its artifacts and treasures
            // This search is sped up by the fact that each Party
            // and each Creature has a HashMap for its objects using
            // that object and its index
            for (Party party : parties) {
                CaveElement result = party.searchByIndex(index);
                if (result != null)
                    return result;
            }
        }

        return null;
    }

    /**
     * Search all elements for a specific name, since names are not unique
     * @param name
     * @return All elements with this name
     */
    public ArrayList<CaveElement> searchByName(String name) {
        ArrayList<CaveElement> elements = new ArrayList<CaveElement>();

        // Perform a graph search over each element
        for (Party party : parties) {
            // Add all artifacts to the elements list
            for (Creature creature : party.getCreatures()) {
                elements.addAll(creature.searchByName(name));
            }
            if (party.getName().equals(name))
                elements.add(party);
        }

        return elements;
    }

    /**
     * Search all elements for a specific type, since  types are not unique
     * @param type
     * @return
     */
    public ArrayList<CaveElement> searchByType(String type) {
        ArrayList<CaveElement> elements = new ArrayList<CaveElement>();

        // Perform a graph search over each element
        for (Party party : parties) {
            // Add all treasures and artifacts to the list
            for (Creature creature : party.getCreatures()) {
                elements.addAll(creature.searchByType(type));

                if (creature.getType().equals(type))
                    elements.add(creature);
            }
        }

        return elements;
    }

    public String toString() {
        return("Number of parties: " + parties.size());
    }
}
