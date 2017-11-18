/**
 * Class for the color
 * 
 * @author  MrSpacemau5
 * @version 19/08/2017
 */

public class Couleur {
    private int r;
    private int g;
    private int b;

    /**
     * Constructor
     *
     * @param r red value
     * @param g green value
     * @param b blue value
     */
    public Couleur(int r, int g, int b){
        this.r=r;
        this.g=g;
        this.b=b;
    }

    /**
     * Red value getter
     *
     * @return red value
     */
    public int getR(){
        return this.r;
    }

    /**
     * Green value getter
     *
     * @return green value
     */
    public int getG(){
        return this.g;
    }

    /**
     * Blue value getter
     *
     * @return blue value
     */
    public int getB(){
        return this.b;
    }

    /**
     * Generates a random color
     *
     * @return a random color
     */
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

    /**
     * Returns the hexa code of the color
     *
     * @return hexa code of the color
     */
    public String getHexa(){
        String hex = String.format("#%02X%02X%02X", this.r, this.g, this.b); 
        return hex;
    }

    /**
     * red value setter
     *
     * @param r red value
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * green value setter
     *
     * @param g green value
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * blue value setter
     *
     * @param b blue value
     */
    public void setB(int b) {
        this.b = b;
    }
}
