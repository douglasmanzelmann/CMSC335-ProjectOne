import javax.swing.*;
import java.awt.*;

/**
 * Created by test on 1/24/15.
 */
public class SorcerersCave extends JFrame {
    private JLabel jlblHello = new JLabel("Hello", JLabel.CENTER);

    public static void main(String[] args) {
        SorcerersCave frame = new SorcerersCave();
        frame.pack();
        frame.setTitle("Hello");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public SorcerersCave() {
        add(jlblHello, BorderLayout.CENTER);
    }
}
