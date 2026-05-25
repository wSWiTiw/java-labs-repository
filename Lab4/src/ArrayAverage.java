public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "четыре", "5"};
        int sum = 0;
        int validElementsCount = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
                validElementsCount++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за границы массива.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверные данные, элемент массива не является числом.");
        }

        if (validElementsCount > 0) {
            double average = (double) sum / validElementsCount;
            System.out.println("Среднее арифметическое валидных элементов: " + average);
        } else {
            System.out.println("В массиве нет валидных чисел.");
        }
    }
}