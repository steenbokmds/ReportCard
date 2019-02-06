package database;

import domain.Course;
import domain.Student;

import java.util.List;

public interface ReportCardsRepo {

    List<Course> getClasses();

    Student searchStudent(int id, int c_id, String section);
}
