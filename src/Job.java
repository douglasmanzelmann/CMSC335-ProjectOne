import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// File : Job.java
// Date February 22, 2015
// Author: Douglas Manzelmann
// Purpose: This class encapsulates all things related to job processing in the Sorcerer's Guild Project.
//          It handles threads and mutexes (each creature can only run one job at a time) and it provides
//          the GUI elements for the game (progress bars, buttons to pause and stop jobs, etc.

public class Job implements Runnable {
    private int index;
    private String name;
    private Creature creature;
    private long jobTime;
    private String requiredArtifactType;
    private int requiredArtifactQuantity;
    private JProgressBar progressBar;
    private JButton pauseButton;
    private JButton cancelButton;
    private JButton statusButton;
    private boolean isPaused;
    private boolean cancel;

    enum Status {RUNNING, SUSPENDED, WAITING, DONE};

    /**
     * Constructor without optional arguments
     * @param index
     * @param name
     * @param creature
     * @param time
     */
    public Job(int index, String name, Creature creature, long time) {
        this(index, name, creature, time, "", 0);
    }

    /**
     * Main constructor for the Job class
     * @param index
     * @param name
     * @param creature
     * @param time
     * @param requiredArtifactType
     * @param requiredArtifactQuantity
     */
    public Job(int index, String name, Creature creature, long time,
                String requiredArtifactType, int requiredArtifactQuantity) {
        this.index = index;
        this.name = name;
        this.creature = creature;
        this.jobTime = time;
        this.requiredArtifactType = requiredArtifactType;
        this.requiredArtifactQuantity = requiredArtifactQuantity;

        // Initially set isPaused and cancel to false, as a job cannot be paused or canceled before it starts.
        isPaused = false;
        cancel = false;

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);

        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePause();
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelJob();
            }
        });

        statusButton = new JButton();
    }

    public void run() {
        // Every job is initially waiting to start
        showStatus(Status.WAITING);

        // Each creature can only run one job at a time. This mutex prevents
        // a creature from running multiple jobs
        synchronized (creature) {
            long time = System.currentTimeMillis();
            long startTime = time;
            long endTime = startTime + (1000 * jobTime);
            double duration = endTime - time;

            showStatus(Status.RUNNING);

            while (System.currentTimeMillis() < endTime && !cancel) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) { }

                if (isPaused) {
                    showStatus(Status.SUSPENDED);
                }
                else {
                    showStatus(Status.RUNNING);
                    time += 100;
                    progressBar.setValue((int) (((time - startTime) / duration) * 100));
                }
            }
            showStatus(Status.DONE);
        }
    }

    private void showStatus (Status status) {
        switch(status) {
            case RUNNING:
                statusButton.setBackground(Color.GREEN);
                statusButton.setText("Running");
                break;
            case WAITING:
                statusButton.setBackground(Color.ORANGE);
                statusButton.setText("Waiting Turn");
                break;
            case SUSPENDED:
                statusButton.setBackground(Color.YELLOW);
                statusButton.setText("Suspended");
                break;
            case DONE:
                statusButton.setBackground(Color.RED);
                statusButton.setText("Done");
        }
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }


    public String getCreatureName() {
        return creature.getName();
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    private void togglePause() {
        isPaused = !isPaused;
    }

    private void cancelJob() {
        cancel = true;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getStatusButton() {
        return statusButton;
    }

    public String toString() {
        return "j:" + index + ":" + name + ":" + creature.getIndex() + ":" + jobTime +
                ":" + requiredArtifactType + ":" + requiredArtifactQuantity;
    }
}
