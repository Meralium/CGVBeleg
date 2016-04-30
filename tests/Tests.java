import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.JUnit4;

/**
 * Created by Meralium on 27.04.16.
 */
public class Tests {

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
    public void testAddition() {
        Vektor2D vek = new Vektor2D(4, 0);
        vek.add(Double.MAX_VALUE);
        double[] a = {0, Double.MAX_VALUE};
        Assert.assertArrayEquals(a, vek.getVek(), 0);
    }

    @Test
    public void testMultiplikation() {
        Vektor2D vek = new Vektor2D(4, 5);
        vek.mult(Double.MAX_VALUE);
        double[] a = {20, 25};
        Assert.assertArrayEquals(a, vek.getVek(), 0);
    }

}
