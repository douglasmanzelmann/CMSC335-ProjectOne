import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// File : SorcerersCave.java
// Date January 25, 2015
// Author: Douglas Manzelmann
// Purpose: Demonstrate the development of a project: the Sorcerer's Cave project

public class SorcerersCave extends JFrame implements ActionListener {
    private Cave cave;
    private JLabel title;
    private JButton openButton;
    private JFileChooser fc;
    private Scanner dataFile;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea internalDataStructure;
    private JScrollPane scrollPane;
    JComboBox<String> jcb = new JComboBox<String>();


    public static void main(String[] args) {
        SorcerersCave sc = new SorcerersCave();
    }

    public SorcerersCave() {
        pack();
        setLocationRelativeTo(null);
        setTitle("Sorcerer's Cave");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new FlowLayout());
        cave = new Cave();

        title = new JLabel("Sorcerer's Cave");
        fc = new JFileChooser(new File("."));
        openButton = new JButton("Open Data File");
        openButton.addActionListener(this);

        searchLabel = new JLabel();
        searchButton = new JButton("Search");
        searchField = new JTextField(10);
        searchButton.addActionListener(this);

        internalDataStructure = new JTextArea();
        internalDataStructure.setRows(10);
        internalDataStructure.setColumns(50);
        internalDataStructure.setText("Sorcerer's Guild: \n");

        scrollPane = new JScrollPane(internalDataStructure);

        jcb.addItem("Index");
        jcb.addItem("Type");
        jcb.addItem("Name");

        JPanel jp = new JPanel();
        jp.add(openButton);
        jp.add(searchLabel);
        jp.add(searchField);
        jp.add(jcb);
        jp.add(searchButton);

        add(jp, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);

