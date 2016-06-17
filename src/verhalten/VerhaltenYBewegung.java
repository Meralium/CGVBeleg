package verhalten;

import aktoeren.BewegendesObjekt;
import exceptions.VektorOverflowException;
import vektorPackage.Vektor2D;

public class VerhaltenYBewegung implements Verhalten {
    private BewegendesObjekt objekt;
    private Vektor2D wind;

    public VerhaltenYBewegung(BewegendesObjekt objekt) {
        this.objekt = objekt;
        this.wind = new Vektor2D(0.1, 0);
    }

    public void update() {
        try {
            objekt.setPosition((Vektor2D) objekt.getPosition().add(objekt.getVelocity()));
            objekt.setPosition((Vektor2D) objekt.getPosition().add(this.wind));
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
        if (objekt.yPos >= 500 || objekt.yPos <= 0) {
            objekt.getVelocity().setY(objekt.getVelocity().getY() * -1);
        }
        if (objekt.xPos >= 700 || objekt.xPos <= 0) {
            this.wind.setX(this.wind.getX() * -1);
        }
    }
}
