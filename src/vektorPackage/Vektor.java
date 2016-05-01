package vektorPackage;

import exceptions.VektorOverflowException;

import java.util.Arrays;
import java.util.Map;


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

    public boolean isSameDimension(Vektor zweiterVektor) {
        return vek.length == zweiterVektor.vek.length;
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
        if (isSameDimension(summand)) {
            for (int i = 0; i < this.vek.length; i++) {
                this.vek[i] = add2Doubles(this.vek[i], summand.vek[i]);
            }
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
            this.vek[i] = mult2Doubles(vek[i], multiplikand);
        }
    }

    protected void div(double divisor) throws VektorOverflowException {
        mult(1 / divisor);
    }

    protected boolean isEqual(Vektor zweiterVektor) {
        if (!isSameDimension(zweiterVektor)) return false;
        for (int i = 0; i < this.vek.length; i++) {
            if (this.vek[i] != zweiterVektor.vek[i]) return false;
        }
        return true;
    }

    protected boolean isNotEqual(Vektor zweiterVektor) {
        return !isEqual(zweiterVektor);
    }

    public double length() throws VektorOverflowException {
        double laenge = 0;
        for (int i = 0; i < vek.length; i++) {
            laenge = add2Doubles(laenge, mult2Doubles(this.vek[i], this.vek[i]));
        }
        return Math.sqrt(laenge);
    }

    /*----------------------------------------------------*/
    /*----------------------------------private Funktionen*/
    private double mult2Doubles(double aktuelleZahl, double multiplikand) throws VektorOverflowException {
        if (Math.abs(aktuelleZahl) != 0 && (Double.MAX_VALUE / Math.abs(aktuelleZahl) < multiplikand)) {
            throw new VektorOverflowException();
        }
        if (Math.abs(1 / multiplikand) < 1 && (aktuelleZahl / Double.MAX_VALUE > Math.abs(multiplikand))) {
            throw new VektorOverflowException();
        }
        return aktuelleZahl * multiplikand;
    }

    private double add2Doubles(double aktuelleZahl, double summand) throws VektorOverflowException {
        if ((summand > Double.MAX_VALUE - aktuelleZahl) || (summand < -Double.MAX_VALUE - aktuelleZahl)) {
            throw new VektorOverflowException();
        }
        return aktuelleZahl + summand;
    }
    /*----------------------------------------------------*/

}
