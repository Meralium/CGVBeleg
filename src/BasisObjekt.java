import vektorPackage.Vektor2D;

public abstract class BasisObjekt {

    private int id;
    private Vektor2D position;

    public Vektor2D getPosition() {
        return position;
    }
    public int getId() {
        return id;
    }

    public BasisObjekt() {
        this(new Vektor2D(0, 0));
    }

    public BasisObjekt(Vektor2D position) {
        this.position = position;
    }

    public abstract void render();

}
