
import java.util.ResourceBundle;
import info.util.javafx.FXUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Classe contrôleur pour l'interface décrite dans le document <b>colorgenerator.fxml</b>.
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
        this.colorzone.setStyle("-fx-background-color: rgb(0,0,0);");
        this.colorname.setText("Black");
        this.colorrgb.setText("(0,0,0)");
        this.colorhex.setText("#000000");
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
    
    @FXML
    public void onGenerate(){
        Couleur c = Couleur.generateRandom();
        this.colorzone.setStyle("-fx-background-color: rgb(" + c.getR() + "," + c.getG() + "," + c.getB() + ");");
        this.colorrgb.setText("(" + c.getR() + "," + c.getG() + "," + c.getB() + ")");
        this.colorhex.setText(c.getHexa());
    }

}
