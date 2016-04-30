
public class Vektor3D extends Vektor {

    public Vektor3D() {
        super(3);
    }

    public Vektor3D(double x, double y, double z) {
        super(3);
        super.setPosition(x, y, z);
    }

    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);
    }

    /*müsste nur in Vektor3D sein*/
    public double getZ() {
        return super.getVek()[2];
    }

    public void setZ(double z) {
        super.getVek()[2] = z;
    }


}
