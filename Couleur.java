
/**
 * Vous pouvez décrire votre classe color ici
 * 
 * @author  Indiquez votre nom
 * @version Indiquez la date
 */
import java.awt.Color;

public class Couleur {
    private int r;
    private int g;
    private int b;

    public Couleur(int r, int g, int b){
        this.r=r;
        this.g=g;
        this.b=b;
    }

    public int getR(){
        return this.r;
    }

    public int getG(){
        return this.g;
    }

    public int getB(){
        return this.b;
    }

    public Color getColor(){
        return new Color(this.r, this.g, this.b);
    }

    public static Couleur generateRandom(){
        java.util.Random r = new java.util.Random();
        int low = 0;
        int high = 256;
        int red = r.nextInt(high-low) + low;
        int green = r.nextInt(high-low) + low;
        int blue = r.nextInt(high-low) + low;
        Couleur res = new Couleur(red, green, blue);
        return res;
    }
    
    public String getHexa(){
        String hex = String.format("#%02X%02X%02X", this.r, this.g, this.b); 
        return hex;
    }
}
