public class Teacher extends Person {
    private String subject;
    private int experience;
    private String degree;

    public Teacher() {
        super();
        this.subject = "Не указан";
        this.experience = 0;
        this.degree = "Нет";
    }

    public Teacher(String name, int age, String gender, String subject, int experience, String degree) {
        super(name, age, gender);
        this.subject = subject;
        this.experience = experience;
        this.degree = degree;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " преподает предмет: " + subject + ".");
    }

    public void conductExam() {
        System.out.println(getName() + " проводит экзамен для студентов.");
    }

    // Геттеры и сеттеры
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
}