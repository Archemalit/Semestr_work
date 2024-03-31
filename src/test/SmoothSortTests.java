package test;

import main.SmoothSort;
import org.junit.Assert;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SmoothSortTests {

    @Test
    public void testSmoothSort() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("tests.txt"))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                int numbers = Integer.parseInt(reader.readLine());
//                String[] array = new String[]{"4", "1","44","46","43","6","8","9","0"};
                String[] array = reader.readLine().split(" ");
                int [] result_array = new int[array.length];
                int [] expect_array = new int[array.length];

                for (int j = 0; j < numbers; j++) {
                    int num = Integer.parseInt(array[j]);
                    result_array[j] = num;
                    expect_array[j] = num;
                }


                result_array = SmoothSort.smoothsort(result_array);
                Arrays.sort(expect_array);

                Assert.assertArrayEquals(expect_array, result_array);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
