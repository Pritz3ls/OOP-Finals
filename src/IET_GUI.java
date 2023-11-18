import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class IET_GUI extends IET_COLLECTIONS{
    public static JFrame ADMIN_MENU = new JFrame();
    public static JFrame TRACK_MENU = new JFrame();
    public static JFrame DISPLAY_MENU = new JFrame();
    static int GLOBAL_RES_WIDTH = 1024;
    static int GLOBAL_RES_HEIGHT = 1024;

    // Build the MainMenu panel including the elements inside
    public static void BUILD_FRAMES(){
        BUILD_MAINMENU();

        ACTIVATE_FRAMES(1);
    }
    public static void BUILD_MAINMENU(){
        ADMIN_MENU.setSize(new Dimension(GLOBAL_RES_WIDTH, GLOBAL_RES_HEIGHT));
        ADMIN_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ADMIN_MENU.setResizable(false);
        
        JPanel ADMIN = new JPanel();
        // ADMIN.setLayout(new BoxLayout(ADMIN, BoxLayout.Y_AXIS));
        ADMIN.setBackground(Color.red);
        JTextField _username = new JTextField("Username",10);
        JTextField _password = new JTextField("Password",10);
        JButton _submit = new JButton("Submit");
        _submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Welcome");
            }
        });
        ADMIN.add(_username);
        ADMIN.add(_password);
        ADMIN.add(_submit);
        ADMIN_MENU.add(ADMIN);
    }
    public static void BUILD_TRACKMENU(){}
    public static void BUILD_DISPLAYMENU(){}
    
    public static JMenuBar ADD_MENUBAR(){
        JMenuBar MENUBAR = new JMenuBar();
        MENUBAR.setBackground(Color.gray);
        JMenu MB_ACTIONBAR = new JMenu("Actions");
        JMenuItem MB_TRACK = new JMenuItem("Track");
        JMenuItem MB_DISPLAY = new JMenuItem("Display");
        JMenuItem MB_EXIT = new JMenuItem("Exit");
        
        MB_TRACK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ACTIVATE_FRAMES(0);
            }
        });
        MB_DISPLAY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ACTIVATE_FRAMES(1);
            }
        });
        MB_EXIT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ACTIVATE_FRAMES(2);
            }
        });

        MB_ACTIONBAR.add(MB_TRACK);
        MB_ACTIONBAR.add(MB_DISPLAY);
        MB_ACTIONBAR.add(MB_EXIT);
        
        MENUBAR.add(MB_ACTIONBAR);

        return MENUBAR;
    }
    public static void ACTIVATE_FRAMES(int frame_id){
        JFrame TEMP;
        if(!isAdmin){
            TEMP = ADMIN_MENU;
            TEMP.setVisible(true);
            return;
        }
        if(frame_id != 2){
            TEMP = frame_id == 1 ? TRACK_MENU : DISPLAY_MENU;
            TEMP.setVisible(true);
        }
    }
}