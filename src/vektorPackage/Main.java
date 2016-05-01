package vektorPackage;

public class Main {

    public static void main(String agrs[]) {
        Vektor2D vek = new Vektor2D();

    }

}

/*WTF???*/
/*protected void add(Vektor summand) throws VektorOverflowException {
        for (int i = 0; i < this.vek.length; i++) {
            if ((summand.vek[i] < Double.MAX_VALUE - this.vek[i]) && (summand.vek[i] > -Double.MAX_VALUE - this.vek[i])) {
                this.vek[i] += summand.vek[i];
            } else {
                throw new VektorOverflowException();
            }
        }
    }*/
