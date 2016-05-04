import exceptions.VektorOverflowException;
import vektorPackage.Vektor2D;
import vektorPackage.Vektor3D;
import vektorPackage.*;

public class Main {

    public static void main(String agrs[]) throws VektorOverflowException{
        Vektor3D vek = new Vektor3D(1,1,1);
        Vektor3D vek1 = new Vektor3D(3, 3, 3);
        Vektor3D vek2 = (Vektor3D) LineareAlgebra.add(vek, vek1);
        System.out.println(vek.toString());
        System.out.println(vek1.toString());
        System.out.println(vek2.toString());
    }

}