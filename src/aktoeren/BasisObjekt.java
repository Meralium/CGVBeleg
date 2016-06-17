package aktoeren;

import vektorPackage.Vektor;
import vektorPackage.Vektor2D;

public abstract class BasisObjekt {

    private int id;
    protected Vektor2D position;
    public float xPos;
    public float yPos;

    public Vektor2D getPosition() {
        return position;
    }

    public void setPosition(Vektor2D position) {
        this.position.setPosition(position.getX(), position.getY());
        this.xPos = (float) this.position.getX();
        this.yPos = (float) this.position.getY();
    }

    public int getId() {
        return id;
    }

    public BasisObjekt() {
        this(new Vektor2D(0, 0));
    }

    public BasisObjekt(Vektor2D position) {
        this.position = position;
        this.xPos = (float) this.position.getX();
        this.yPos = (float) this.position.getY();
    }

    public abstract void render();

}
