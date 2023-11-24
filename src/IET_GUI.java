import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
class IET_GUI extends IET_COLLECTIONS{
    public static JFrame ADMIN_MENU = new JFrame("IET - Login");
    public static JFrame TRACK_MENU = new JFrame("IET - Tracking");
    public static JFrame DISPLAY_MENU = new JFrame("IET - Display");
    static int GLOBAL_RES_WIDTH = 800;
    static int GLOBAL_RES_HEIGHT = 600;
    static Color BSU_RED = new Color(237,28,36);
    static JFrame TEMP;

    static JTable table = new JTable();
    static JScrollPane scrollPane1;
    // Build the MainMenu panel including the elements inside
    public static void BUILD_FRAMES(){
        InitStudents();
        CollectListEntry(1);
        BUILD_ADMINMENU();
        BUILD_TRACKMENU();
        BUILD_DISPLAYMENU();

        ACTIVATE_FRAMES(1);
    }
    public static void BUILD_ADMINMENU(){
        ADMIN_MENU.setSize(new Dimension(360, 200));
        ADMIN_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ADMIN_MENU.setResizable(false);
        
        JPanel ADMIN = new JPanel();
        ADMIN.setLayout(null);
        ADMIN.setBackground(BSU_RED);
        JLabel _userLabel = new JLabel("Username");
        JLabel _passLabel = new JLabel("Password");
        _userLabel.setForeground(Color.white);
        _passLabel.setForeground(Color.white);
        JTextField _username = new JTextField(10);
        JTextField _password = new JTextField(10);
        JButton _submit = new JButton("Submit");
        _submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!ACCESS_ADMIN(_username.getText(), _password.getText())){
                    JOptionPane.showMessageDialog(_submit, "Invalid Inputs", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    ADMIN_MENU.dispose();
                    ACTIVATE_FRAMES(1);
                }
            }
        });

        _userLabel.setBounds(80,20,80,25);
        _username.setBounds(160,20,120,25);
        _passLabel.setBounds(80,50,80,25);
        _password.setBounds(160,50,120,25);
        _submit.setBounds(130,125,80,30);

        ADMIN.add(_userLabel);
        ADMIN.add(_passLabel);
        ADMIN.add(_username);
        ADMIN.add(_password);
        ADMIN.add(_submit);
        ADMIN_MENU.add(ADMIN);
    }
    public static void BUILD_TRACKMENU(){
        TRACK_MENU.setSize(GLOBAL_RES_WIDTH, GLOBAL_RES_HEIGHT);
        TRACK_MENU.setResizable(false);
        TRACK_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel TRACK = new JPanel();
        TRACK.setLayout(null);

        JLabel _srcodeLabel = new JLabel("SRCode: ");
        JTextField _srcodeInput = new JTextField();
        JButton _submitAM = new JButton("Record [AM]");
        JButton _submitPM = new JButton("Record [PM]");
        _submitAM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!VerifySRCODE(_srcodeInput.getText())){
                    JOptionPane.showMessageDialog(_submitAM, "Invalid SRCode!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    RecordEntry(1,_srcodeInput.getText());
                    _srcodeInput.setText("");
                }
            }
        });
        _submitPM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!VerifySRCODE(_srcodeInput.getText())){
                    JOptionPane.showMessageDialog(_submitPM, "Invalid SRCode!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    RecordEntry(2,_srcodeInput.getText());
                    _srcodeInput.setText("");
                }
            }
        });

        _srcodeLabel.setBounds(200,400,250,25);
        _srcodeInput.setBounds(300,400,250,25);
        _submitAM.setBounds(200, 450, 150,25);
        _submitPM.setBounds(400, 450, 150,25);
        
        
        TRACK.add(_srcodeInput);
        TRACK.add(_srcodeLabel);
        TRACK.add(_submitAM);
        TRACK.add(_submitPM);
        
        TRACK_MENU.setJMenuBar(ADD_MENUBAR());
        TRACK_MENU.add(TRACK);
    }
    public static void BUILD_DISPLAYMENU(){
        DISPLAY_MENU.setSize(GLOBAL_RES_WIDTH, GLOBAL_RES_HEIGHT);
        DISPLAY_MENU.setResizable(false);
        DISPLAY_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("#");
        model.addColumn("SRCode");
        model.addColumn("Date & Time");

        scrollPane1 = new JScrollPane(table);
        DISPLAY_MENU.add(scrollPane1);
        
        DISPLAY_MENU.setJMenuBar(ADD_MENUBAR());
    }
    public static void REFRESHTABLE(){   
        if(!_entryTEMP.isEmpty()){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for(int i = 0; i < _entryTEMP.size(); i++){
                model.addRow(new Object[]{i+1,_entryTEMP.get(i).GetSRCODE(), _entryTEMP.get(i).GETDATE()});;
            }
        }
    }

    public static JMenuBar ADD_MENUBAR(){
        JMenuBar MENUBAR = new JMenuBar();
        MENUBAR.setBackground(Color.gray);
        JMenu MB_ACTIONBAR = new JMenu("Actions");
        JMenuItem MB_TRACK = new JMenuItem("Track");
        JMenu MB_DISPLAY = new JMenu("Display");
        JMenuItem D_AM = new JMenuItem("Morning Entry");
        JMenuItem D_PM = new JMenuItem("Afternoon Entry");
        MB_DISPLAY.add(D_AM);
        MB_DISPLAY.add(D_PM);
        JMenuItem MB_EXIT = new JMenuItem("Exit");
        
        MB_TRACK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ACTIVATE_FRAMES(1);
            }
        });

        D_AM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CollectListEntry(1);
                ACTIVATE_FRAMES(2);
            }
        });
        D_PM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CollectListEntry(2);
                ACTIVATE_FRAMES(2);
            }
        });
        
        MB_EXIT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ACTIVATE_FRAMES(0);
            }
        });

        MB_ACTIONBAR.add(MB_TRACK);
        MB_ACTIONBAR.add(MB_DISPLAY);
        MB_ACTIONBAR.add(MB_EXIT);
        
        MENUBAR.add(MB_ACTIONBAR);

        return MENUBAR;
    }
    public static void ACTIVATE_FRAMES(int frame_id){
        if(!isAdmin){
            TEMP = ADMIN_MENU;
            TEMP.setVisible(true);
            return;
        }
        
        TEMP.dispose();
        if(frame_id != 0){
            if(frame_id == 2){
                REFRESHTABLE();
            }
            TEMP = frame_id == 1 ? TRACK_MENU : DISPLAY_MENU;
            TEMP.setVisible(true);
        }else{
            System.exit(0);
        }
    }

    public static Boolean ACCESS_ADMIN(String username_str, String password_str){
        Boolean access = false;
        if(username_str.equals(GLOBAL_USERNAME) && password_str.equals(GLOBAL_PASSWORD)){
            access = true;
            isAdmin = true;
        }
        return access;
    }
}