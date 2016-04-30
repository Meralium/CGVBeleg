import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.JUnit4;

/**
 * Created by Meralium on 27.04.16.
 */
public class Tests {

    @Test
    public void testeSetVektor(){
        Vektor2D vek = new Vektor2D();
        double[] a = {4,5};
        vek.setPosition(a);
        Assert.assertEquals(a[0], vek.getX(),0);
        Assert.assertEquals(a[1], vek.getY(),0);
    }

    @Test
    public void testMultiplikation(){
        Vektor2D vek = new Vektor2D(4,5);
        vek.mult(Double.MAX_VALUE);
        double[] a = {20,25};
        Assert.assertArrayEquals(a, vek.getVek(), 0);
    }

}
