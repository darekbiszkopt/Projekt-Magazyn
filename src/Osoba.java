import java.util.HashMap;
import java.util.Map;

public class Osoba {


    public static HashMap<Integer, Osoba> mapaOsob = new HashMap<>();

    static int counter;


    private String name;
    private String surname;
    private String pesel;
    private String adres;
    private String dataUr;
    private String dataNajm;




    public Osoba(String name, String surname, String pesel, String adres, String dataUr, String dataNajm) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.adres = adres;
        this.dataUr = dataUr;
        this.dataNajm = dataNajm;



    }

    public static HashMap<Integer, Osoba> getMapaOsob() {
        return mapaOsob;
    }

    public String getName() {
        return name;
    }

    public String getSurnameName() {
        return surname;
    }


    @Override
    public String toString() {
        return "Osoba" +
                " " + name  +
                " " + surname  +
                "- |pesel| " + pesel +
                "- |adres| " + adres +
                "- |dataUr| " + dataUr +
                "- |dataNajm| " + dataNajm ;
    }

    public static int ileOsob(HashMap mapaOsob)
    {

        for (Map.Entry<Integer, Osoba> o : Osoba.mapaOsob.entrySet()) {
            System.out.println("Numer osoby " + o.getKey() + " " + o.getValue());
            counter++;
        }
        return counter;
    }

    public static int getCounter() {
        return counter;
    }
}