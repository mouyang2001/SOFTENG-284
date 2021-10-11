import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class dijkstraShortestPath {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                int order = Integer.parseInt(line);
                ArrayList<ArrayList<Integer>> adjList = readToAdjacencyList(order, bufferedReader);


            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Reads UOA computer science department graph input files and converts them to an adjacency list.
     * @param order number of nodes in the graph.
     * @param reader BufferedReader that has a specified input stream.
     * @return Adjacency List representation of the graph.
     * @throws IOException Throws exception if nothing is read.
     */
    public static ArrayList<ArrayList<Integer>> readToAdjacencyList(int order, BufferedReader reader) throws IOException {
        // Create empty adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < order; i++) adjList.add(new ArrayList<>());

        // Populate adjacency list as an undirected graph.
        for (int u = 0; u < order; u++) {
            String[] data = reader.readLine().split(" ");
            if (!Objects.equals(data[0], "")) {
                for (String value : data) {
                    int v = Integer.parseInt(value);
                    adjList.get(u).add(v);
                }
            }
        }

        return adjList;
    }
}
