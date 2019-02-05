package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Student;
import org.pmw.tinylog.Logger;

public final class ReportCardsRepository {
    public static final String SQL_POPULATE_DB = "DROP TABLE IF EXISTS `class`;\n" +
            "CREATE TABLE `class` (\n" +
            "  `classID` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`classID`)\n" +
            ");\n" +
            "\n" +
            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `student`;\n" +
            "CREATE TABLE `student` (\n" +
            "  `studentID` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`studentID`)\n" +
            ");\n" +
            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `section`;\n" +
            "CREATE TABLE `section` (\n" +
            "  `sectionID` int(11) NOT NULL,\n" +
            "  `classID` int(11) DEFAULT NULL,\n" +
            "  `name` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`sectionID`),\n" +
            "  FOREIGN KEY (classID) REFERENCES class (classid),\n" +
            ");\n" +
            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `studentsection`;\n" +
            "CREATE TABLE `studentsection` (\n" +
            "  `sectionID` int(11) NOT NULL,\n" +
            "  `studentID` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`sectionID`,`studentID`),\n" +
            "  FOREIGN KEY (sectionID) REFERENCES section (sectionid),\n" +
            "  FOREIGN KEY (studentID) REFERENCES student (studentid),\n" +
            ");\n" +
            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `teacher`;\n" +
            "CREATE TABLE `teacher` (\n" +
            "  `teacherID` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `username` varchar(45) NOT NULL,\n" +
            "  `password` varchar(45) NOT NULL,\n" +
            "  PRIMARY KEY (`teacherID`)\n" +
            ");\n" +
            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `subject`;\n" +
            "CREATE TABLE `subject` (\n" +
            "  `subjectID` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `subjectname` varchar(45) NOT NULL,\n" +
            "  `teacherID` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`subjectID`),\n" +
            "  FOREIGN KEY (teacherID) REFERENCES teacher (teacherid),\n" +
            ");\n" +

            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `test`;\n" +
            "CREATE TABLE `test` (\n" +
            "  `testID` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `subjectID` int(11) NOT NULL,\n" +
            "  `name` varchar(45) DEFAULT NULL,\n" +
            "  `maxpoints` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`testID`),\n" +
            "  FOREIGN KEY (subjectID) REFERENCES subject (subjectid),\n" +
            ");\n" +
            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `pdf`;\n" +
            "CREATE TABLE `pdf` (\n" +
            "  `pdfID` int(11) NOT NULL,\n" +
            "  `pdfname` varchar(45) DEFAULT NULL,\n" +
            "  `teacherID` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`pdfID`),\n" +
            "  FOREIGN KEY (teacherID) REFERENCES teacher (teacherid),\n" +
            ");\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "DROP TABLE IF EXISTS `studenttest`;\n" +
            "CREATE TABLE `studenttest` (\n" +
            "  `studentID` int(11) NOT NULL,\n" +
            "  `testID` int(11) NOT NULL,\n" +
            "  `points` varchar(45) NOT NULL,\n" +
            "  PRIMARY KEY (`studentID`,`testID`),\n" +
            "  FOREIGN KEY (studentID) REFERENCES student (studentid),\n" +
            "  FOREIGN KEY (testID) REFERENCES test (testid)\n" +
            ");\n";

    private static final String SQL_INSERT_STUDENT = "INSERT INTO student"
            + "(NAME) "
            + "VALUES (?)";

    private static final String SQL_SELECT_STUDENT_ON_NAME = "SELECT * FROM  student WHERE NAME = ?";


    public static void populateDB(){
        try (Statement stmt = H2Connection.getConnection().createStatement()) {
            stmt.executeUpdate(SQL_POPULATE_DB);
        } catch (SQLException ex) {
            Logger.warn("Error populating db {}", ex.getLocalizedMessage());
            Logger.debug(ex.getStackTrace());
        }
    }

    public static void insertStudent(String gebruiker) {
        try (PreparedStatement prep = H2Connection.getConnection().prepareStatement(SQL_INSERT_STUDENT)) {
            prep.setString(1, gebruiker);
            prep.execute();
        } catch (SQLException ex) {
            Logger.warn("Error inserting student{}", ex.getLocalizedMessage());
            Logger.debug(ex.getStackTrace());
        }
    }


    public static Student getStudent(String name){
        Student res = null;
        try (PreparedStatement prep = H2Connection.getConnection().prepareStatement(SQL_SELECT_STUDENT_ON_NAME)) {
            prep.setString(1, name);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                res = new Student(rs.getInt("studentID"),rs.getString("name"));
            }
        } catch (SQLException ex) {
            throw new ReportCardsException("cannot get description", ex);
        }
        return res;
    }
}
