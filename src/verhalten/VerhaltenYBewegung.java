package verhalten;

import aktoeren.BewegendesObjekt;
import exceptions.VektorOverflowException;
import vektorPackage.Vektor;
import vektorPackage.Vektor2D;

public class VerhaltenYBewegung implements Verhalten {
    protected BewegendesObjekt objekt;
    private Vektor2D yBewegung;

    public VerhaltenYBewegung(BewegendesObjekt objekt) {
        this.objekt = objekt;
        this.yBewegung = new Vektor2D(0, 1);
    }

    public VerhaltenYBewegung() {
    }

    public void update() {
        try {
            objekt.setPosition((Vektor2D) objekt.getPosition().add(yBewegung));
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
        if (objekt.yPos >= 500 || objekt.yPos <= 0) {
            yBewegung.setY(yBewegung.getY() * -1);
        }
    }
}
