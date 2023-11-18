import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class IET_GUI extends IET_COLLECTIONS{
    public static JFrame ADMIN_MENU = new JFrame("IET - Login");
    public static JFrame TRACK_MENU = new JFrame("IET - Tracking");
    public static JFrame DISPLAY_MENU = new JFrame("IET - Display");
    static int GLOBAL_RES_WIDTH = 1024;
    static int GLOBAL_RES_HEIGHT = 768;
    static Color BSU_RED = new Color(237,28,36);
    static JFrame TEMP;

    // Build the MainMenu panel including the elements inside
    public static void BUILD_FRAMES(){
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
        TRACK.setBackground(BSU_RED);

        TRACK_MENU.setJMenuBar(ADD_MENUBAR());
        TRACK_MENU.add(TRACK);
    }
    public static void BUILD_DISPLAYMENU(){
        DISPLAY_MENU.setSize(GLOBAL_RES_WIDTH, GLOBAL_RES_HEIGHT);
        DISPLAY_MENU.setResizable(false);
        DISPLAY_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JPanel DISPLAY = new JPanel();
        DISPLAY.setLayout(null);
    
        DISPLAY_MENU.setJMenuBar(ADD_MENUBAR());
        DISPLAY_MENU.add(DISPLAY);
    }
    
    public static JMenuBar ADD_MENUBAR(){
        JMenuBar MENUBAR = new JMenuBar();
        MENUBAR.setBackground(Color.gray);
        JMenu MB_ACTIONBAR = new JMenu("Actions");
        JMenuItem MB_TRACK = new JMenuItem("Track");
        JMenuItem MB_DISPLAY = new JMenuItem("Display");
        JMenuItem MB_EXIT = new JMenuItem("Exit");
        
        MB_TRACK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ACTIVATE_FRAMES(1);
            }
        });
        MB_DISPLAY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
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
            TEMP = frame_id == 1 ? TRACK_MENU : DISPLAY_MENU;
            TEMP.setVisible(true);
        }else{
            System.exit(0);
        }
    }

    public static Boolean ACCESS_ADMIN(String username_str, String password_str){
        Boolean access = false;
        if(username_str.equals(GLOBAL_USERNAME)){
            if(password_str.equals(GLOBAL_PASSWORD)){
                access = true;
                isAdmin = true;
            }
        }
        return access;
    }
}