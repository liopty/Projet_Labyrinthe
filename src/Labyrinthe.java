import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Labyrinthe {
    private Map<Integer, Map<Integer, Case>> lesCases;
    private Noeud depart;

    public Labyrinthe() {
        this.lesCases = new HashMap<>();
    }

    private void addCase(Case c) {
        if (!lesCases.containsKey(c.getX())){
            lesCases.put(c.getX(), new HashMap<>());
        }
        lesCases.get(c.getX()).put(c.getY(), c);
    }

    public void init(String filePath){
        try{
            InputStream flux=new FileInputStream(filePath);
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            int value = 0;

            int x = 0;
            int y = 0;

            while ((value = buff.read()) != -1){
                char c = (char)value;

                switch (c) {
                    case '\n':
                        y += 1;
                        x = 0;
                        break;
                    case 'M':
                        this.addCase(new Case(x,y, EnumCase.MUR));
                       // System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    case 'E':
                        this.addCase(new Case(x,y, EnumCase.ENTREE));
                        depart = new Noeud(this, null, EnumAction.RIEN,0,0);
                        //System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    case 'S':
                        this.addCase(new Case(x,y, EnumCase.SORTIE));
                        //System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    case '_':
                        this.addCase(new Case(x,y, EnumCase.VIDE));
                        //System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    default: System.out.println("ERR");
                        break;
                }

            }
            buff.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void lireLaby(){

        for(Map.Entry<Integer, Map<Integer, Case>> entry : lesCases.entrySet()) {
            int x = entry.getKey();
            for (Map.Entry<Integer, Case> entry2: entry.getValue().entrySet()) {
                int y = entry2.getKey();
                System.out.println("x: "+x+" "+"y: "+y+" "+entry2.getValue().getType());
            }

        }
    }

    public Noeud getDepart() {
        return depart;
    }
}
