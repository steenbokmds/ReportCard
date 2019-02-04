import database.H2Connection;
import database.ReportCardsRepository;
import org.pmw.tinylog.Logger;

public class Program {
    public static void main(String[] args) {
        new H2Connection().startDBServer();
        ReportCardsRepository.populateDB();
        Logger.info("Database has been populated");
        ReportCardsRepository.insertStudent("abc");
        ReportCardsRepository.insertStudent("def");
        System.out.println(ReportCardsRepository.getStudent("abc"));
        System.out.println(ReportCardsRepository.getStudent("def"));
    }
}
