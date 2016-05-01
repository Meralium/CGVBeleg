package vektorPackage;

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
        return "vektorPackage.Vektor{" +
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

    protected boolean isNullVektor() {
        for (int i = 0; i < this.vek.length; i++) {
            if (this.vek[i] != 0) return false;
        }
        return true;
    }

    protected void add(Vektor summand) throws VektorOverflowException {
        for (int i = 0; i < this.vek.length; i++) {
            if ((summand.vek[i] > Double.MAX_VALUE - this.vek[i]) || (summand.vek[i] < -Double.MAX_VALUE - this.vek[i])) {
                throw new VektorOverflowException();
            }
            this.vek[i] += summand.vek[i];
        }
    }

    protected void sub(Vektor subtrahend) throws VektorOverflowException {
        for (int i = 0; i < subtrahend.vek.length; i++) {
            subtrahend.vek[i] = -subtrahend.vek[i];
        }
        add(subtrahend);
    }

    protected void mult(double multiplikand) throws VektorOverflowException {
        for (int i = 0; i < this.vek.length; i++) {
            if (Math.abs(vek[i]) != 0 && (Double.MAX_VALUE / Math.abs(vek[i]) < multiplikand)) {
                throw new VektorOverflowException();
            }
            if (Math.abs(1/multiplikand) < 1 && (vek[i] / Double.MAX_VALUE > Math.abs(multiplikand))) {
                throw new VektorOverflowException();
            }
            else {
                this.vek[i] *= multiplikand;
            }
        }
    }

    protected void div(double divisor) throws VektorOverflowException {
        mult(1 / divisor);
    }

    protected boolean isEqual(Vektor zweiterVektor) {
        for (int i = 0; i < this.vek.length; i++) {
            if (this.vek[i] != zweiterVektor.vek[i]) return false;
        }
        return true;
    }

    /*----------------------------------------------------*/

}
