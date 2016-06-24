import aktoeren.Kreis;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import frame.Szene;
import vektorPackage.Vektor2D;
import verhalten.VerhaltenYBewegung;
import verhalten.VerhaltenYBewegungMitWind;

public class WeltEinesObjektes extends Szene {
    public Kreis kreis;

    public WeltEinesObjektes(){
        super();
        this.kreis = new Kreis(50, new Vektor2D(30, 40), new Vektor2D(0, 1));
        this.kreis.setVerhalten(new VerhaltenYBewegungMitWind(this.kreis));
    }

    public void renderLoop() {
        while(!Display.isCloseRequested()) {
            GL11.glClearColor(0.1F, 0.2F, 0.3F, 1.0F);
            GL11.glClear(16384);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, 640.0D, 480.0D, 0.0D, 0.0D, 1.0D);
            GL11.glMatrixMode(5888);
            GL11.glDisable(2929);
            this.kreis.render();
            this.kreis.update();
            Display.update();
        }
    }

    public static void main(String[] args) {
        (new WeltEinesObjektes()).start();
    }

}
