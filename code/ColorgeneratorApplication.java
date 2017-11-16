/**
 * Classe application
 * 
 * @author  Maxence Marchand, aka MrSpacemau5
 * @version 19/08/2017
 */

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Point d'entrée de l'application.
 * 
 * Lorsqu'une application JavaFX est lancée (à l'aide la méthode {@link #launch
 * launch}), les opérations suivantes sont effectuées <u>automatiquement</u> :
 * <ol>
 * <li>Construction d'une instance de cette classe à l'aide du constructeur par
 * défaut
 * <li>Invocation de la méthode {@link #init init} pour les initialisations non graphiques
 * <li>Invocation de la méthode {@link #start start} pour initialiser la fenêtre principale de l'application
 * <li>Attente de la fin de l'exécution de l'application ...
 * <li>Invocation de la méthode {@link #stop stop} pour libérer les ressources utilisées par l'application
 * </ol>
 */
public class ColorgeneratorApplication extends Application {

    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("colorgenerator.fxml"), ResourceBundle.getBundle("colorgenerator"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Color Generator by MrSpacemau5");
            primaryStage.getIcons().add(new Image("icon.png"));
            primaryStage.show();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Méthode appelée automatiquement à la <b>fin de l'exécution</b> de
     * l'application.
     */
    @Override
    public void stop() throws Exception {
        /* libération des ressources de l'application */

        System.exit(0);
    }

    /**
     * Programme principal.
     */
    public static void main(String[] args) {
        // décommentez la ligne ci-dessous pour remplacer la langue par défaut par l'anglais
        // Locale.setDefault(Locale.ENGLISH);

        Application.launch(args);
    }
}
