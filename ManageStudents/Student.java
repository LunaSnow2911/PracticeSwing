package ManageStudents;

public class Student {
    private String name;
    private int id;
    private int age;
    private String address;
    private double avgMark;

    public Student(String name, int id, int age, String address, double avgMark) {
        super();
        this.name = name;
        this.id = id;
        this.age = age;
        this.address = address;
        this.avgMark = avgMark;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Name: " + name + " ID: " + id + " Age: " + " Address: "
                + address + " Average Mark: " + avgMark + "\n";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
