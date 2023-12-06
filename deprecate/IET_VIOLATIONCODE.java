/* Deprecated Violation Code, encountered a non solvable
 * Bug, took time to make decision, but decided to deprecate
 * it out the code base
*/
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
