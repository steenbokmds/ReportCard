package database;

import domain.Course;
import domain.Grades;
import domain.Student;
import ui.LoginController;
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

    private final String MYSQL_UPDATE_STUDENT = "UPDATE students\n" +
            "set rollno = ?, c_id = ?\n" +
            "where stud_id = ?;\n";
    private final String MYSQL_UPDATE_STUDENTDETAILS = "UPDATE students_details\n" +
            "set name = ?, fathers_name = ?, address = ?, blood_group = ?, disability = ?\n" +
            "where stud_id =  ?";

    private final String MYSQL_SELECT_STUDENTGRADES = "select students.stud_id, students_details.name, marks.sub_id, marks.marks, students.rollno, students.c_id, \tclass.section, subj.subname, subj.sub_id as subid\n\n" +
            "from students\n" +
            "left join class on class.c_id = students.c_id\n" +
            "left join students_details on students_details.stud_id = students.stud_id\n" +
            "left join class_subject_map as csm on csm.c_id = class.c_id \n" +
            "left join `subject` as subj on subj.sub_id = csm.sub_id\n" +
            "left join marks on marks.stud_id = students.stud_id\n" +
            "where students.c_id = ? and section = ? and t_id = ?;\n";

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

    public int login(int id, String password) {
        int teacherID = -1;
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
                    teacherID = idFromDB;
                }
            } catch (Exception ex) {
                return -1;
            }
            return teacherID;

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
            System.out.println(id + " " + c_id + " " + section);
            try (ResultSet rs = prep.executeQuery()) {
                rs.next();
                int stud_id = rs.getInt("stud_id");
                String name = rs.getString("name");
                String fname = rs.getString("fathers_name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                String bloodGroup = rs.getString("blood_group");
                String disability = rs.getString("disability");

                Student st = new Student(stud_id, id, c_id, section);
                st.setName(name);
                st.setFathersname(fname);
                st.setContactnumber(contact);
                st.setAddress(address);
                st.setBloodgroup(bloodGroup);
                st.setDisability(disability);
                return st;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }

        } catch (SQLException ex) {
            throw new ReportCardsException("DB not found", ex);
        }
    }

    public void updateStudent(Student st) {
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement prep = con.prepareStatement(MYSQL_UPDATE_STUDENT)) {


            prep.setInt(1, st.getR_id());
            prep.setInt(2, st.getC_id());
            prep.setInt(3, st.getID());

            prep.execute();

            System.out.println("1");
            System.out.println(st.toString());
        } catch (SQLException ex) {
            throw new ReportCardsException("DB not found", ex);
        }

        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement prep = con.prepareStatement(MYSQL_UPDATE_STUDENTDETAILS)) {


            prep.setString(1, st.getName());
            prep.setString(2, st.getFathersname());
            prep.setString(3, st.getAddress());
            prep.setString(4, st.getBloodgroup());
            prep.setString(5, st.getDisability());
            prep.setInt(6, st.getID());

            prep.execute();

            System.out.println("2");
        } catch (SQLException ex) {
            throw new ReportCardsException("DB not found", ex);
        }
    }

    public List<Grades> getStudentsFromClassSection(int class_id, String section) {
        List<Grades> students = null;
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement prep = con.prepareStatement(MYSQL_SELECT_STUDENTGRADES)) {

            prep.setInt(1, class_id);
            prep.setString(2, section);
            prep.setString(3, "" + LoginController.teacherID);
            try (ResultSet rs = prep.executeQuery()) {

                students = new ArrayList<>();

                while (rs.next()) {
                    int id = rs.getInt("stud_id");
                    int rollno = rs.getInt("rollno");
                    int cid = rs.getInt("c_id");
                    String section2 = rs.getString("section");
                    int marks = rs.getInt("marks");
                    String subject = rs.getString("subname");
                    int subid = rs.getInt("subid");

                    Student st = new Student(id, rollno, cid, section2);
                    st.setName(rs.getString("name"));
                    Grades gs = new Grades(st, marks,subject,subid);
                    students.add(gs);
                }

                return students;
            }
        } catch (SQLException ex) {
            throw new ReportCardsException("DB not found", ex);
        }
    }
}
