package aktoeren;

import vektorPackage.Vektor2D;
import verhalten.Verhalten;
import verhalten.VerhaltenYBewegung;

public abstract class BewegendesObjekt extends BasisObjekt {

    public Vektor2D getVelocity() {
        return velocity;
    }

    private Verhalten verhalten = null;
    protected Vektor2D velocity;

    public BewegendesObjekt() {
        super();
        setVelocity(new Vektor2D(1, 0));
        setVerhalten(new VerhaltenYBewegung(this));
    }

    public BewegendesObjekt(int id, Vektor2D position, Vektor2D velocity) {
        super(id, position);
        this.velocity = new Vektor2D(velocity);
    }

    public void setVerhalten(Verhalten verhalten) {
        this.verhalten = verhalten;
    }

    public Verhalten getVerhalten() {
        return this.verhalten;
    }

    public void setVelocity(Vektor2D velocity) {
        this.velocity = velocity;
    }

    public void update() {
        if (verhalten != null) {
            verhalten.update();
        }
    }

}
