import aktoeren.Kreis;
import frame.Szene;
import objektManager.KreiseManager;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import vektorPackage.Vektor2D;
import verhalten.VerhaltenSchwarm;
import verhalten.VerhaltenYBewegungMitWind;

import java.util.concurrent.ThreadLocalRandom;

public class WeltMehrererKreise extends Szene {
    //public Kreis kreis;
    public KreiseManager kreiseManager;

    public WeltMehrererKreise() {
        super();
        kreiseManager = KreiseManager.getExemplar();
        generiereKreise(10);
        initialisiereVerhaltenFuerAlle();
        //this.kreis = new Kreis(50, new Vektor2D(30, 40), new Vektor2D(0, 1));
        //this.kreis.setVerhalten(new VerhaltenYBewegungMitWind(this.kreis));
    }

    private void initialisiereVerhaltenFuerAlle() {
        for (int i = 0; i < kreiseManager.getAnzahlAllerKreise(); i++) {
            kreiseManager.getKreis(i).setVerhalten(new VerhaltenSchwarm(kreiseManager.getKreis(i)));
        }
    }

    private void generiereKreise(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            this.kreiseManager.registriereKreis(new Kreis(i, (float) ThreadLocalRandom.current().
                                                nextDouble(0.2, 10.0), new Vektor2D(ThreadLocalRandom.current().nextDouble(0.0, 800.0),
                                                             ThreadLocalRandom.current().nextDouble(0.0, 600.0)), new Vektor2D(0,0)));
        }
    }

    public void renderLoop() {
        while (!Display.isCloseRequested()) {
            GL11.glClearColor(0.1F, 0.2F, 0.3F, 1.0F);
            GL11.glClear(16384);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, 640.0D, 480.0D, 0.0D, 0.0D, 1.0D);
            GL11.glMatrixMode(5888);
            GL11.glDisable(2929);
            for (int i = 0; i < kreiseManager.getAnzahlAllerKreise(); i++) {
                kreiseManager.getKreis(i).render();
                kreiseManager.getKreis(i).update();
                //GL11.glVertex2d(kreiseManager.getKreis(i).xPos, kreiseManager.getKreis(i).yPos);
            }
            //this.kreis.render();
            //this.kreis.update();
            Display.update();
        }
    }

    public static void main(String[] args) {
        (new WeltMehrererKreise()).start();
    }

}
