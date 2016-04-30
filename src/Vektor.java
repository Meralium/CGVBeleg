import java.util.Arrays;

public abstract class Vektor {

    private double[] vek;

    public Vektor() {
    }

    public Vektor(int laenge) {
        vek = new double[laenge];
    }

    @Override
    public String toString() {
        return "Vektor{" +
                "vek=" + Arrays.toString(vek) +
                '}';
    }

    public double[] getVek() {
        return vek;
    }

    public double getX() {
        return vek[0];
    }

    public double getY() {
        return vek[1];
    }

    public void mult(double multi) {
        for (int i = 0; i < vek.length; i++) {
            vek[i] *= multi;
        }
    }

    public void setVek(double[] vek) {
        this.vek = vek;
    }

    protected void setPosition(double... coords) {
        for (int i = 0; i < coords.length; i++) {
            vek[i] = coords[i];
        }
    }

}
