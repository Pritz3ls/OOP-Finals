import java.util.Scanner;
public class IET extends IET_QOL{
    static IET_COLLECTIONS col = new IET_COLLECTIONS();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        col.InitStudents();
        Menu();
    }
    public static void Menu(){
        String[] menu_option = new String[]{"TRACK","DISPLAY","EXIT"};
        int option = 1;

        IET_Clear();
        try{
            while(option != 3){
                IET_PrintWithLine("IET","=",12);
                IET_ListOptions(menu_option);
                System.out.print("Enter input: ");
                option = scan.nextInt();
                if(option == 1){
                    Track_Option();
                }else if(option == 2){
                    Display();
                }
                IET_Clear();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Terminating...");
        System.exit(03);
    }
    public static void Track_Option(){
        int option = 5;
        String[] track_option = new String[]{"AM","PM","Back"};

        IET_Clear();
        try{
            while(option != 0){
                IET_PrintWithLine("IET - TRACK","=",6);
                IET_ListOptions(track_option);
                System.out.print("Enter input: ");
                option = scan.nextInt();
                switch (option) {
                    case 1:
                    case 2:
                        Track(option);
                        break;
                    case 3:
                        Menu();
                        break;
                    default:
                        System.out.println("Input not valid.");
                        break;
                }
                IET_Clear();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void Track(int indx){
        IET_Clear();
        IET_PrintWithLine(" TRACK ", "=", 12);
        String input = "";
        while(!input.equals("exit")){
            System.out.print("Enter SRCODE: ");
            input = scan.next();
            if(!input.equals("exit")){
                col.Add(indx, input);
            }else{
                Menu();
                break;
            }
        }
    }
    public static void Display(){
        String[] track_option = new String[]{"AM","PM","Back"};
        int option = 5;
        try{
            while(option != 0){
                IET_PrintWithLine("IET - DISPLAY","=",6);
                IET_ListOptions(track_option);

                System.out.print("Enter input: ");
                option = scan.nextInt();
                if(option == 1 || option == 2){
                    IET_PrintWithLine("IET - AM ENTRY","=",6);
                    col.Display(option);
                    System.out.print(".\n.\n.\n");
                }else if(option == 3){
                    Menu();
                }else{
                    System.out.println("Input not valid.");
                }
                System.out.print("Press enter key to continue...");
                System.in.read();
                IET_Clear();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
