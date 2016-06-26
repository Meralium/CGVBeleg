package verhalten;

import aktoeren.BewegendesObjekt;
import exceptions.VektorOverflowException;
import vektorPackage.Vektor2D;

public class VerhaltenYBewegungMitWind extends VerhaltenYBewegung implements Verhalten {
    protected Vektor2D wind;
    private Vektor2D yBewegung;

    public VerhaltenYBewegungMitWind(BewegendesObjekt objekt) {
        super(objekt);
        this.wind = new Vektor2D(0.5, 0);
        this.yBewegung = new Vektor2D(0, 0.5);
    }

    public void update() {
        try {
            objekt.setPosition((Vektor2D) objekt.getPosition().add(objekt.getVelocity()));
            objekt.setPosition((Vektor2D) objekt.getPosition().add(yBewegung));
            objekt.setPosition((Vektor2D) objekt.getPosition().add(this.wind));
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
        if (objekt.yPos >= 600 || objekt.yPos <= 0) {
            yBewegung.setY(yBewegung.getY() * -1);
        }
        if (objekt.xPos >= 800 || objekt.xPos <= 0) {
            this.wind.setX(this.wind.getX() * -1);
        }
    }
}