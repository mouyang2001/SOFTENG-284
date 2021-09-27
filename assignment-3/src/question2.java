import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int order = Integer.parseInt(scanner.nextLine());
            ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

            for (int i = 0; i < order; i++) {
                String[] data = scanner.nextLine().split(" ");
                ArrayList<Integer> arcs = new ArrayList<>();

                if (!Objects.equals(data[0], "")) {
                    for (String value : data) {
                        arcs.add(Integer.valueOf(value));
                    }
                }

                adjacencyList.add(i, arcs);
            }

            System.out.println(adjacencyList);
        }
    }
}
