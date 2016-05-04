package vektorPackage;

import exceptions.VektorOverflowException;
import vektorPackage.Vektor;
import vektorPackage.Vektor2D;

public class LineareAlgebra {

    public static Vektor add(Vektor vektor1, Vektor vektor2) throws VektorOverflowException {
        return vektor1.getClone().add(vektor2);
    }

    public static Vektor sub(Vektor vektor1, Vektor vektor2) throws VektorOverflowException {
        return vektor1.getClone().sub(vektor2);
    }

    public static Vektor mult(Vektor vektor, double multiplikand) throws VektorOverflowException {
        return vektor.getClone().mult(multiplikand);
    }

    public static Vektor div(Vektor vektor, double divisor) throws VektorOverflowException {
        return vektor.getClone().div(divisor);
    }

    public static boolean isEqual(Vektor vektor1, Vektor vektor2) {
        return vektor1.isEqual(vektor2);
    }

    public static boolean isNotEqual(Vektor vektor1, Vektor vektor2) {
        return vektor1.isNotEqual(vektor2);
    }

    public static double length(Vektor vektor) throws VektorOverflowException {
        return vektor.length();
    }

    public static Vektor normalize(Vektor vektor) throws VektorOverflowException {
        return vektor.normalize();
    }

}
