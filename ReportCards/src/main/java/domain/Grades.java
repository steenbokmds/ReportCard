package domain;

public class Grades {
    Student st;
    String name, subjectName;
    String grades;
    int r_id, subid, stud_id;

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public Grades(Student st, int grades, String subjectName, int subid) {
        this.st = st;
        this.grades = ""+grades;
        this.subjectName = subjectName;
        this.subid = subid;
        this.stud_id = st.getID();
        this.name = st.getName();
        this.r_id = st.getR_id();
    }

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = ""+grades;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }
}
