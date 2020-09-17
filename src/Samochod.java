public class Samochod extends Pojazd {

        //private boolean gas;
       // private Gas gas;
        private String gas;

        public Samochod(String name, double area, String gas) {
            super(name, area);
            this.gas = gas;
        }

        @Override
        public void drive() {
            System.out.println("Samochodzik");
        }

        public String isGas() {
            return gas;
        }

        public void setGas(String gas) {
            this.gas = gas;
        }

        @Override
        public String toString() {
            return "Samochod{" + super.toString()  +
                    " gas='" + gas + '\'' +
                    '}';
        }
}