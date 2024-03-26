package main;

public class SmoothSort {
    private static int[] heap;
    private static int heapSize;
    private static int iterations;

    private static void siftDown(int start, int end) {
        int root = start;
        while (root * 2 + 1 <= end) {
            int child = root * 2 + 1;
            int swap = root;

            if (heap[swap] < heap[child]) {
                swap = child;
            }
            if (child + 1 <= end && heap[swap] < heap[child + 1]) {
                swap = child + 1;
            }
            if (swap == root) {
                return;
            } else {
                int temp = heap[root];
                heap[root] = heap[swap];
                heap[swap] = temp;
                root = swap;
            }
            iterations++;
        }
    }

    private static void heapify(int[] arr) {
        heap = arr;
        heapSize = arr.length;

        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            siftDown(i, heapSize - 1);
            iterations++;
        }
    }

    public static void sort(int[] arr) {
        heapify(arr);

        int end = heapSize - 1;
        while (end > 0) {
            int temp = heap[end];
            heap[end] = heap[0];
            heap[0] = temp;
            end--;
            siftDown(0, end);
            iterations++;
        }
    }

    public static int getIterations() {
        int number = iterations;
        iterations = 0;
        return number;
    }
}
