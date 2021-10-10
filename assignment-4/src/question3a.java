import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * Finds the number of connected components in a graph, by counting number of DFS search forests.
 * @author Matthew Ouyang
 */
public class question3a {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while ((line = reader.readLine()) != null) {

                // Get the order of the graph.
                int order = Integer.parseInt(line);

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
                            adjList.get(v).add(u);
                        }
                    }
                }

                // Find number of connected components in graph.
                if (!adjList.isEmpty()) {
                    int[] visited = new int[order];
                    int numComponents = 0;
                    for (int v = 0; v < order; v++) {
                        if (visited[v] == 0) {
                            DFS(v, visited, adjList);
                            numComponents++;
                        }
                    }
                    System.out.println(numComponents);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Iterative DFS algorithm using stack.
     * @param s root node.
     * @param visited integer array tracking visited and unvisited nodes based on index.
     * @param adjList graph represented in adjacency list form.
     */
    public static void DFS(int s, int[] visited, ArrayList<ArrayList<Integer>> adjList) {
        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while (!stack.isEmpty()) {
            s = stack.pop();

            if (visited[s] == 0) visited[s] = 1;

            for (int neighbor : adjList.get(s)) {
                if (visited[neighbor] == 0) stack.push(neighbor);
            }
        }
    }
}
