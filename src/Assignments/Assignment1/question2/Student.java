package Assignments.Assignment1.question2;

public class Student implements Comparable<Student>{

    private String name;
    private String id;
    private int age;

    public Student(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public int compareTo(Student student) {

        if (age > student.age)
            return 1;
        else if (age < student.age)
            return -1;

        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
