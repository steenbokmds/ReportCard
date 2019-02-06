import data.Repository;
import domain.Course;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.LoginController;

import java.util.List;

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
        //fast test to see if the connection is working


        List<Course> courses = Repository.getInstance().getShopRepository().getClasses();
        for(int i = 0; i<courses.size();i++){
            System.out.println(courses.get(i));
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fx/login.fxml"));
        Parent content = loader.load();
        Scene scene2 = new Scene(content);
//        LoginController controller = (LoginController) loader.getController();
//        controller.setTheStage(scene2);
        primaryStage.setScene(scene2);
        primaryStage.show();
    }
}
