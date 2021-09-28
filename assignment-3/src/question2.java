import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class question2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while ((line = reader.readLine()) != null) {

                // Get the order of the graph.
                int order = Integer.parseInt(line);

                // Create empty adjacency list
                ArrayList<ArrayList<Integer>> reversed = new ArrayList<>();
                for (int i = 0; i < order; i++) reversed.add(new ArrayList<>());

                // Populate reversed list
                for (int u = 0; u < order; u++) {
                    String[] data = reader.readLine().split(" ");
                    if (!Objects.equals(data[0], "")) {
                        for (String value : data) {
                            // (u, v) -> (v, u).
                            int v = Integer.parseInt(value);
                            reversed.get(v).add(u);
                        }
                    }
                }

                // Output reversed list.
                System.out.println(order);
                for (ArrayList<Integer> destinations : reversed) {
                    for (int i = 0; i < destinations.size(); i++) {
                        System.out.print(destinations.get(i));
                        if (i < destinations.size() - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("\n");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
