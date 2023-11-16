import javax.swing.*;
import java.awt.*;
public class Test_GUI {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(1280, 720));
        frame.setResizable(false);

        JPanel testpanel = new JPanel();
        
        JLabel nameText = new JLabel("Princess Jhaymie");
        JButton button = new JButton("Press Me!");
        button.setBackground(Color.green);
        testpanel.add(nameText);
        testpanel.add(button);

        frame.add(testpanel);
        frame.setVisible(true);
    }
}
