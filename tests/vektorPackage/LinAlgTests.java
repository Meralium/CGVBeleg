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



}