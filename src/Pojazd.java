public abstract class Pojazd {

    public String name;
    public double area;


    public Pojazd(String name, double area) {
        this.name = name;
        this.area = area;
    }

    abstract public void drive();

    @Override
    public String toString() {
        return "Pojazd" +
                "name='" + name + '\'' +
                ", area=" + area ;
    }


    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}