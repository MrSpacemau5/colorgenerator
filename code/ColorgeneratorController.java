/**
 * Classe contrôleur (FR)
 * 
 * @author  Maxence Marchand, aka MrSpacemau5
 * @version 19/08/2017
 */

import java.util.ResourceBundle;
import info.util.javafx.FXUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.image.WritableImage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import javafx.stage.FileChooser;
import java.awt.image.RenderedImage;
import java.io.IOException;

/**
 * Classe contrôleur pour l'interface décrite dans le document <b>colorgenerator.fxml</b>.(FR)
 *
 * Cette classe contient principalement les méthodes appelées en réaction aux événements utilisateur.
 * Une instance de cette classe est créée automatiquement chaque fois que le document <b>colorgenerator.fxml</b> est chargé.
 */
public class ColorgeneratorController {
    @FXML
    private Stage stage;
    private ResourceBundle bundle;
    @FXML
    private AnchorPane imagezone;
    @FXML
    private AnchorPane buttonzone;
    @FXML
    private Button generatebutton;
    @FXML
    private Button exportbutton;
    @FXML
    private Pane colorzone;
    @FXML
    private Label colorname;
    @FXML
    private Label colorrgb;
    @FXML
    private Label colorhex;
    @FXML
    private Button userInputButton;
    @FXML
    private TextField userInput;
    @FXML
    private TextField redValue;
    @FXML
    private TextField greenValue;
    @FXML
    private TextField blueValue;

    private NomArray noms;
    private AdjectifArray adjectifs;
    private boolean colorsaved;
    private String uiName;
    Couleur c;
    /**
     * Constructeur.
     */
    public ColorgeneratorController() {
        this.bundle = ResourceBundle.getBundle("colorgenerator");
    }

    /**
     * Méthode invoquée automatiquement après instanciation de ce contrôleur par JavaFX.
     */
    @FXML
    protected void initialize() {
    	this.c = new Couleur (0,0,0);
    	this.colorzone.setStyle("-fx-background-color: rgb(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ");");
        this.colorrgb.setText("(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ")");
        this.colorhex.setText(this.c.getHexa());
        this.colorname.setText("Black");
        this.noms = new NomArray();
        this.adjectifs = new AdjectifArray();
        this.redValue.setText(""+c.getR());
        this.greenValue.setText(""+this.c.getG());
        this.blueValue.setText(""+this.c.getB());
        
    }

    /**
     * Méthode invoquée lorsque la fenêtre dont la scène est associée à ce contrôleur
     * est affichée.
     * Si nécessaire, complétez cette méthode pour exécuter du code après l'affichage de
     * la fenêtre.
     */
    @FXML
    public void onWindowShown() {

    }

    /**
     * Méthode invoquée lorsque la fenêtre dont la scène est associée à ce contrôleur
     * est sur le point d'être fermée par le système.
     * Si nécessaire, complétez cette méthode pour autoriser/empêcher la fermeture
     * de la fenêtre.
     * 
     * @return {@code true} si la fenêtre peut être fermée, ou {@code false}
     *         sinon (par exemple pour permettre à l'utilisateur d'enregistrer
     *         un document).
     * 
     */
    @FXML
    public boolean onWindowCloseRequest() {
        return true;
    }

    /**
     * Méthode qui génère une couleur aléatoire, son code RGB et héxadécimal, ainsi qu'un nom aléatoire.
     * Invoquée lorsque l'on clique sur "generate".
     *
     */
    @FXML
    public void onGenerate(){
    	if(!this.colorsaved) {
    		this.colorname.setText(this.adjectifs.getRandomAdjectif() + " " + this.noms.getRandomNom());
    	}
    	else {
    		this.colorname.setText(uiName);
    	}
        c = Couleur.generateRandom();
        this.colorzone.setStyle("-fx-background-color: rgb(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ");");
        this.colorrgb.setText("(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ")");
        this.colorhex.setText(this.c.getHexa());
        this.redValue.setText(""+c.getR());
        this.greenValue.setText(""+this.c.getG());
        this.blueValue.setText(""+this.c.getB());
    }

    /**
     * Méthode qui exporte la couleur générée en image png.
     * Invoquée lorsque l'on clique sur "export as image".
     *
     */
    @FXML
    public void export(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        File file = fileChooser.showSaveDialog(null);
        if(file != null){
            try {
                WritableImage writableImage = new WritableImage((int)this.imagezone.getWidth(),(int)this.imagezone.getHeight());
                this.imagezone.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
    
    @FXML
    public void onUserInput() {
    	if(!this.userInput.getText().isEmpty()) {
    		this.colorname.setText(this.userInput.getText());
    	}
    	else {
    		this.colorname.setText(this.adjectifs.getRandomAdjectif() + " " + this.noms.getRandomNom());
    		this.colorsaved=false;
    	}
    	this.colorsaved=true;
    }
    
    @FXML
    public void onCustomColor() {
    	boolean resr = false;
    	boolean resg = false;
    	boolean resb=false;
    	resr = CheckValue.checkValue(this.redValue.getText());
    	resg = CheckValue.checkValue(this.greenValue.getText());
    	resb = CheckValue.checkValue(this.blueValue.getText());

    	if(resr && resg && resb) {
    		this.c.setR(Integer.parseInt(this.redValue.getText()));
    		this.c.setG(Integer.parseInt(this.greenValue.getText()));
    		this.c.setB(Integer.parseInt(this.blueValue.getText()));
    		this.colorzone.setStyle("-fx-background-color: rgb(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ");");
            this.colorrgb.setText("(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ")");
            this.colorhex.setText(this.c.getHexa());
    	}
    }
}

