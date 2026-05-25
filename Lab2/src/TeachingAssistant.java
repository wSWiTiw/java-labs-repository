public class TeachingAssistant extends Student {
    private String assignedGroup;
    private int workingHours;
    private double salary;

    public TeachingAssistant() {
        super();
        this.assignedGroup = "Не назначена";
        this.workingHours = 0;
        this.salary = 0.0;
    }

    public TeachingAssistant(String name, int age, String gender, String university,
                             int course, double gpa, String assignedGroup,
                             int workingHours, double salary) {
        super(name, age, gender, university, course, gpa);
        this.assignedGroup = assignedGroup;
        this.workingHours = workingHours;
        this.salary = salary;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " помогает проводить занятия у группы " + assignedGroup + ".");
    }

    public void checkHomework() {
        System.out.println(getName() + " проверяет домашние задания.");
    }

    // Геттеры и сеттеры
    public String getAssignedGroup() { return assignedGroup; }
    public void setAssignedGroup(String assignedGroup) { this.assignedGroup = assignedGroup; }
    public int getWorkingHours() { return workingHours; }
    public void setWorkingHours(int workingHours) { this.workingHours = workingHours; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}