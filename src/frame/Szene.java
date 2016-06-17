package frame;

import frame.BasisFenster;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

public class Szene extends BasisFenster {

    public Szene() {
        super("Schwarmverhalten-Szene", 800, 600);
    }

    @Override
    public void renderLoop() {
        while (!Display.isCloseRequested()) {
            glClearColor(0.1f, 0.2f, 0.3f, 1);
            glClear(GL_COLOR_BUFFER_BIT);

            // ist ja 2d
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, 640, 480, 0, 0, 1);
            glMatrixMode(GL_MODELVIEW);
            glDisable(GL_DEPTH_TEST);

            // gelber Ball
            glColor3d(1, 1, 0);

            /*glBegin(GL_TRIANGLE_FAN);
            glVertex2f(xPos, yPos);
            for (int angle = 0; angle < 360; angle += 5) {
                glVertex2f(xPos + (float) Math.sin(angle) * 20.0f, yPos + (float) Math.cos(angle) * 20.0f);
            }
            glEnd();

            // Position in Abhängigkeit zu Beschleunigung
            yPos = yPos + ySpeed;

            // an den Rändern Richtung umkehren
            if (yPos > 480 || yPos < 0)
                ySpeed = ySpeed * -1;

            Display.update();*/
        }
    }

}
