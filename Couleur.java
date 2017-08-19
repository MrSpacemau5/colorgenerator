/**
 * Classe en charge de la couleur
 * 
 * @author  Maxence Marchand, aka MrSpacemau5
 * @version 19/08/2017
 */

public class Couleur {
    private int r;
    private int g;
    private int b;

    /**
     * Constructeur
     *
     * @param r La valeur de rouge de la couleur
     * @param g La valeur de vert de la couleur
     * @param b La valeur de bleu de la couleur
     */
    public Couleur(int r, int g, int b){
        this.r=r;
        this.g=g;
        this.b=b;
    }

    /**
     * Accesseur au rouge de la couleur
     *
     * @return la valeur de rouge de la couleur
     */
    public int getR(){
        return this.r;
    }

    /**
     * Accesseur au vert de la couleur
     *
     * @return la valeur de vert de la couleur
     */
    public int getG(){
        return this.g;
    }

    /**
     * Accesseur au bleu de la couleur
     *
     * @return la valeur de bleu de la couleur
     */
    public int getB(){
        return this.b;
    }

    /**
     * Méthode qui génère une couleur aléatoire
     *
     * @return la couleur aléatoire
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
     * Méthode qui retourne le code héxadécimal de la couleur
     *
     * @return le code héxadécimal de la couleur
     */
    public String getHexa(){
        String hex = String.format("#%02X%02X%02X", this.r, this.g, this.b); 
        return hex;
    }
}
