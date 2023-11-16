/*
    WELCOME TO THE FUTURE, these are the newer code base,
    and will be the base code to receive updates alongside other
    IET Functionality in the future.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GUI extends IET_COLLECTIONS{
    public static Color GLOBAL_BG_COLOR = new Color(255, 77, 77);
    public static Color GLOBAL_FG_COLOR = new Color(173, 173, 133);
    
    // GLOBAL FRAME HOLDS EVERYTHING
    public static JFrame GLOBAL_FRAME = new JFrame("IET - Institutional Entry Tracker");
    // GLOBAL PANEL HOLDS EVERY VISIBLE PANELS BASED ON WHAT THE USER IS DOING 
    public static JPanel GLOBAL_PANEL = new JPanel();

    public static void main(String args[]){
        GLOBAL_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GLOBAL_FRAME.setMinimumSize(new Dimension(400,400));
        GLOBAL_FRAME.setMaximumSize(new Dimension(400,400));
        GLOBAL_FRAME.setResizable(false);

        GLOBAL_PANEL.setLayout(new BoxLayout(GLOBAL_PANEL, BoxLayout.Y_AXIS));
        Start_GUI();
    }
    public static void Start_GUI(){
        //#region ACTION-PANEL-PARENT
            // JPanel actionPANEL_Parent = new JPanel();
            // actionPANEL_Parent.setBackground(GLOBAL_FG_COLOR);
            // actionPANEL_Parent.setMaximumSize(new Dimension(400,20));
        //#endregion
        //#region DETAIL-PANEL-PARENT
            JPanel detailPANEL_Parent = new JPanel();
            detailPANEL_Parent.setBackground(GLOBAL_BG_COLOR);
            detailPANEL_Parent.setMaximumSize(new Dimension(400,330));
            //#region DETAILS-PANEL
                JPanel detailPANEL = new JPanel();
                JLabel person_info = new JLabel("22-32507 : PRINCE MARCO GUERRERO : 23-08-31 : 12:00 PM");
                detailPANEL.add(person_info);
            //#endregion
            detailPANEL.setVisible(false);
            detailPANEL_Parent.add(detailPANEL);
        //#endregion
        //#region TRACK-PANEL-PARENT
            JPanel trackPANEL_Parent = new JPanel();
            trackPANEL_Parent.setBackground(Color.gray);
            trackPANEL_Parent.setMaximumSize(new Dimension(400, 50));
            JLabel trackLABEL = new JLabel("Enter SR-CODE");
            JTextField trackTF = new JTextField(10);
            JButton trackBUTTON = new JButton("Enter");

            // What do button do
            // Add an action or simply listen for any click in the button
            // and execute what's inside
            trackBUTTON.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    // trackTF.getText means to get the text inside the input field or text field 
                    Testing(trackTF.getText());
                    trackTF.setText("");
                }
            });
            trackPANEL_Parent.add(trackLABEL);
            trackPANEL_Parent.add(trackTF);
            trackPANEL_Parent.add(trackBUTTON);
        //#endregion

        GLOBAL_PANEL.add(detailPANEL_Parent);
        GLOBAL_PANEL.add(trackPANEL_Parent);
        
        // GLOBAL_FRAME.getContentPane().add(BorderLayout.NORTH, MenuBar);
        GLOBAL_FRAME.add(GLOBAL_PANEL);
        // GLOBAL_FRAME.getContentPane().add(BorderLayout.CENTER, detailPANEL);
        GLOBAL_FRAME.setVisible(true);
    }
    public static void Testing(String name){
        System.out.println(name);
        GLOBAL_PANEL.removeAll();
        Start_GUI();
    }
}