        validate();
    }

    /**
     * An Event listener method which listens for two button clicks,
     * openButton and searchButton
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) { // if the user is opening a data file
            int option = fc.showOpenDialog(SorcerersCave.this);

            try {
                if (option == JFileChooser.APPROVE_OPTION) {
                    dataFile = new Scanner(fc.getSelectedFile());
                    initGameState(dataFile);
                    displayInternalDataStructures();
                }
            } catch (FileNotFoundException o) {

            }
        }

        if (e.getSource() == searchButton) { // if the user is search the data
            if (jcb.getSelectedItem().equals("Index")) { // the user is searching for an index
                int index = Integer.parseInt(searchField.getText());
                CaveElement result = cave.searchByIndex(index);

                if (result == null)
                    internalDataStructure.append("Index: " + index + " does not exist");
                else {
                    internalDataStructure.append(result.toString() + "\n");
                }
            }

            if (jcb.getSelectedItem().equals("Name")) { // the user is searching for a name
                // the method searchByName for the Cave class searches all the appropriate
                // classes for the text entered in the searchField
                ArrayList<CaveElement> elements = cave.searchByName(searchField.getText());
                for (CaveElement c : elements) {
                    internalDataStructure.append(c.toString() + "\n");
                }
            }

            if (jcb.getSelectedItem().equals("Type")) { // the user is searching for a type
                // the method searchByType for the Cave class searches all the appropriate
                // classes for the text entered in the searchField
                ArrayList<CaveElement> elements = cave.searchByType(searchField.getText());
                for (CaveElement c : elements) {
                    internalDataStructure.append(c.toString() + "\n");
                }
            }
        }
    }

    /**
     * Loads the data file that the user selected, and populates the data structures
     * in each respective class.
     * @param input
     */
    public void initGameState(Scanner input) {
        while (input.hasNextLine()) {
            String currentLine = input.nextLine();

            // If the current line is a comment or blank, skip it.
            if (currentLine.startsWith("//") || currentLine.length() == 0) {
                continue;
            }

            // Tokenize the current line
            String[] parts = currentLine.split(":");

            // Call the appropriate method to insert the respective element
            // i.e., if 'p' is the first character, call insertParty.
            if (parts[0].trim().equals("p"))
                insertParty(parts);
            else if (parts[0].trim().equals("c"))
                insertCreature(parts);
            else if (parts[0].trim().equals("t"))
                insertTreasure(parts);
            else if (parts[0].trim().equals("a"))
                insertArtifact(parts);

        }

    }

    /**
     * Create a new party object. Then insert it into the cave.
     * The cave now has this party object in an ArrayList.
     * @param attributes
     */
    public void insertParty(String[] attributes) {
        Party input = new Party(Integer.parseInt(attributes[1].trim()), attributes[2].trim());
        cave.addParty(input);
    }

    /**
     * Create a new creature. Then insert the creature into a party.
     * @param attributes
     */
    public void insertCreature(String[] attributes) {
        Creature input;
        int index = Integer.parseInt(attributes[1].trim());
        String type = attributes[2].trim();
        String name = attributes[3].trim();
        int partyID = Integer.parseInt(attributes[4].trim());
        int empathy = Integer.parseInt(attributes[5].trim());
        int fear = Integer.parseInt(attributes[6].trim());
        int carryingCapacity = Integer.parseInt(attributes[7].trim());

        // The age, height and weight attributes are optional.
        if (attributes.length > 8) {
            double age = Double.parseDouble(attributes[8].trim());
            double height = Double.parseDouble(attributes[9].trim());
            double weight = Double.parseDouble(attributes[10].trim());
            input = new Creature(index, type, name, partyID, empathy, fear,
                    carryingCapacity, age, height, weight);
        }

        else {
            input = new Creature(index, type, name, partyID, empathy, fear,
                    carryingCapacity);
        }

        // Find the party to which this creature belongs
        Party creaturesParty = cave.getPartyByID(partyID);

        // If the creature has a party, insert that creature into the party.
        if (creaturesParty != null)
            creaturesParty.addCreature(input);
    }

    /**
     * Create a treasure. Then assign it to a Creature.
     * @param attributes
     */
    public void insertTreasure(String[] attributes) {
        int index = Integer.parseInt(attributes[1].trim());
        String type = attributes[2].trim();
        int creatureIndex = Integer.parseInt(attributes[3].trim());
        double weight = Double.parseDouble(attributes[4].trim());
        int value = Integer.parseInt(attributes[5].trim());

        Treasure input = new Treasure(index, type, creatureIndex, weight, value);

        // Find the creature to which this treasure belongs
        // and assign the treasure to the creature
        for (Party party : cave.getParties()) {
            if (party.getCreatureByID(creatureIndex) != null) {
                Creature creature = party.getCreatureByID(creatureIndex);
                creature.addTreasure(input);
            }
        }
    }

    /**
     * Create an artifact then assign it to a creature
     * @param attributes
     */
    public void insertArtifact(String[] attributes) {
        Artifact input;
        int index = Integer.parseInt(attributes[1].trim());
        String type = attributes[2].trim();
        int creatureIndex = Integer.parseInt(attributes[3].trim());

        // The name option for artifacts is optional
        if (attributes.length > 4) {
            String name = attributes[4].trim();
            input = new Artifact(index, type, creatureIndex, name);
        }
        else {
            input = new Artifact(index, type, creatureIndex);
        }

        // Find the creature to which this artifact belongs
        // And assign it to the creature
        for (Party party : cave.getParties()) {
            if (party.getCreatureByID(creatureIndex) != null) {
                Creature creature = party.getCreatureByID(creatureIndex);
                creature.addArtifact(input);
            }
        }
    }

    /**
     * Display the internal data structures.
     * Append the relationship between CaveElements in the
     * internalDataStructure text area.
     */
    public void displayInternalDataStructures() {

        for (Party party : cave.getParties()) {
            internalDataStructure.append(party.toString());
            internalDataStructure.append("\n");

            for (Creature creature : party.getCreatures()) {
                internalDataStructure.append("\t" + creature.toString());
                internalDataStructure.append("\n");

                for (Treasure treasure : creature.getTreasures()) {
                    internalDataStructure.append("\t\t" + treasure.toString());
                    internalDataStructure.append("\n");
                }

                for (Artifact artifact : creature.getArtifacts()) {
                    internalDataStructure.append("\t\t" + artifact.toString());
                    internalDataStructure.append("\n");
                }
            }
        }
    }
}