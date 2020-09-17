import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.HashMap;

public class Magazyn {


    public static HashMap<Integer, Osoba> mapaOsobb = new HashMap<>();

    ArrayList<Pomieszczenie> listaPomieszczen = new ArrayList<>();

    public HashMap<Integer, Osoba> getMapaOsobb() {
        return mapaOsobb;
    }

    public ArrayList<Pomieszczenie> getListaPomieszczen() {
        return listaPomieszczen;
    }
}