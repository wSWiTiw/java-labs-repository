import java.util.ArrayList;
import java.util.List;

class Product {
    private final int weight;

    public Product(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Warehouse {
    private final List<Product> products = new ArrayList<>();
    private int currentLoadWeight = 0;
    private final int MAX_WEIGHT = 150;

    public Warehouse() {
        // Заполняем склад товарами
        products.add(new Product(50));
        products.add(new Product(60));
        products.add(new Product(40)); // Сумма 150
        products.add(new Product(80));
        products.add(new Product(70)); // Сумма 150
        products.add(new Product(20));
    }

    public synchronized boolean takeNextProduct(Loader loader) throws InterruptedException {
        if (products.isEmpty() && currentLoadWeight == 0) {
            return false;
        }

        if (!products.isEmpty()) {
            Product nextProduct = products.get(0);

            if (currentLoadWeight + nextProduct.getWeight() <= MAX_WEIGHT) {
                products.remove(0);
                currentLoadWeight += nextProduct.getWeight();
                System.out.println(loader.getName() + " взял товар " + nextProduct.getWeight() +
                        " кг. Текущий вес: " + currentLoadWeight + " кг.");

                if (currentLoadWeight == MAX_WEIGHT || products.isEmpty()) {
                    transportLoad();
                }
                return true;
            } else {
                System.out.println("(!) Товар весом " + nextProduct.getWeight() +
                        " кг не влезает. Отправка текущей партии.");
                transportLoad();
                return true;
            }
        }
        return false;
    }

    private void transportLoad() throws InterruptedException {
        System.out.println(">>> Собран вес " + currentLoadWeight + " кг. Грузчики переносят товары на другой склад...");
        Thread.sleep(1000);
        System.out.println("<<< Разгрузка завершена. Возвращение.\n");
        currentLoadWeight = 0;
    }
}

class Loader extends Thread {
    private final Warehouse warehouse;

    public Loader(String name, Warehouse warehouse) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (warehouse.takeNextProduct(this)) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Task3Warehouse {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        // На складе работают 3 грузчика
        Loader loader1 = new Loader("Грузчик 1", warehouse);
        Loader loader2 = new Loader("Грузчик 2", warehouse);
        Loader loader3 = new Loader("Грузчик 3", warehouse);

        loader1.start();
        loader2.start();
        loader3.start();
    }
}