import exceptions.VektorOverflowException;
import vektorPackage.Vektor2D;

public class VerhaltenYBewegung implements Verhalten {
    private BewegendesObjekt objekt;

    public VerhaltenYBewegung(BewegendesObjekt objekt) {
        this.objekt = objekt;
    }

    public void update() {
        try {
            objekt.getPosition().add(objekt.getVelocity());
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
        if (objekt.getPosition().getY() >= 768 || objekt.getPosition().getY() <= 0) {
            objekt.getPosition().setY(objekt.getPosition().getY() * -1);
        }
    }
}
