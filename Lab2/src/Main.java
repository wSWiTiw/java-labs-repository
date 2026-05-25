import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод информации
        System.out.println("--- Создание студента ---");
        System.out.print("Введите имя студента: ");
        String studentName = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int studentAge = scanner.nextInt();

        // 1. Создание объектов с параметрами и по умолчанию
        Student student1 = new Student(studentName, studentAge, "Мужской", "МГТУ", 2, 4.5);
        Teacher teacher1 = new Teacher("Анна Ивановна", 45, "Женский", "Программирование", 20, "Кандидат наук");
        TeachingAssistant ta1 = new TeachingAssistant("Игорь", 22, "Мужской", "МГТУ", 4, 4.8, "Группа 101", 20, 15000);

        Student defaultStudent = new Student();
        defaultStudent.setName("Олег"); // Использование сеттера
        defaultStudent.setAge(19);

        System.out.println("\n--- Вывод информации и полиморфизм ---");
        // Использование массива суперкласса для демонстрации полиморфизма (Upcasting)
        Person[] people = {student1, teacher1, ta1, defaultStudent};

        for (Person p : people) {
            p.introduce(); // Вызов метода базового класса
            p.performDuties(); // Полиморфный вызов переопределенного метода
            System.out.println("-");
        }

        System.out.println("\n--- Демонстрация перегрузки методов ---");
        student1.study(); // Вызов обычного метода
        student1.study(4); // Вызов перегруженного метода

        System.out.println("\n--- Статическая переменная ---");
        System.out.println("Всего создано объектов Person: " + Person.getCount());

        scanner.close();
    }
}