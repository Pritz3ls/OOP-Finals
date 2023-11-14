import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GUI extends IET_COLLECTIONS{
    // public static void main(String args[]){
    //     Start_GUI();
    // }
    public static void Start_GUI(){
        JFrame frame = new JFrame("IET - Institutional Entry Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setMaximumSize(new Dimension(400,400));
        frame.setResizable(false);
        
        //#region ACTION-PANEL-PARENT
            JPanel actionPANEL_Parent = new JPanel();
            actionPANEL_Parent.setBackground(Color.gray);
            actionPANEL_Parent.setMaximumSize(new Dimension(400,20));
        //#endregion
        //#region DETAIL-PANEL-PARENT
            JPanel detailPANEL_Parent = new JPanel();
            detailPANEL_Parent.setBackground(Color.red);
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
            trackBUTTON.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Testing(trackTF.getText());
                    trackTF.setText("");
                }
            });
            trackPANEL_Parent.add(trackLABEL);
            trackPANEL_Parent.add(trackTF);
            trackPANEL_Parent.add(trackBUTTON);
        //#endregion
        JPanel wholePANEL = new JPanel();
        wholePANEL.setLayout(new BoxLayout(wholePANEL, BoxLayout.Y_AXIS));
        wholePANEL.add(actionPANEL_Parent);
        wholePANEL.add(detailPANEL_Parent);
        wholePANEL.add(trackPANEL_Parent);
        
        // frame.getContentPane().add(BorderLayout.NORTH, MenuBar);
        frame.add(wholePANEL);
        // frame.getContentPane().add(BorderLayout.CENTER, detailPANEL);
        frame.setVisible(true);
    }
    public static void Testing(String name){
        System.out.println(name);
    }
}