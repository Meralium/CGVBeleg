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
public class VerhaltenCursorFolgen implements Verhalten {

    private Kreis kreis;
    private Vektor2D help;
    private Vektor2D force;

    public VerhaltenCursorFolgen(Kreis kreis) {
        this.force = new Vektor2D(0, 0);
        this.help = new Vektor2D(0, 0);
        this.kreis = kreis;
    }
    public void applyForce(Vektor2D force) throws VektorOverflowException {
        Vektor2D forceHelp = new Vektor2D(force);
        this.force.add(forceHelp);
    }

    public Vektor2D seek(Vektor2D target) {
        try {
            this.help.setPosition((Vektor2D) LineareAlgebra.sub(target, this.kreis.getPosition()));
            this.help.normalize();
            this.help.mult(kreis.getMaxVelocity());
            this.help.sub(kreis.getVelocity());
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
        return this.help;
    }

    @Override
    public void update() {
        try {
            applyForce(seek(new Vektor2D((float)Mouse.getX(), (float)(Display.getDisplayMode().getHeight() - Mouse.getY()))));
            kreis.setVelocity((Vektor2D) LineareAlgebra.add(kreis.getVelocity(), force));
            if (kreis.getVelocity().length() > kreis.getMaxVelocity()) {
                kreis.setVelocity((Vektor2D) kreis.getVelocity().normalize().mult(kreis.getMaxVelocity()));
            }
            //System.out.println(kreis.getVelocity().getX() + "  " + kreis.getVelocity().getY());
            kreis.setPosition((Vektor2D) LineareAlgebra.add(kreis.getPosition(), kreis.getVelocity()));
            kreis.setVelocity((Vektor2D) kreis.getVelocity().truncate(10.0F));
            force.mult(0.0);
        } catch (VektorOverflowException e) {
            e.printStackTrace();
        }
    }

}
