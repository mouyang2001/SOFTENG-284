import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int[] numbers = new int[data.length];
                for (int i = 0; i < data.length; i++) numbers[i] = Integer.parseInt(data[i]);

                // hash params
                int size = numbers[0];
                int p = numbers[1];

                // output tracking
                int a = 0;
                int b = 0;
                int c = 0;
                int d = 0;

                // initiate LPTable & DHTable
                ArrayList<Integer> LPTable = new ArrayList<>();
                ArrayList<Integer> DHTable = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    LPTable.add(null);
                    DHTable.add(null);
                }

                // linear probing
                for (int i = 2; i < numbers.length; i++) {
                    int index = primaryHash(numbers[i], size); // calculate hash

                    if (LPTable.get(index) != null) a++; // collision on insertion

                    while (LPTable.get(index) != null) {
                        index = Math.floorMod(index - 1, size);
                        if (i == numbers.length - 1) b++;
                    }

                    if (i == numbers.length - 1) b++;
                    LPTable.set(index, numbers[i]);
                }

                // double hashing
                for (int i = 2; i < numbers.length; i++) {
                    int index = primaryHash(numbers[i], size);
                    int secondaryHash = 0;

                    if (DHTable.get(index) != null) {
                        secondaryHash = secondaryHash(numbers[i], p);
                        c++;
                    }

                    while (DHTable.get(index) != null) {
                        if (i == numbers.length - 1) d++;
                        index = Math.floorMod(index - secondaryHash, size);
                    }

                    if (i == numbers.length - 1) d++;
                    DHTable.set(index, numbers[i]);
                }

                System.out.printf("%d,%d,%d,%d\n", a, b, c, d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int primaryHash(int x, int m) {
        return Math.floorMod(x, m);
    }

    public static int secondaryHash(int x, int p) {
        return Math.floorMod(x, p) + 1;
    }
}
