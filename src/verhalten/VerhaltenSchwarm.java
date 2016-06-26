package verhalten;

import aktoeren.BasisObjekt;
import aktoeren.Kreis;
import exceptions.VektorOverflowException;
import objektManager.KreiseManager;
import vektorPackage.LineareAlgebra;
import vektorPackage.Vektor2D;

import javax.xml.bind.ValidationException;

/**
 * Created by Meralium on 26.06.16.
 */
public class VerhaltenSchwarm implements Verhalten {

    private Kreis kreis;
    private KreiseManager kreiseManager = KreiseManager.getExemplar();
    private double separationDist = 1000.0;
    private Vektor2D help;
    private Vektor2D force;

    public VerhaltenSchwarm(Kreis kreis) {
        this.force = new Vektor2D(0, 0);
        this.kreiseManager = KreiseManager.getExemplar();
        this.help = new Vektor2D();
        this.kreis = kreis;
    }

    public Vektor2D separation() {
        Vektor2D steeringForce = new Vektor2D(0, 0);
        for (int i = 0; i < kreiseManager.getAnzahlAllerKreise(); i++) {
            if (kreis.getId() == i)
                continue;
            Kreis bObj = kreiseManager.getKreis(i);
            try {
                if (LineareAlgebra.euklDistance(kreis.getPosition(), bObj.getPosition()) < separationDist) {
                    this.help.setPosition((Vektor2D) LineareAlgebra.sub(kreis.getPosition(), bObj.getPosition()));
                    double length = help.length();
                    help.normalize();
                    help.div(length);
                    steeringForce.add(help);
                }
            } catch (VektorOverflowException e) {
                e.printStackTrace();
            }
        }
        return steeringForce;
    }

    public Vektor2D alignment() throws VektorOverflowException {
        Vektor2D steeringForce = new Vektor2D(0, 0);
        int count = 0;
        for (int i = 0; i < kreiseManager.getAnzahlAllerKreise(); i++) {
            if (kreis.getId() == i)
                continue;
            Kreis bObj = kreiseManager.getKreis(i);
            if (LineareAlgebra.euklDistance(kreis.getPosition(), bObj.getPosition()) < separationDist) {
                steeringForce.add(bObj.getVelocity());
                count++;
            }
        }
        if (count > 0) {
            steeringForce.div(count);
            steeringForce.sub(kreis.getVelocity());
        }
        return steeringForce;
    }

    public Vektor2D cohesion() throws VektorOverflowException {
        Vektor2D steeringForce = new Vektor2D(0, 0);
        int count = 0;
        for (int i = 0; i < kreiseManager.getAnzahlAllerKreise(); i++) {
            if (kreis.getId() == i) continue;
            Kreis bObj = kreiseManager.getKreis(i);
            steeringForce.add(bObj.getPosition());
            count++;
        }
        steeringForce.div(count);
        steeringForce.sub(kreis.getPosition());
        return steeringForce;
    }

    @Override
    public void update() {
        try {
            force.add(separation());
            //force.add(alignment());
            //force.add(cohesion());
            kreis.getVelocity().add(force);
            if (kreis.getVelocity().length() > kreis.getMaxVelocity()) {
                kreis.setVelocity((Vektor2D) kreis.getVelocity().normalize().mult(kreis.getMaxVelocity()));
            }
            System.out.println(kreis.getVelocity().getX() + "  " + kreis.getVelocity().getY());
            kreis.setPosition((Vektor2D) LineareAlgebra.add(kreis.getPosition(), kreis.getVelocity()));
            kreis.setVelocity((Vektor2D) kreis.getVelocity().mult(0.0));
            if (kreis.getPosition().getY() >= 500)
                kreis.setPosition(600 - kreis.getPosition().getX(), 0.0);
            if (kreis.getPosition().getY() <= 0)
                kreis.setPosition(600 - kreis.getPosition().getX(), 500);
            if (kreis.getPosition().getX() >= 600)
                kreis.setPosition(0.0, 500 - kreis.getPosition().getY());
            if (kreis.getPosition().getX() <= 0)
                kreis.setPosition(600, 500 - kreis.getPosition().getY());
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
    }

}
