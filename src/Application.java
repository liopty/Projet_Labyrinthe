import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("test");
        Map<Integer, Map<Integer, Case>> lesCases;
        lesCases = new HashMap<>();
        Case maCase = new Case(1,1,EnumCase.VIDE);
        lesCases.put(1,new HashMap<Integer, Case>(1, maCase));
    }
}
