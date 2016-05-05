package vektorPackage;

import exceptions.VektorOverflowException;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import vektorPackage.Vektor2D;
import vektorPackage.Vektor3D;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinAlgTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testeAddition() throws VektorOverflowException {
        expectedException.expect(VektorOverflowException.class);
        LineareAlgebra.add(new Vektor2D(Double.MAX_VALUE, 1), new Vektor2D(2, 2));
    }

    @Test
    public void testeSubtr() throws VektorOverflowException {
        Vektor2D vek = (Vektor2D) LineareAlgebra.sub(new Vektor2D(43, 1), new Vektor2D(2, 2));
        Vektor2D vek2 = new Vektor2D(41, -1);
        assertEquals(vek.getX(), vek2.getX(), 0);
        assertEquals(vek.getY(), vek2.getY(), 0);
    }

    @Test
    public void testeMult() throws VektorOverflowException {
        double wert = -3;
        Vektor3D vek = (Vektor3D) LineareAlgebra.mult(new Vektor3D(43, 1, -18), wert);
        Vektor3D vek2 = new Vektor3D(-129, -3, 54);
        assertEquals(vek.getX(), vek2.getX(), 0);
        assertEquals(vek.getY(), vek2.getY(), 0);
        assertEquals(vek.getZ(), vek2.getZ(), 0);
    }

    @Test
    public void testeDivid() throws VektorOverflowException {
        double wert = -3;
        Vektor3D vek = (Vektor3D) LineareAlgebra.div(new Vektor3D(45, 3, -18), wert);
        Vektor3D vek2 = new Vektor3D(-15, -1, 6);
        assertEquals(vek.getX(), vek2.getX(), 0);
        assertEquals(vek.getY(), vek2.getY(), 0);
        assertEquals(vek.getZ(), vek2.getZ(), 0);
    }

    @Test
    public void testeIsEqual() {
        Vektor2D vek1 = new Vektor2D(2, 3);
        Vektor3D vek2 = new Vektor3D(2, 3, 4);
        assertFalse(LineareAlgebra.isEqual(vek2, vek1));
        Vektor2D vek3 = new Vektor2D(2, -3);
        Vektor2D vek4 = new Vektor2D(2, 3);
        assertFalse(LineareAlgebra.isEqual(vek1, vek3));
        assertTrue(LineareAlgebra.isEqual(vek1, vek4));
    }

    @Test
    public void testeIsNotEqual() {
        Vektor2D vek1 = new Vektor2D(2, 3);
        Vektor3D vek2 = new Vektor3D(2, 3, 4);
        assertTrue(LineareAlgebra.isNotEqual(vek2, vek1));
        Vektor2D vek3 = new Vektor2D(2, -3);
        Vektor2D vek4 = new Vektor2D(2, 3);
        assertTrue(LineareAlgebra.isNotEqual(vek1, vek3));
        assertFalse(LineareAlgebra.isNotEqual(vek1, vek4));
    }

    @Test
    public void testeLength() throws VektorOverflowException {
        Vektor2D vek1 = new Vektor2D(-54.23, 23);
        Vektor3D vek2 = new Vektor3D(-2, 3.43, -4.0004);
        double vek1Length = LineareAlgebra.length(vek1);
        double vek2Length = LineareAlgebra.length(vek2);
        System.out.println(vek1Length);
        System.out.println(vek2Length);
    }

    @Test
    public void testeNormalize() throws VektorOverflowException {
        Vektor2D vek1 = new Vektor2D(12, 23);
        Vektor2D vek2 = (Vektor2D) LineareAlgebra.normalize(vek1);
        assertEquals(1, vek2.length(), 0);
    }

    @Test
    public void testeEuklDistance() throws VektorOverflowException {
        expectedException.expect(VektorOverflowException.class);
        Vektor2D vek1 = new Vektor2D(Double.MAX_VALUE, -3.5433);
        Vektor2D vek2 = new Vektor2D(2.5, 3);
        double res = LineareAlgebra.euklDistance(vek1, vek2);
        System.out.println(res);
    }

    @Test
    public void testeManhattanlDistance() throws VektorOverflowException {
        Vektor2D vek1 = new Vektor2D(5, -4);
        Vektor2D vek2 = new Vektor2D(2, 3);
        double res = LineareAlgebra.manhattanDistance(vek1, vek2);
        assertEquals(10, res, 0);
        System.out.println(res);
    }

    @Test
    public void testeAbs() {
        Vektor2D vek1 = new Vektor2D(-Double.MAX_VALUE, -4.212);
        LineareAlgebra.abs(vek1);
        System.out.println(vek1.toString());
    }

    @Test
    public void testeCrossProdukt2D() throws VektorOverflowException {
        Vektor2D vek = new Vektor2D(1, 2);
        Vektor2D vek1 = new Vektor2D(-7, 8);
        double expected = 22;
        double res = LineareAlgebra.crossProduct2D(vek, vek1);
        System.out.println(res);
        assertEquals(expected, res, 0);
    }

    @Test
    public void testeCrossProdukt3D() throws VektorOverflowException {
        Vektor3D vek = new Vektor3D(1, 2, 3);
        Vektor3D vek1 = new Vektor3D(-7, 8, 9);
        Vektor3D expected = new Vektor3D(-6, -30, 22);
        Vektor3D res = LineareAlgebra.crossProduct3D(vek, vek1);
        System.out.println(res.toString());
        assertArrayEquals(expected.getVek(), res.getVek(), 0);
    }

    @Test
    public void testeDotProduct() throws VektorOverflowException {
        Vektor2D vek = new Vektor2D(32, 2);
        Vektor2D vek1 = new Vektor2D(-7, 9);
        double res = LineareAlgebra.dotProduct(vek1, vek);
        System.out.println(res);
    }

    @Test
    public void testecosEquation () throws VektorOverflowException {
        Vektor3D vek = new Vektor3D(20, 8, 4);
        Vektor3D vek1 = new Vektor3D(6, 3, 2);
        double res = LineareAlgebra.cosEquation(vek, vek1);
        System.out.println(res);
    }

    @Test
    public void testeSinEquation () throws VektorOverflowException {
        Vektor3D vek = new Vektor3D(20, 8, 4);
        Vektor3D vek1 = new Vektor3D(6, 3, 2);
        double res = LineareAlgebra.sinEquation(vek, vek1);
        System.out.println(res);
    }
}