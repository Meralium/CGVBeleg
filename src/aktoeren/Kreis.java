package aktoeren;

import vektorPackage.Vektor2D;

import java.util.concurrent.ThreadLocalRandom;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Kreis extends BewegendesObjekt {

    private double radius;
    private double r, g, b;

    public Kreis() {
        super(0, new Vektor2D(50, 50), new Vektor2D(0, 1), 0.1);
        this.radius = 10;
        this.r = 1;
        this.g = 0;
        this.b = 0;
    }

    public Kreis(int id, double radius, Vektor2D position, Vektor2D velocity) {
        super(id, position, velocity, 0.1);
        this.radius = radius;
        this.r = ThreadLocalRandom.current().nextDouble(0, 1);
        this.g = ThreadLocalRandom.current().nextDouble(0, 1);
        this.b = ThreadLocalRandom.current().nextDouble(0, 1);
    }


    @Override
    public void render() {
        glColor3d(r, g, b);
        glBegin(GL_TRIANGLE_FAN);
        glVertex2f(xPos, yPos);
        for (int angle = 0; angle < 360; angle += 1) {
            glVertex2f(xPos + (float) Math.sin(angle) * (float)this.radius, yPos + (float) Math.cos(angle) * (float)this.radius);
        }
        glEnd();
    }
}
