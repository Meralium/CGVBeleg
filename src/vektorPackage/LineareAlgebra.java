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

    public static double crossProduct2D(Vektor2D vektor1, Vektor2D vektor2) throws VektorOverflowException {
        return vektor1.add2Doubles(vektor1.mult2Doubles(vektor1.getX(), vektor2.getY()), -vektor1.mult2Doubles(vektor1.getY(), vektor2.getX()));
    }

    public static Vektor3D crossProduct3D(Vektor3D vektor1, Vektor3D vektor2) throws VektorOverflowException {
        Vektor3D res = new Vektor3D();
        Vektor3D res1 = new Vektor3D();
        for (int i = 1; i < vektor1.getVek().length + 1; i++) {
            res.getVek()[i - 1] = vektor1.mult2Doubles(vektor1.getVek()[i % 3], vektor2.getVek()[(i + 1) % 3]);
            res1.getVek()[i - 1] = vektor1.mult2Doubles(vektor1.getVek()[(i + 1) % 3], vektor2.getVek()[i % 3]);
        }
        return (Vektor3D) res.sub(res1);
    }

    public static double dotProduct(Vektor vektor1, Vektor vektor2) throws VektorOverflowException {
        double res = 0;
        for (int i = 0; i < vektor1.getVek().length; i++) {
            res = vektor1.add2Doubles(res, vektor1.mult2Doubles(vektor1.getVek()[i], vektor2.getVek()[i]));
        }
        return res;
    }

    public static double cosEquation(Vektor vektor1, Vektor vektor2) throws VektorOverflowException {
        return vektor1.mult2Doubles(LineareAlgebra.dotProduct(vektor1, vektor2),
                1 / (vektor1.mult2Doubles(vektor1.length(), vektor2.length())));
    }

    public static double sinEquation(Vektor3D vektor1, Vektor3D vektor2) throws VektorOverflowException {
        return vektor1.mult2Doubles((LineareAlgebra.crossProduct3D(vektor1, vektor2)).length(),
                1 / (vektor1.mult2Doubles(vektor1.length(), vektor2.length())));
    }

    public static Vektor abs(Vektor vektor) {
        for (int i = 0; i < vektor.getVek().length; i++) {
            vektor.getVek()[i] = Math.abs(vektor.getVek()[i]);
        }
        return vektor;
    }

    public static void show(Vektor vektor) {
        System.out.println(vektor.toString());
    }

}
