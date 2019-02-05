package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public final class HelperUI {
    public static void openNewPane(String name, ActionEvent event) {
        try {
            //System.out.println("test");
            URL fxmlURL = ClassLoader.getSystemResource("fx/" + name);
            FXMLLoader detailLoader = new FXMLLoader(fxmlURL);
            Pane root = null;

            root = detailLoader.load();

            Stage dialogStage = new Stage();
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            dialogStage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
