import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class IET_FileWrite{
    static void FILE_OVERWRITE(String path, ArrayList<String> _datas){
        FILE_DELETE(path);
        FILE_WRITE(path,_datas);
    }
    private static void FILE_DELETE(String pathname){
        File myObj = new File(pathname); 
        if (myObj.delete()) { 
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("File doesnt exist");
        } 
    }
    private static void FILE_WRITE(String pathname, ArrayList<String> data){
        String written_data = "";
        try {
            FileWriter myWriter = new FileWriter(pathname);
            if(data.isEmpty()){
                written_data = "<no record>";
            }else{
                for(int i = 0; i < data.size(); i++){
                    written_data += data.get(i) + "\n";
                }
            }
            myWriter.write(written_data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static String READ_INFO(String pathname){
        String retrieve = "";
        try {
            File infoFile = new File(pathname);
            Scanner myReader = new Scanner(infoFile);
            while (myReader.hasNextLine()){
                retrieve +=  myReader.nextLine() + "\n";
            }
            myReader.close();
        }catch(FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return retrieve;
    }
    public static boolean CHECK_INFO_EXISTS(String SRCODE){
        File checkFile = new File("data//info//" + SRCODE + ".txt");
        return checkFile.exists();
    }
    public static void INFO_WRITE_Test(String pathname, String data){
        try {
            FileWriter myWriter = new FileWriter(pathname);
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}