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
    }

}
