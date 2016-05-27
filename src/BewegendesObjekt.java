import vektorPackage.Vektor2D;

public abstract class BewegendesObjekt extends BasisObjekt {
    public Vektor2D getVelocity() {
        return velocity;
    }

    private Vektor2D velocity;
    private Verhalten verhalten = null;

    public BewegendesObjekt(Vektor2D position, Vektor2D velocity) {
        super(position);
        this.velocity.setVek(velocity.getVek());
    }

    public void setVerhalten(Verhalten verhalten) {
        this.verhalten = verhalten;
    }
    public Verhalten getVerhalten(){
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
