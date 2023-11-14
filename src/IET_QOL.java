public class IET_QOL{
    public static void IET_PrintWithLine(String MOTD, String symbol, int width){
        for(int i = 0; i < width; i++){
           System.out.print(symbol); 
        }
        System.out.print(" "+MOTD+" ");
        for(int i = 0; i < width; i++){
           System.out.print(symbol); 
        }
        System.out.println();
    }
    public static void IET_Clear() {  
        System.out.print("");  
        System.out.flush();  
    }
    public static void IET_ListOptions(String[] options){
        for(int i = 0; i < options.length; i++){
           System.out.println(i+1 + " - " + options[i]);
        }
    } 
}