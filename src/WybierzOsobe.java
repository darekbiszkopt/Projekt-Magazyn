import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WybierzOsobe  {
    static int wynik = -1;
    static Osoba osoba = new Osoba(null, null, null, null, null, null);




    public void wybierzOsobe() {
        boolean loop = true;

        while (loop) {
            System.out.println("Wybierz osobe po numerze ");

            for (Map.Entry<Integer, Osoba> o : Osoba.mapaOsob.entrySet()) {
                System.out.println("Numer osoby " + o.getKey() + " " + o.getValue());
            }

            Scanner scanner = new Scanner(System.in);
            wynik = scanner.nextInt();

            if (wynik == -1)
                System.exit(0);
            if(wynik <= 5 && wynik > 0) {
                for (Map.Entry<Integer, Osoba> o : Osoba.mapaOsob.entrySet()) {
                    if (o.getKey() == wynik) {
                        System.out.println("OSOBA: " + o.toString());
                        setOsoba(o.getValue());
                        loop = false;
                    }
                }
            }


            else {
                System.out.println("Niewłaście dane");
            }
        }
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public static void setOsoba(Osoba os) {
        WybierzOsobe.osoba = os;
    }

    public static int getWynik() {
        return wynik;
    }

    public static void setWynik(int wynik) {
        WybierzOsobe.wynik = wynik;
    }
}