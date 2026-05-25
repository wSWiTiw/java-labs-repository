public class Student extends Person {
    private String university;
    private int course;
    private double gpa;

    public Student() {
        super();
        this.university = "Не указан";
        this.course = 1;
        this.gpa = 0.0;
    }

    public Student(String name, int age, String gender, String university, int course, double gpa) {
        super(name, age, gender); // Вызов конструктора суперкласса
        this.university = university;
        this.course = course;
        this.gpa = gpa;
    }

    // Переопределение метода
    @Override
    public void performDuties() {
        System.out.println(getName() + " учится на " + course + " курсе в " + university + ".");
    }

    // Демонстрация перегрузки методов (Overloading)
    public void study() {
        System.out.println(getName() + " изучает лекции.");
    }

    public void study(int hours) {
        System.out.println(getName() + " усердно учится " + hours + " часов подряд.");
    }

    // Геттеры и сеттеры
    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }
    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}