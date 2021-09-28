import java.util.Scanner;

public class question1ray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            String[] numsStr = line.split(",");
            final int m = Integer.parseInt(numsStr[0]), p1 = Integer.parseInt(numsStr[1]);

            boolean[] hashTableLP = new boolean[m];
            boolean[] hashTableDH = new boolean[m];

            int keyCollisionCounterLP = 0;
            int keyCollisionCounterDH = 0;

            int lastProbeCountLP = 1;
            int lastProbeCountDH = 1;

            for (int i = 2; i < numsStr.length; i++) {
                final int curNum = Integer.parseInt(numsStr[i]);
                lastProbeCountLP = 1;
                lastProbeCountDH = 1;

                int startingIndex = mod(curNum, m);

                // Increment collision counter if collided
                if (hashTableLP[startingIndex]) keyCollisionCounterLP++;
                if (hashTableDH[startingIndex]) keyCollisionCounterDH++;

                while (hashTableLP[startingIndex]) {
                    startingIndex = invertToStart(startingIndex - 1, m);
                    lastProbeCountLP++;
                }
                hashTableLP[startingIndex] = true;

                startingIndex = mod(curNum, m);
                int change = mod(curNum, p1) + 1;
                while (hashTableDH[startingIndex]) {
                    startingIndex = invertToStart(startingIndex - change, m);
                    lastProbeCountDH++;
                }
                hashTableDH[startingIndex] = true;
            }

            System.out.printf("%d,%d,%d,%d\n", keyCollisionCounterLP, lastProbeCountLP, keyCollisionCounterDH, lastProbeCountDH);

        }
    }

    private static int mod(int x, int y) {
        int remainder = x % y;

        return invertToStart(remainder, y);
    }

    private static int invertToStart(int x, int y) {
        if (x < 0) {
            return x + y;
        } else {
            return x;
        }
    }
}
