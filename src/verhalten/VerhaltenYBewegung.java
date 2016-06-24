package verhalten;

import aktoeren.BewegendesObjekt;
import exceptions.VektorOverflowException;
import vektorPackage.Vektor2D;

public class VerhaltenYBewegung implements Verhalten {
    protected BewegendesObjekt objekt;

    public VerhaltenYBewegung(BewegendesObjekt objekt) {
        this.objekt = objekt;
    }

    public VerhaltenYBewegung() {
    }

    public void update() {
        try {
            objekt.setPosition((Vektor2D) objekt.getPosition().add(objekt.getVelocity()));
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
        if (objekt.yPos >= 500 || objekt.yPos <= 0) {
            objekt.getVelocity().setY(objekt.getVelocity().getY() * -1);
        }
    }
}
