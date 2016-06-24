package verhalten;

import aktoeren.BewegendesObjekt;
import exceptions.VektorOverflowException;
import vektorPackage.Vektor2D;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Meralium on 24.06.16.
 */
public class VerhaltenChaotisch implements Verhalten {
    protected BewegendesObjekt objekt;

    public VerhaltenChaotisch(BewegendesObjekt objekt) {
        this.objekt = objekt;
    }

    public VerhaltenChaotisch() {
    }

    @Override
    public void update() {
        try {
            objekt.setVelocity(new Vektor2D(ThreadLocalRandom.current().nextDouble(0.5,30.0),ThreadLocalRandom.current().nextDouble(0.5,30.0)));
            objekt.setPosition((Vektor2D) objekt.getPosition().add(objekt.getVelocity()));
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
        if (objekt.yPos >= 500 || objekt.yPos <= 0) {
            objekt.getVelocity().setY(objekt.getVelocity().getY() * -1);
        }
        if (objekt.xPos >= 600 || objekt.xPos <= 0) {
            objekt.getVelocity().setX(objekt.getVelocity().getX() * -1);
        }
    }
}
