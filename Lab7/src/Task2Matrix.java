public class Task2Matrix {
    static class MaxInRowThread extends Thread {
        private final int[] row;
        private int max = Integer.MIN_VALUE;

        public MaxInRowThread(int[] row) {
            this.row = row;
        }

        public int getMax() {
            return max;
        }

        @Override
        public void run() {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1, 5, 9},
                {12, 3, 7},
                {4, 15, 6}
        };

        MaxInRowThread[] threads = new MaxInRowThread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new MaxInRowThread(matrix[i]);
            threads[i].start();
        }

        int globalMax = Integer.MIN_VALUE;

        for (MaxInRowThread thread : threads) {
            thread.join();
            if (thread.getMax() > globalMax) {
                globalMax = thread.getMax();
            }
        }

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}