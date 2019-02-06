package database;

import domain.Course;
import domain.Student;
import util.ReportCardsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlRepository implements ReportCardsRepo {
    public MySqlRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final String MYSQL_SELECT_CLASSES = "Select * from class";
    private final String MYSQL_SELECT_TEACHER = "SELECT * FROM teacher where t_id=? and password=?";
    private final String MYSQL_SELECT_SEARCH_STUDENT = "Select * from students_details\n" +
            "left join students on students.stud_id = students_details.stud_id\n" +
            "join class on class.c_id = students.c_id\n" +
            "where rollno = ? and\n" +
            "class.class = ?  and section = ?;";

    private final String MYSQL_UPDATE_TEACHERS = "UPDATE students\n" +
            "set rollno = ?, c_id = ?\n" +
            "where stud_id = ?;\n" +
            "\n" +
            "UPDATE students_details\n" +
            "set name = ?, fathers_name = ?, address = ?, blood_group = ?, disability = ?\n" +
            "where stud_id =  ?";

    public List<Course> getClasses() {
        List<Course> classes;
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement prep = con.prepareStatement(MYSQL_SELECT_CLASSES)) {
            try (ResultSet rs = prep.executeQuery()) {

                classes = new ArrayList<>();

                while (rs.next()) {
                    int id = rs.getInt("c_id");
                    int class_id = rs.getInt("class");
                    String price = rs.getString("section");

                    Course c = new Course(id, class_id, price);
                    classes.add(c);
                }

                return classes;
            }
        } catch (SQLException ex) {
            throw new ReportCardsException("DB not found", ex);
        }
    }

    public Boolean login(int id, String password) {
        Boolean correctLogin = false;
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement prep = con.prepareStatement(MYSQL_SELECT_TEACHER)) {
            prep.setInt(1, id);
            prep.setString(2, password);
            try (ResultSet rs = prep.executeQuery()) {
                rs.next();
                int idFromDB = rs.getInt("t_id");
                String passwordFromDB = rs.getString("password");
                System.out.println("test      " + idFromDB + " " + passwordFromDB);
                if (id == idFromDB && password.equals(passwordFromDB)) {
                    correctLogin = true;
                }
            } catch (Exception ex) {
                return false;
            }
            return correctLogin;

        } catch (SQLException ex) {
            throw new ReportCardsException("DB not found", ex);
        }
    }

    public Student searchStudent(int id, int c_id, String section) {
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement prep = con.prepareStatement(MYSQL_SELECT_SEARCH_STUDENT)) {
            prep.setInt(1, id);
            prep.setInt(2, c_id);
            prep.setString(3, section);
            System.out.println(id+" "+c_id+" "+section);
            try (ResultSet rs = prep.executeQuery()) {
                rs.next();
                String name = rs.getString("name");
                String fname = rs.getString("fathers_name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                String bloodGroup = rs.getString("blood_group");
                String disability = rs.getString("disability");

                Student st = new Student(id, c_id, section);
                st.setName(name);
                st.setFathersname(fname);
                st.setContactnumber(contact);
                st.setAddress(address);
                st.setBloodgroup(bloodGroup);
                st.setDisability(disability);
                return st;
            }
            catch(Exception ex){
                ex.printStackTrace();
                return null;
            }

        } catch (SQLException ex) {
            throw new ReportCardsException("DB not found", ex);
        }
    }

    public void updateStudent(){

    }
}
