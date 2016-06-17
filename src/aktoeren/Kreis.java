package aktoeren;

import vektorPackage.Vektor2D;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Kreis extends BewegendesObjekt {

    private float radius;

    public Kreis() {
        super(new Vektor2D(50, 50), new Vektor2D(0, 1));
        this.radius = 10;
    }

    public Kreis(float radius, Vektor2D position, Vektor2D velocity){
        super(position, velocity);
        this.radius = radius;
    }

    //radius = 10
    @Override
    public void render() {
        glColor3d(1, 0, 0);
        glBegin(GL_TRIANGLE_FAN);
        glVertex2f(xPos, yPos);
        for (int angle=0; angle<360; angle+=5) {
            glVertex2f(xPos + (float)Math.sin(angle) * 10, yPos + (float)Math.cos(angle) * 10);
        }
        glEnd();
    }
}
