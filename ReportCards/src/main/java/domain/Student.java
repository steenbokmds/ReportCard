package domain;

public class Student {

    private String section, name, fathersname, contactnumber, address, bloodgroup;
    private String disability;
    private int c_id;
    private int r_id;
    private int id;

    public Student(int id, int r_id, int c_id, String section) {
        this.id = id;
        this.r_id = r_id;
        this.c_id = c_id;
        this.section = section;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public int getC_id() {
        return c_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "section='" + section + '\'' +
                ", name='" + name + '\'' +
                ", fathersname='" + fathersname + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                ", address='" + address + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", disability='" + disability + '\'' +
                ", c_id=" + c_id +
                ", r_id=" + r_id +
                '}';
    }

    public int getID() {
        return id;
    }
}