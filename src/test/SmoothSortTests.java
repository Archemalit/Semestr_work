package test;

import main.SmoothSort;
import org.junit.Assert;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SmoothSortTests {

    @Test
    public void testSmoothSort() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tests.txt"))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                int numbers = Integer.parseInt(reader.readLine());

                String[] array = reader.readLine().split(" ");
                int[] result_array = new int[numbers];
                int[] expect_array = new int[numbers];

                for (int j = 0; j < numbers; j++) {
                    int num = Integer.parseInt(array[j]);
                    result_array[j] = num;
                    expect_array[j] = num;
                }


                SmoothSort.sort(result_array);
                Arrays.sort(expect_array);

                Assert.assertArrayEquals(expect_array, result_array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
