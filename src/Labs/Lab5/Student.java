package Labs.Lab5;

public class Student implements Comparable<Student>{

    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Student student) {

        if (this.id > student.id)
            return 1;
        else if (this.id < student.id)
            return -1;

        return 0;

    }
}
