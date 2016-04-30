import exceptions.VektorOverflowException;

import java.util.Arrays;


public abstract class Vektor {

    private double[] vek;

    /*---------------------------------------Konstruktoren*/

    public Vektor() {
    }

    public Vektor(int dimension) {
        this.vek = new double[dimension];
        /*gleich mit null initialisieren?
        * for(int i = 0; i < laenge; i++) {
        *   this.vek[i] = 0;
        * }*/
    }
    /*----------------------------------------------------*/

    /*-----------------'klassische' class-level Funktionen*/
    @Override
    public String toString() {
        return "Vektor{" +
                "vek=" + Arrays.toString(this.vek) +
                '}';
    }

    public double[] getVek() {
        return this.vek;
    }

    public void setVek(double[] vek) {
        this.vek = vek;
    }

    public double getX() {
        return this.vek[0];
    }

    public double getY() {
        return this.vek[1];
    }

    public void setX(double x) {
        this.vek[0] = x;
    }

    public void setY(double y) {
        this.vek[1] = y;
    }

    /*----------------------------------------------------*/

    /*------------------------------------Beleg-Funktionen*/

    protected void setPosition(double... koordinaten) {
        for (int i = 0; i < koordinaten.length; i++) {
            this.vek[i] = koordinaten[i];
        }
    }

    public boolean isNullVektor() {
        for (int i = 0; i < this.vek.length; i++) {
            if (this.vek[i] != 0) return false;
        }
        return true;
    }

    protected void add(double summand) throws VektorOverflowException {
        for (int i = 0; i < this.vek.length; i++){
            if (Double.MAX_VALUE - summand >= vek[i]) {
                this.vek[i] += summand;
            }
            else {
                throw new VektorOverflowException();
            }
        }
    }

    protected void mult(double multiplikand) {
        for (int i = 0; i < this.vek.length; i++) {
            this.vek[i] *= multiplikand;
        }
    }

    /*----------------------------------------------------*/

}
