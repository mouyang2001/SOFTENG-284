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
                // Get data and put in Arraylist<ArrayList<Integer>> format
                int order = Integer.parseInt(line);
                ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

                for (int i = 0; i < order; i++) {
                    String[] data = reader.readLine().split(" ");
                    ArrayList<Integer> arcs = new ArrayList<>();

                    if (!Objects.equals(data[0], "")) {
                        for (String value : data) {
                            arcs.add(Integer.valueOf(value));
                        }
                    }

                    adjacencyList.add(i, arcs);
                }

                System.out.println(adjacencyList);

                // reverse adjacencyList

                // output it, remember '[]' just output '\n'
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
