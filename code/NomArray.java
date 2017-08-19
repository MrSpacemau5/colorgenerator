
/**
 * Classe contenant l'arry de noms
 * 
 * @author  Maxence Marchand, aka MrSpacemau5
 * @version 19/08/2017
 */
import java.util.ArrayList;
import java.util.Collections;
public class NomArray {
    private ArrayList<String> array;

    /**
     * Constructeur
     *
     */
    public NomArray(){
        array = new ArrayList<String>();
        this.fill();
    }

    /**
     * Méthode qui remplit l'array avec les noms donnés
     *
     */
    public void fill(){
        Collections.addAll(this.array,"Wave", "Cloud", "Road", "Alarm", "Sheet", "Love", "Hate", "Feeling",
            "Life", "Death", "Light", "Darkness", "Screen", "Body", "Sea", "Land", "Sign", "Network", "Fruit",
            "Liquid", "Block", "Wall", "Bed", "Wood", "Iron", "Gold", "Ring", "Square", "Flower", "Happiness",
            "Sadness", "Sky", "Planet", "Star", "Golem", "Path", "Galaxy", "Ace", "Daughter", "Son", "Wanderer",
            "Tree", "Plant", "Power", "Weakness", "Animal", "Paper", "Picture", "Control", "Ball", "Item", "Generation");
    }

    /**
     * Méthode qui retourne un nom aléatoire contenu dans la liste
     *
     * @return un nom aléatoire compris dans la liste
     */
    public String getRandomNom(){
        java.util.Random r = new java.util.Random();
        int low = 0;
        int high = this.array.size();
        int index = r.nextInt(high-low) + low;
        String res = this.array.get(index);
        return res;
    }
}
