package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateData {
    public static void main(String[] args) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter("tests.txt"))) {
            Random rd = new Random();
            int n = rd.nextInt(50, 101);
            writter.write(n + "\n");

            for (int i = 0; i < n; i++) {
                int c_nums = rd.nextInt(100, 10001);
                    writter.write(c_nums + "\n");

                    int [] array = rd.ints(c_nums).toArray();

                    for (int j = 0; j < c_nums - 1; j++) {
                        writter.write(array[j] + " ");
                    }
                    writter.write(array[c_nums - 1] + "\n");
                }

            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
