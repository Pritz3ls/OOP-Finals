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
    static JScrollPane scrollPane;
    // Build the MainMenu panel including the elements inside
    public static void BUILD_FRAMES(){
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
        Image icon = Toolkit.getDefaultToolkit().getImage("IET_Logo.png"); 
        ADMIN_MENU.setIconImage(icon);
        ADMIN_MENU.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent WE) {
            int result = JOptionPane.showConfirmDialog(ADMIN_MENU,"Do you want to Exit ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION)
                ADMIN_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            else if (result == JOptionPane.NO_OPTION)
                ADMIN_MENU.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
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
        TRACK_MENU.setSize(640, 480);
        TRACK_MENU.setResizable(false);
        TRACK_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("IET_Logo.png"); 
        TRACK_MENU.setIconImage(icon);
        TRACK_MENU.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent WE) {
            int result = JOptionPane.showConfirmDialog(TRACK_MENU,"Do you want to Exit ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION)
                TRACK_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            else if (result == JOptionPane.NO_OPTION)
                TRACK_MENU.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });

        JPanel TRACK = new JPanel();
        TRACK.setLayout(null);

        JLabel _srcodeLabel = new JLabel("SRCode: ");
        JTextField _srcodeInput = new JTextField();
        JButton _submitAM = new JButton("Record [AM]");
        JButton _submitPM = new JButton("Record [PM]");
        _submitAM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!VerifySRCODE(_srcodeInput.getText())){
                    JOptionPane.showMessageDialog(TRACK, "Invalid SRCode!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(TRACK, "Tracked Successfully!\n" + RecordEntry(1,_srcodeInput.getText()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    _srcodeInput.setText("");
                }
            }
        });
        _submitPM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!VerifySRCODE(_srcodeInput.getText())){
                    JOptionPane.showMessageDialog(TRACK, "Invalid SRCode!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(TRACK, "Tracked Successfully!\n" + RecordEntry(2,_srcodeInput.getText()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    _srcodeInput.setText("");
                }
            }
        });

        _srcodeLabel.setBounds(125,300,250,25);
        _srcodeInput.setBounds(225,300,250,25);
        _submitAM.setBounds(125, 350, 150,25);
        _submitPM.setBounds(325, 350, 150,25);
        
        
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
        Image icon = Toolkit.getDefaultToolkit().getImage("IET_Logo.png"); 
        DISPLAY_MENU.setIconImage(icon);
        DISPLAY_MENU.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent WE) {
                int result = JOptionPane.showConfirmDialog(DISPLAY_MENU,"Do you want to Exit ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.YES_OPTION)
                    DISPLAY_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if (result == JOptionPane.NO_OPTION)
                    DISPLAY_MENU.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        );

        JPanel panel = new JPanel();
        JPanel savePanel = new JPanel();
        JLabel LBL_save = new JLabel("Action?");
        JButton BTN_SaveRecord = new JButton("Save Records");
        JButton BTN_ClearRecord = new JButton("Clear Records");
        
        BTN_SaveRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int result = JOptionPane.showConfirmDialog(panel, "You want to save these records?", "Warning!", JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    SaveFile();
                    JOptionPane.showMessageDialog(DISPLAY_MENU, "Records saved Successfully! Check inside the data folder", "Success!", JOptionPane.INFORMATION_MESSAGE);
                }else if(result == JOptionPane.NO_OPTION){
                    // Do nothing
                }
            }
        });
        BTN_ClearRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int result = JOptionPane.showConfirmDialog(panel, "Are you sure you want to delete these records?", "Warning!", JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    DeleteRecord();
                    REFRESHTABLE();
                    JOptionPane.showMessageDialog(DISPLAY_MENU, "Records have been deleted.", "Warning!", JOptionPane.INFORMATION_MESSAGE);
                }else if(result == JOptionPane.NO_OPTION){
                    // Do nothing
                }
            }
        });

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("#");
        model.addColumn("SRCode");
        model.addColumn("Date & Time");

        scrollPane = new JScrollPane(table);
        
        savePanel.add(LBL_save);
        savePanel.add(BTN_SaveRecord);
        savePanel.add(BTN_ClearRecord);

        panel.setLayout(new BorderLayout());
        panel.add(savePanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        DISPLAY_MENU.add(panel);
        
        DISPLAY_MENU.setJMenuBar(ADD_MENUBAR());
    }
    public static void REFRESHTABLE(){   
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        if(!_entryTEMP.isEmpty()){
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
        JMenuItem MB_RESET = new JMenuItem("Reset All");
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
        MB_RESET.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int resultA = JOptionPane.showConfirmDialog(TEMP,"Do you want to reset all the records?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resultA == JOptionPane.YES_OPTION){
                    int resultB = JOptionPane.showConfirmDialog(TEMP,"Are you really sure?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resultB == JOptionPane.YES_OPTION){
                        DeleteAllRecord();
                        if(TEMP == DISPLAY_MENU){REFRESHTABLE();}
                        JOptionPane.showMessageDialog(DISPLAY_MENU, "All records have been deleted!", "Delete successfully", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        MB_EXIT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int result = JOptionPane.showConfirmDialog(TEMP,"Do you want to Exit ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else if (result == JOptionPane.NO_OPTION){
                    // Do nothing
                }
            }
        });

        MB_ACTIONBAR.add(MB_TRACK);
        MB_ACTIONBAR.add(MB_DISPLAY);
        MB_ACTIONBAR.add(MB_RESET);
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