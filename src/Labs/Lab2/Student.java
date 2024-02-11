public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private float cgpa;

    public Student(String name, int age, float cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student student) {

        if (cgpa > student.cgpa)
            return 1;
        else if (cgpa < student.cgpa)
            return -1;

        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cgpa=" + cgpa +
                '}';
    }
}
