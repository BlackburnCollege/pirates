
package combat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dakota.tebbe
 */
public class CombatExample extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CombatExampleFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        String [] insult = {"I'll VERB your NOUN, you ADJECTIVE NOUN"};
        Insult test = new Insult(insult);
        for (int i = 0; i < 10; i++) {
            System.out.println(test.createInsult());
        }
    }
    
    
}
