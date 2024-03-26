package main;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("tests.txt"))) {
            try (BufferedWriter writter = new BufferedWriter(new FileWriter("result.txt"))) {

            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                long start = System.nanoTime();

                int numbers = Integer.parseInt(reader.readLine());

                String[] array = reader.readLine().split(" ");
                int[] result_array = new int[numbers];

                for (int j = 0; j < numbers; j++) {
                    result_array[j] = Integer.parseInt(array[j]);
                }

                SmoothSort.sort(result_array);

                long end = System.nanoTime();
                double time = (double) (end - start) / 1000000;

                    writter.write(time + ";" + SmoothSort.getIterations() + ";" + numbers + "\n");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
