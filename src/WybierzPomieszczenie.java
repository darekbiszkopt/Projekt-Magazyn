import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WybierzPomieszczenie {
    static int wynik = -1;
    static List<Pomieszczenie> pomieszczenia;
    static Pomieszczenie wybranePomieszczenie = new Pomieszczenie(0,0);




    public void wybierzPomieszczenie() {
        boolean loop = true;
        List<Integer> counters = new ArrayList<>();

        while (loop) {
            System.out.println("Wybierz pomieszczenie po numerze ");

            System.out.println("Wybierz pokoj: ");
            for (int i = 0; i < pomieszczenia.size(); i++) {
                System.out.println((i+1) + ". " + pomieszczenia.get(i));
            }

            Scanner scanner = new Scanner(System.in);
            wynik = scanner.nextInt();

            if (wynik == -1)
                System.exit(0);

            if(wynik <= pomieszczenia.size() && wynik > 0) {
                for (int i = 0; i < pomieszczenia.size(); i++) {
                    if (pomieszczenia.get(i).hashCode() == pomieszczenia.get(wynik-1).hashCode()) {
                        setWybranePomieszczenie(pomieszczenia.get(wynik-1));
                        loop=false;
                    }
                }
            }
            else {
                System.out.println("Niewłaście dane");
            }
        }
    }

    public Pomieszczenie getWybranePomieszczenie() {
        return wybranePomieszczenie;
    }

    public static void setPomieszczenia(List<Pomieszczenie> pomieszczenia) {
        WybierzPomieszczenie.pomieszczenia = pomieszczenia;
    }

    private static void setWybranePomieszczenie(Pomieszczenie p) {
        WybierzPomieszczenie.wybranePomieszczenie = p;
    }
}