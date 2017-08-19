
/**
 * Vous pouvez décrire votre classe Noun ici
 * 
 * @author  Indiquez votre nom
 * @version Indiquez la date
 */
import java.util.ArrayList;
import java.util.Collections;
public class AdjectifArray {
    private ArrayList<String> array;

    public AdjectifArray(){
        array = new ArrayList<String>();
        this.fill();
    }
    
    public void fill(){
        Collections.addAll(this.array,"Dark", "Bright", "Delicious", "Mysterious", "Strong", "Natural", "Industrial",
        "Cloudy", "Classy", "Eerie", "Energic", "Fake", "Clear", "Rusted", "Alien", "Filthy", "Obnoxious",
        "Obvious", "Underground", "Mainstream", "Manly", "Windy", "Gradient", "Childish", "Beloved",
        "Dutch", "German", "French", "Navy", "Army", "Deadly", "Lethal", "Lazy", "Active", "Noisy", "Powerful",
        "Weak", "Weekly", "Moving", "Apprentice", "Dusty", "Marine", "Connected", "Spinning", "Genius", "Unknown");
    }
    
    public String getRandomAdjectif(){
        java.util.Random r = new java.util.Random();
        int low = 0;
        int high = this.array.size();
        int index = r.nextInt(high-low) + low;
        String res = this.array.get(index);
        return res;
    }

}
