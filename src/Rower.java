public class Rower extends Pojazd{

    private int przerzutki;
    private boolean czySklada;

    public Rower(String name, double area, int przerzutki, boolean czySklada) {
        super(name, area);
        this.przerzutki = przerzutki;
        this.czySklada = czySklada;
    }

    public int getPrzerzutki() {
        return przerzutki;
    }

    public void setPrzerzutki(int przerzutki) {
        this.przerzutki = przerzutki;
    }

    public boolean isCzySklada() {
        return czySklada;
    }

    public void setCzySklada(boolean czySklada) {
        this.czySklada = czySklada;
    }

    @Override
    public void drive() {
        System.out.println("Rowerek");
    }

    @Override
    public String toString() {
        return "Rower: " + name + "| powierzchnia |" + area +
                " przerzutki: " + przerzutki
                ;
    }
}