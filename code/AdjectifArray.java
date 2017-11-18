
/**
 * Class with array of adjectives, for the random name.
 * 
 * @author  MrSpacemau5
 * @version 19/08/2017
 */
import java.util.ArrayList;
import java.util.Collections;
public class AdjectifArray {
    private ArrayList<String> array;

    /**
     * Constructor
     *
     */
    public AdjectifArray(){
        array = new ArrayList<String>();
        this.fill();
    }
    
    /**
     * Method filling the array.
     *
     */
    public void fill(){
        Collections.addAll(this.array,"Dark", "Bright", "Delicious", "Mysterious", "Strong", "Natural", "Industrial",
        "Cloudy", "Classy", "Eerie", "Energic", "Fake", "Clear", "Rusted", "Alien", "Filthy", "Obnoxious",
        "Obvious", "Underground", "Mainstream", "Manly", "Windy", "Gradient", "Childish", "Beloved",
        "Dutch", "German", "French", "Navy", "Army", "Deadly", "Lethal", "Lazy", "Active", "Noisy", "Powerful",
        "Weak", "Weekly", "Moving", "Apprentice", "Dusty", "Marine", "Connected", "Spinning", "Genius", "Unknown");
    }
    
    /**
     * Method returning a random adjective from the array.
     *
     * @return a random adjective from the array
     */
    public String getRandomAdjectif(){
        java.util.Random r = new java.util.Random();
        int low = 0;
        int high = this.array.size();
        int index = r.nextInt(high-low) + low;
        String res = this.array.get(index);
        return res;
    }

}
