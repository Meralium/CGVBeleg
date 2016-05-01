package vektorPackage;

import exceptions.VektorOverflowException;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import vektorPackage.Vektor2D;
import vektorPackage.Vektor3D;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class Tests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testeSetVektor() {
        Vektor2D vek = new Vektor2D();
        double[] a = {5, 5};
        vek.setPosition(a);
        Assert.assertEquals(a[0], vek.getX(), 0);
        Assert.assertEquals(a[1], vek.getY(), 0);
        Vektor3D vek3 = new Vektor3D();
        double[] b = {-8, 5, 6};
        vek3.setPosition(b);
        Assert.assertEquals(b[0], vek3.getX(), 0);
        Assert.assertEquals(b[1], vek3.getY(), 0);
        Assert.assertEquals(b[2], vek3.getZ(), 0);
    }

    @Test
    public void testeIsNullVektor() {
        Vektor2D vek = new Vektor2D();
        Vektor3D vek3 = new Vektor3D();
        vek.setPosition(0, 0);
        vek3.setPosition(0, 0, 0);
        Assert.assertTrue(vek.isNullVektor());
        Assert.assertTrue(vek3.isNullVektor());
        vek.setPosition(1, 0);
        vek3.setPosition(65, 34, 0);
        Assert.assertFalse(vek.isNullVektor());
        Assert.assertFalse(vek3.isNullVektor());
    }

    @Test
    public void testAdditionWithException() throws VektorOverflowException {
        expectedException.expect(VektorOverflowException.class);
        Vektor3D vek = new Vektor3D(Double.MAX_VALUE, 0, 0);
        Vektor3D vek2 = new Vektor3D(Double.MAX_VALUE, 1, 2);
        vek.add(vek2);
    }

    @Test
    public void testAddition() throws VektorOverflowException {
        Vektor3D vek = new Vektor3D(-Double.MAX_VALUE, 0, 0);
        Vektor3D vek2 = new Vektor3D(0, 1, 2);
        vek.add(vek2);
        System.out.println(vek.toString());
    }

    @Test
    public void testSubbtraktion() throws VektorOverflowException {
        Vektor2D vek = new Vektor2D(2, 3);
        Vektor2D vek2 = new Vektor2D(1, 3.5);
        vek.sub(vek2);
        Vektor2D expected = new Vektor2D(1, -0.5);
        assertEquals(expected.getX(), vek.getX(), 0.001);
        assertEquals(expected.getY(), vek.getY(), 0.001);
    }

    @Test
    public void testMultiplikation() {
        try {
            Vektor2D vek = new Vektor2D(6, 0);
            vek.mult(0);
            System.out.println(vek.toString());
        } catch (VektorOverflowException e) {
            System.out.println("OVERFLOW");
            Assert.fail();
        }
    }

    @Test
    public void testDivision() {
        try {
            Vektor2D vek = new Vektor2D(5, 5);
            vek.div(Double.MAX_VALUE);
            System.out.println(vek.toString());
        } catch (VektorOverflowException e) {
            System.out.println("OVERFLOW");
        }
    }

    @Test
    public void testIsEqual() {
        Vektor3D vek = new Vektor3D(Double.MAX_VALUE, 5, 5);
        Vektor3D vek2 = new Vektor3D(Double.MAX_VALUE, 5, 5);
        Assert.assertTrue(vek.isEqual(vek2));
    }

    @Test
    public void testIsNotEqual() {
        Vektor3D vek = new Vektor3D(Double.MAX_VALUE, 5, 3);
        Vektor2D vek2 = new Vektor2D(Double.MAX_VALUE, 5);
        Assert.assertTrue(vek.isNotEqual(vek2));
    }

    @Test
    public void testIsSameDimension() {
        Vektor3D vek = new Vektor3D(Double.MAX_VALUE, 5, 3);
        Vektor2D vek2 = new Vektor2D(Double.MAX_VALUE, 5);
        Assert.assertFalse(vek.isSameDimension(vek2));
    }

    @Test
    public void testLengthWithException() throws VektorOverflowException {
        expectedException.expect(VektorOverflowException.class);
        Vektor3D vek = new Vektor3D(Double.MAX_VALUE, 2, 1);
        vek.length();
    }

    @Test
    public void testLength() throws VektorOverflowException {
        Vektor2D vek2 = new Vektor2D(54, -34);
        vek2.length();
        System.out.println(vek2.length());
    }

    @Test
    public void testNormalizeWithException() throws VektorOverflowException {
        expectedException.expect(VektorOverflowException.class);
        Vektor3D vek = new Vektor3D(Double.MAX_VALUE, 2, 1);
        vek.normalize();
    }

    @Test
    public void testNormalize() throws VektorOverflowException {
        Vektor2D vek2 = new Vektor2D(54, -34);
        vek2.normalize();
        System.out.println(vek2.length());
    }

}
