package domain;

public class Course {
    int id,class_id;
    String section;

    public Course(int id, int class_id, String section){
        this.id = id;
        this.class_id = class_id;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", section='" + section + '\'' +
                '}';
    }
}
