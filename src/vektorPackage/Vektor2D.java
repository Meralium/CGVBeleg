/*Erstellt von:
* Anja Handrianz (s72812)
* Artem Dyadichkin (s72788)*/

package vektorPackage;

public class Vektor2D extends Vektor {

    public Vektor2D() {
        super(2);
    }

    public Vektor2D(double x, double y) {
        super(2);
        super.setPosition(x, y);
    }

    public Vektor getClone() {
        return new Vektor2D(getX(), getY());
    }

    public void setPosition(double x, double y) {
        super.setPosition(x, y);
    }

}
