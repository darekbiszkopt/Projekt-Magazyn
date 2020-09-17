import java.util.*;

public class Pomieszczenie {

    private int id;
    private double rozmiar;
    public List<Pojazd> pojazdy = new ArrayList<>();
    private double wolneMiejsce;


    public Pomieszczenie(int id, double rozmiar) {
        this.rozmiar = rozmiar;
        this.id = id;
        this.wolneMiejsce = rozmiar;
    }


    @Override
    public String toString() {
        return "Pomieszczenie{" +
                "id=" + id +
                ", rozmiar=" + rozmiar +
                ", pojazdy=" + pojazdy +
                '}';
    }

    public void setRozmiar(double rozmiar) {
        this.rozmiar = rozmiar;
    }


    public double getRozmiar() {
        return rozmiar;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addPojazd() {
        boolean loop = true;
        int wynik = -1;
        String name;
        int rozmiar;

        while (loop) {
            System.out.println("Wybierz typ pojazdu: ");
            System.out.println("1. Samochod ");
            System.out.println("2. Motocykl ");
            System.out.println("3. Rower ");

            Scanner scanner = new Scanner(System.in);
            wynik = scanner.nextInt();

            System.out.print("Podaj nazwe pojazdu: ");
            Scanner name_scanner = new Scanner(System.in);
            name = name_scanner.nextLine();

            System.out.print("Podaj rozmiar pojazdu: ");
            Scanner size_scanner = new Scanner(System.in);
            rozmiar = size_scanner.nextInt();

            if (wynik == -1) {
                System.exit(0);
            }
            else if(wynik == 1 && czyZmiesci(rozmiar)) {
                addSamochod(name, rozmiar);
                loop=false;
            }
            else if (wynik == 2 && czyZmiesci(rozmiar)) {
                addMotocykl(name, rozmiar);
                loop=false;
            }
            else if (wynik == 3 && czyZmiesci(rozmiar)) {
                addRower(name, rozmiar);
                loop=false;
            }
            else {
                System.out.println("Niewłaście dane");
            }
        }
    }

    public void deletePojazd() {
        int wynik = -1;
        System.out.println("Wybierz ktory pojazd chcesz usunac: ");
        for (int i = 0; i < pojazdy.size(); i++) {
            System.out.println((i+1) + ". " + pojazdy.get(i));   // (i+1) bo chce zeby pokazywalo od 1 a nie od 0
        }

        Scanner scanner = new Scanner(System.in);
        wynik = scanner.nextInt();

        if (wynik == -1)
            System.exit(0);
        if(wynik <= pojazdy.size() && wynik > 0) {
            for (int i = 0; i < pojazdy.size(); i++) {
                if (pojazdy.get(i).hashCode() == pojazdy.get(wynik-1).hashCode()) {
                    pojazdy.remove(pojazdy.get(wynik-1));
                }
            }
        }
        else {
            System.out.println("Niewłaście dane");
        }

    }

    private void addRower(String name, int rozmiar) {
        System.out.println("Ile przerzutek ma rower? Max 9 ");


        int wynik = -1;

        Scanner scanner = new Scanner(System.in);
        wynik = scanner.nextInt();

        if (wynik < 0 && wynik >= 9) {
            System.out.println("Niewłaście dane");
            System.exit(0);
        }
        else {
            Rower r = new Rower(name, rozmiar, wynik, false);
        }

        Rower r = new Rower(name, rozmiar, wynik, false);

        System.out.println("Czy rower sie sklada?");
        System.out.println("1.Tak");
        System.out.println("2.Nie");

        int czySk = -1;
        Scanner scanner1 = new Scanner(System.in);
        czySk = scanner1.nextInt();

        if (czySk == 1) {
            r.setCzySklada(true);
            r.setArea(rozmiar/2);
            this.pojazdy.add(r);

        }
        if (czySk == 2) {
            r.setCzySklada(false);
            this.pojazdy.add(r);
        }

    }


    private void addMotocykl(String name, int rozmiar) {
        System.out.println("Czy motocykl posiada homologacje: ");
        System.out.println("1. Tak ");
        System.out.println("2. Nie ");

        int wynik = -1;
        Scanner scanner = new Scanner(System.in);
        wynik = scanner.nextInt();

        if (wynik == -1) {
            System.exit(0);
        }
        else if(wynik == 1) {
            this.pojazdy.add(new Motocykl(name, rozmiar, true));
        }
        else if (wynik == 2) {
            this.pojazdy.add(new Motocykl(name, rozmiar, false));
        }
        else {
            System.out.println("Niewłaście dane");
        }
    }

    private void addSamochod(String name, int rozmiar) {
        Samochod s = new Samochod(name, rozmiar, null);
        System.out.println("Na co jeździ samochod? (HYBRYDA, GAZ, BENZYNA CZY DIESEL ");
        System.out.println("Wpisz -1 jesli chcesz wyjść ");


        String wynik = "-1";
        Scanner scanner = new Scanner(System.in);
        wynik = scanner.nextLine();

        if (wynik == "-1") {
            System.exit(0);
        }
        else if(wynik.equals("HYBRYDA")) {
            s.setGas(wynik);
            this.pojazdy.add(s);
        }else if(wynik.equals("GAZ")) {
            s.setGas(wynik);
            this.pojazdy.add(s);
        }else if(wynik.equals("DIESEL")) {
            s.setGas(wynik);
            this.pojazdy.add(s);
        }else if(wynik.equals("BENZYNA")) {
            s.setGas(wynik);
            this.pojazdy.add(s);
        }
        else {
            System.out.println("Niewłaście dane");
        }
    }


    private boolean czyZmiesci(int area) {
        boolean czyZmiesci = false;

        if (this.rozmiar > area && this.wolneMiejsce > area) {
            czyZmiesci = true;

        } else {
            System.out.println("Pojazd sie nie zmiesci!!!!");
        }



        return czyZmiesci;
    }

    public void updateWolneMiejsce(double miejsce) {
        this.wolneMiejsce = this.wolneMiejsce - miejsce;
    }
}