
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Case>> lesCases = new HashMap<>();

        Case maCase = new Case(1,1,EnumCase.VIDE);

        lesCases.put(maCase.getX(),new HashMap<Integer, Case>());
        lesCases.get(maCase.getY()).put(1, maCase);

        System.out.println(lesCases.get(maCase.getX()).get(maCase.getY()));

        Labyrinthe laby = new Labyrinthe();

        laby.init("labyrinthe/labExemple.lab");
        laby.lireLaby();
        System.out.println(laby.getDepart());

    }
}
