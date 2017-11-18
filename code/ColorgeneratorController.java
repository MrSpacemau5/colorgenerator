/**
 * Controller class
 * 
 * @author  MrSpacemau5
 * @version 18/11/2017
 */

import java.util.ResourceBundle;
import javafx.fxml.FXML;

import javafx.stage.Stage;

import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.image.WritableImage;

import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import javafx.stage.FileChooser;
import java.awt.image.RenderedImage;
import java.io.IOException;

/**
 * Controller class for the interface written in the  <b>colorgenerator.fxml</b> document
 *
 * Contains mostly methods called by user interactions
 * An instance of this class is automatically created when the <b>colorgenerator.fxml</b> document is loaded
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
     * Constructor
     */
    public ColorgeneratorController() {
        this.bundle = ResourceBundle.getBundle("colorgenerator");
    }

    /**
     * Method called only after an object has been instanciated
     */
    @FXML
    protected void initialize() {
    	this.c = new Couleur (0,0,0);
    	this.actualize();
        this.colorname.setText("Black");
        this.noms = new NomArray();
        this.adjectifs = new AdjectifArray();
        this.redValue.setText(""+c.getR());
        this.greenValue.setText(""+this.c.getG());
        this.blueValue.setText(""+this.c.getB());
        
    }

    /**
     * Method called whenever the window is shown (useless)
     */
    @FXML
    public void onWindowShown() {

    }

    /**
     * Method called whenever a close is requested
     * 
     * @return {@code true} if the window can be closed, {@code false}
     *         otherwise
     * 
     */
    @FXML
    public boolean onWindowCloseRequest() {
        return true;
    }

    /**
     * Generates a random color, with a random name if the user hasn't saved a custom name
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
        this.actualize();
        this.redValue.setText(""+c.getR());
        this.greenValue.setText(""+this.c.getG());
        this.blueValue.setText(""+this.c.getB());
    }

    /**
     * Exports a png image with color
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
    
    /**
     * Method called when the user wants to save a custom name
     *
     */
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
    
    /**
     * Method called when the user enters custom values for the color.
     * A pop-up is shown when he enters an invalid value
     *
     */
    @FXML
    public void onCustomColor() {
    	boolean resr = false;
    	boolean resg = false;
    	boolean resb=false;
    	String redText="";
    	String greenText="";
    	String blueText="";
    	try {
    		redText=this.redValue.getText();
    		greenText=this.greenValue.getText();
    		blueText=this.blueValue.getText();
    		resr = CheckValue.checkValue(redText);
    		resg = CheckValue.checkValue(greenText);
    		resb = CheckValue.checkValue(blueText);

    		if(resr && resg && resb) {
    			this.c.setR(Integer.parseInt(redText));
    			this.c.setG(Integer.parseInt(greenText));
    			this.c.setB(Integer.parseInt(blueText));
    			this.actualize();
    			
    		}
    	}
    	catch(NumberFormatException e) {
    		JOptionPane.showMessageDialog(null, "Invalid input. \n Please enter an integer between 0 and 255");
    	}
    }
    
    /**
     * Actualizes the color's data
     *
     */
    public void actualize() {
    	this.colorzone.setStyle("-fx-background-color: rgb(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ");");
    	this.colorrgb.setText("(" + this.c.getR() + "," + this.c.getG() + "," + this.c.getB() + ")");
    	this.colorhex.setText(this.c.getHexa());
    }
}

