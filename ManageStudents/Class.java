package ManageStudents;

import java.util.ArrayList;
import java.util.TreeSet;

public class Class {
    private ArrayList<Student> listSt = new ArrayList<>();

    public Class(ArrayList<Student> listSt) {
        this.listSt = listSt;
    }

    public String show() {
        return "List Student:\n" + listSt;
    }

    public void delStudent(int idDel) {
        for (Student st : listSt) {
            if (st.getId() == idDel) {
                listSt.remove(st);
            }
        }
    }

    public Student findStudentWithID(int id) {
        Student result = new Student();
        for (Student st : listSt) {
            if (st.getId() == id) {
                result = st;
            }
        }
        return result;
    }

    public Student finStudentWithAVG(double avg) {
        Student result = new Student();
        for (Student st : listSt) {
            if (st.getAvgMark() == avg) {
                result = st;
            }
        }
        return result;
    }

    public ArrayList<Student> findStudentWithName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student st : listSt) {
            if (st.getName().contains(name)) {
                result.add(st);
            }
        }
        return result;
    }

    public ArrayList<Student> sort() {
        TreeSet<Double> listAVG = new TreeSet<>();
        ArrayList<Student> result = new ArrayList<>();
        for (Student st : listSt) {
            listAVG.add(st.getAvgMark());
        }
        for (double avg : listAVG) {
            result.add(finStudentWithAVG(avg));
        }
        return result;
    }

    public static void main(String[] args) {
        Student st1 = new Student("Nguyen Van A", 154321, 18, "tphcm", 8.4);
        Student st2 = new Student("Nguyen Van B", 154344, 18, "tphcm", 6.4);
        Student st3 = new Student("Nguyen Van C", 154344, 18, "tphcm", 8.3);
        Student st4 = new Student("Nguyen Van D", 154312, 18, "tphcm", 9.4);
        Student st5 = new Student("Nguyen Van E", 154552, 18, "tphcm", 7.5);
        ArrayList<Student> liStudents = new ArrayList<>();
        liStudents.add(st1);
        liStudents.add(st2);
        liStudents.add(st3);
        liStudents.add(st4);
        liStudents.add(st5);
        Class classDH20 = new Class(liStudents);
        System.out.println(classDH20.show());
        System.out.println(classDH20.sort());

    }
}
