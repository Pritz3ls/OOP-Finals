import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Manalo_GUI{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(1280, 720));
        frame.setResizable(false);

        JPanel panel = new JPanel();

        JLabel userLabel = new JLabel("Username:");
        JTextField userTextField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton button = new JButton("Submit");
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(button);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}