public class Motocykl extends Pojazd {


    private boolean homo;


    public Motocykl(String name, double area, boolean homo) {
        super(name, area);
        this.homo = homo;
    }


    @Override
    public void drive() {
        System.out.println("Motorek");
    }

    @Override
    public String toString() {
        return "Motocykl " +

                name +
                "| o powierzchni |" + area + "homologacja " + homo;
    }
}
