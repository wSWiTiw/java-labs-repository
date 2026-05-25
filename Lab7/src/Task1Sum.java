public class Task1Sum {
    static class SumThread extends Thread {
        private final int[] array;
        private final int start;
        private final int end;
        private long sum = 0;

        public SumThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        public long getSum() {
            return sum;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int mid = array.length / 2;

        SumThread thread1 = new SumThread(array, 0, mid);
        SumThread thread2 = new SumThread(array, mid, array.length);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long totalSum = thread1.getSum() + thread2.getSum();
        System.out.println("Общая сумма элементов: " + totalSum);
    }
}