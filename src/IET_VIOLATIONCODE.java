public class IET_VIOLATIONCODE {
    private String[] VIOLATION = new String[]{
        "INVALID UNIFORM",
        "BEHAVIOURAL MISCONDUCT",
        "ILLEGAL POSSESION",
    };
    public String CheckCode(int code){
        return VIOLATION[code];
    }
}
