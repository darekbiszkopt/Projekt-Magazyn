import java.io.PipedOutputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ExceptionWrongOption, RemontException {


        WybierzOsobe osobe = new WybierzOsobe();
        WybierzPomieszczenie pomieszczenie = new WybierzPomieszczenie();
        int pytanie = 0;

        boolean remont = false;
        boolean czyDodaj = false;
        boolean czyUsun = false;
        int userName;

        //System.gc();

        Osoba tabOs[] = new Osoba[5];


        Osoba darek = new Osoba("Darek", "Dajcz", "987654321", "Okińskiego 10", "22-04-1995", "25-05-2015");
        Osoba szymon = new Osoba("Szymon", "Kadziak", "537654321", "Politechnika 120", "1-10-1995", "05-03-2014");
        Osoba maciek = new Osoba("Maciek", "Koczyk", "837654321", "Metro Kabaty 10", "16-06-1999", "25-05-2005");
        Osoba stefan = new Osoba("Stefan", "Bobicz", "437654321", "Sulejów 17", "22-09-1998", "25-05-2019");
        Osoba michal = new Osoba("Michał", "Rybiński", "112654321", "Żoliborz 45", "22-07-1995", "22-05-2007");

        tabOs[0] = darek;
        tabOs[1] = szymon;
        tabOs[2] = maciek;
        tabOs[3] = stefan;
        tabOs[4] = michal;


        HashMap<Integer, Osoba> mapkaOsob = Osoba.getMapaOsob();
        mapkaOsob.put(1, darek);
        mapkaOsob.put(2, szymon);
        mapkaOsob.put(3, maciek);
        mapkaOsob.put(4, stefan);
        mapkaOsob.put(5, michal);

        //osobe.wybierzOsobe();

        System.out.println();

        Gas benzyna = new Gas("Benzyna");
        Gas hybryda = new Gas("Hybryda");
        Gas gas = new Gas("Gas");
        Gas diesel = new Gas("Diesel");

        HashMap<Integer, Gas> gasMapka = new HashMap<>();
        gasMapka.put(1, benzyna);
        gasMapka.put(2, hybryda);
        gasMapka.put(3, gas);
        gasMapka.put(4, diesel);




        Pomieszczenie pomieszczenie1 = new Pomieszczenie(1,15);
        Pomieszczenie pomieszczenie2 = new Pomieszczenie(2,125);
        Pomieszczenie pomieszczenie3 = new Pomieszczenie(3,100);
        Pomieszczenie pomieszczenie4 = new Pomieszczenie(4,323);
        Pomieszczenie pomieszczenie5 = new Pomieszczenie(5,245);
        Pomieszczenie pomieszczenie6 = new Pomieszczenie(6,76);
        Pomieszczenie pomieszczenie7 = new Pomieszczenie(7,82);
        Pomieszczenie pomieszczenie8 = new Pomieszczenie(8,90);
        Pomieszczenie pomieszczenie9 = new Pomieszczenie(9,16);
        Pomieszczenie pomieszczenie10 = new Pomieszczenie(10,8);



        HashMap<Osoba, List<Pomieszczenie>> mapaPomieszczen = new HashMap<>();
        mapaPomieszczen.put(darek, new ArrayList<Pomieszczenie>());
        mapaPomieszczen.get(darek).add(pomieszczenie1);
        mapaPomieszczen.get(darek).add(pomieszczenie2);
        mapaPomieszczen.get(darek).add(pomieszczenie10);

        mapaPomieszczen.put(szymon, new ArrayList<Pomieszczenie>());
        mapaPomieszczen.get(szymon).add(pomieszczenie3);
        mapaPomieszczen.get(szymon).add(pomieszczenie4);
        mapaPomieszczen.put(maciek, new ArrayList<Pomieszczenie>());
        mapaPomieszczen.get(maciek).add(pomieszczenie5);

        mapaPomieszczen.put(stefan, new ArrayList<Pomieszczenie>());
        mapaPomieszczen.get(stefan).add(pomieszczenie6);
        mapaPomieszczen.get(stefan).add(pomieszczenie7);
        mapaPomieszczen.get(stefan).add(pomieszczenie8);
        mapaPomieszczen.get(stefan).add(pomieszczenie9);

        mapaPomieszczen.put(michal, new ArrayList<Pomieszczenie>());



        List<Osoba> listaOsoby = new ArrayList<>();
        List<Pomieszczenie> pomieszczeniaOsoby = new ArrayList<>();

        //remont pomieszczenia bool

        while (true){
            switch (pytanie) {
                case 0: {
                    osobe.wybierzOsobe();

                    pytanie++;
                    break;
                }
                case 1: {
                    System.out.println("########################################");
                    System.out.println("POKOJE");
                    for (Map.Entry<Osoba, List<Pomieszczenie>> p : mapaPomieszczen.entrySet()) {
                        if (p.getKey().hashCode() == osobe.getOsoba().hashCode()) {
                            System.out.println(p.getValue());
                            pomieszczenie.setPomieszczenia(p.getValue());
                        }
                    }
                    pytanie++;
                    break;
                }
                case 2: {
                    pomieszczenie.wybierzPomieszczenie();

                    System.out.println("WYBRANE POMIESZCZENIE: ");
                    System.out.println("Czy pomieszczenie jest w remoncie?: ");
                    System.out.println("1. Tak ");
                    System.out.println("2. Nie ");
                    int wynik = -1;
                    Scanner scanner = new Scanner(System.in);
                    wynik = scanner.nextInt();

                    if (wynik == -1) {
                        System.exit(0);
                    }
                    else if(wynik == 1) {
                        remont = true;
                        throw new RemontException();

                    }
                    else if (wynik == 2) {

                    }
                    else {
                        System.out.println("Niewłaście dane");
                    }


                }
                case 3: {
                    System.out.println("Wybierz do chcesz zrobić: ");
                    System.out.println("1. Dodaj");
                    System.out.println("2. Usun");

                    Scanner scanner = new Scanner(System.in);
                    int wynik = scanner.nextInt();

                    if (wynik == 1) {
                        pomieszczenie.getWybranePomieszczenie().addPojazd();
                    } else if (wynik == 2) {
                        pomieszczenie.getWybranePomieszczenie().deletePojazd();
                    } else {
                       throw new ExceptionWrongOption();                   }
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    return;
                }


            }

        }









    }

}