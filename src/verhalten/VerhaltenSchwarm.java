package verhalten;

import aktoeren.BasisObjekt;
import aktoeren.Kreis;
import exceptions.VektorOverflowException;
import objektManager.KreiseManager;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import vektorPackage.LineareAlgebra;
import vektorPackage.Vektor2D;

import javax.xml.bind.ValidationException;

/**
 * Created by Meralium on 26.06.16.
 */
public class VerhaltenSchwarm implements Verhalten {

    private Kreis kreis;
    private KreiseManager kreiseManager = KreiseManager.getExemplar();
    private Vektor2D help;
    private Vektor2D force;
    private Steuerung steuerung;

    public VerhaltenSchwarm(Kreis kreis) {
        this.force = new Vektor2D(0, 0);
        this.kreiseManager = KreiseManager.getExemplar();
        this.help = new Vektor2D();
        this.kreis = kreis;
        this.steuerung = new Steuerung();
    }

    @Override
    public void update() {
        try {

            steuerung.anwendeForce(steuerung.folgeZeil(kreis), kreis);
            //steuerung.anwendeForce(new Vektor2D(0, 0.1 * kreis.getMass()), kreis);
            //steuerung.anwendeForce(steuerung.separation(this.kreis),kreis);
            //steuerung.anwendeForce(steuerung.cohesion(kreis), kreis);
            //steuerung.anwendeForce(steuerung.alignment(kreis), kreis);

            //force.add(separation());
            //force.add(alignment());
            kreis.getVelocity().add(steuerung.steuerungForce);
            if (kreis.getVelocity().length() > kreis.getMaxVelocity()) {
                kreis.setVelocity((Vektor2D) kreis.getVelocity().normalize().mult(kreis.getMaxVelocity()));
            }
            //System.out.println(kreis.getVelocity().getX() + "  " + kreis.getVelocity().getY());
            kreis.getVelocity().truncate(10.0F);
            kreis.setPosition((Vektor2D) LineareAlgebra.add(kreis.getPosition(), kreis.getVelocity()));
            steuerung.steuerungForce.mult(0.0);

        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
    }

}
