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
//        String [] insult = {"I'll VERB your NOUN, you ADJECTIVE NOUN"};
//        Insult test = new Insult(insult);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(test.createInsult());
//        }
        Player one = new Player("Tim");
        Enemy two = new Enemy("Jessica");
        int damage = two.getDamage();
        System.out.println(two.getMove(damage));
        one.decreaseHealth(damage/100.0);
        System.out.println(one.getName() + "'s health dropped to " + one.intHealth());
    }

}
