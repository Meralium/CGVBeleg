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

    public static double euklDistance(Vektor vektor1, Vektor vektor2) throws VektorOverflowException {
        return (vektor1.sub(vektor2)).length();
    }

    public static double manhattanDistance(Vektor vektor1, Vektor vektor2) throws VektorOverflowException {
        return (LineareAlgebra.abs(vektor1.sub(vektor2))).addCoords();
    }

    /*public static Vektor3D crossProduct3D(Vektor3D vektor1, Vektor3D vektor2) throws VektorOverflowException {
        Vektor3D res = new Vektor3D();
        res.setX(vektor1.mult2Doubles(vektor1.getY(), vektor2.getZ()));
        res.setY(vektor1.mult2Doubles(vektor1.getY(), vektor2.getZ()));
        res.setZ(vektor1.mult2Doubles(vektor1.getY(), vektor2.getZ()));
    }*/

    public static Vektor abs(Vektor vektor) {
        for (int i = 0; i < vektor.getVek().length; i++) {
            vektor.getVek()[i] = Math.abs(vektor.getVek()[i]);
        }
        return vektor;
    }

}
