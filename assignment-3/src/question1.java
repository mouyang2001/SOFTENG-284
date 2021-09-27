import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            // clean data
            String[] data = scanner.nextLine().split(",");
            int[] numbers = new int[data.length];
            for (int i = 0; i < data.length; i++) numbers[i] = Integer.parseInt(data[i]);

            // hash params
            int size = numbers[0];
            int p = numbers[1];

            // output tracking
            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;

            // linear probing
            int[] LPTable = new int[size];
            for (int i = 2; i < numbers.length; i++) {
                int index = primaryHash(numbers[i], size);
                if (LPTable[index] != 0) a++; // upon insertion
                while (LPTable[index] != 0) { // additional probes
                    b++;
                    index = (index == 0) ? size-1 : index-1;
                }
                LPTable[index] = numbers[i];
            }

            // double hashing
            int[] DHTable = new int[size];
            for (int i = 2; i < numbers.length; i++) {
                int index = primaryHash(numbers[i], size);
                if (DHTable[index] != 0) c++; // upon insertion
                while (DHTable[index] != 0) { // additional probes
                    d++;
                    index = secondaryHash(index, p);
                }
                DHTable[index] = numbers[i];
            }

            System.out.println(a + "," + b + "," + c + "," + d);
        }
    }

    public static int primaryHash(int x, int m) {
        return x % m;
    }

    public static int secondaryHash(int x, int p) {
        return (x % p) + 1;
    }
}
