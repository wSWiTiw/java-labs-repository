public abstract class Person {
    private String name;
    private int age;
    private String gender;

    // Статическая переменная для подсчета созданных объектов
    private static int count = 0;

    // Конструктор по умолчанию
    public Person() {
        this("Неизвестно", 0, "Не указан");
    }

    // Конструктор инициализации
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        count++; // Увеличиваем счетчик при каждом создании объекта
    }

    // Абстрактный метод
    public abstract void performDuties();

    // Обычный метод
    public void introduce() {
        System.out.println("Меня зовут " + name + ", мне " + age + " лет.");
    }

    public static int getCount() { return count; }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}