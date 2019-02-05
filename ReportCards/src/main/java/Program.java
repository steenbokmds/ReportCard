import database.H2Connection;
import database.ReportCardsRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;
import ui.LoginController;

import static javafx.application.Application.launch;

public class Program extends Application {
    public static void main(String[] args) {
//        new H2Connection().startDBServer();
//        ReportCardsRepository.populateDB();
//        Logger.info("Database has been populated");
//        ReportCardsRepository.insertStudent("abc");
//        ReportCardsRepository.insertStudent("def");
//        System.out.println(ReportCardsRepository.getStudent("abc"));
//        System.out.println(ReportCardsRepository.getStudent("def"));
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fx/login.fxml"));
        Parent content = loader.load();
        Scene scene2 = new Scene(content);
        LoginController controller = (LoginController) loader.getController();
        controller.setTheStage(scene2);
        primaryStage.setScene(scene2);
        primaryStage.show();
    }
}
