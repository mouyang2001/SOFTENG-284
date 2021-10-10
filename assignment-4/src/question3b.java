import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/**
 * Finds the longest path length in a DAG.
 *
 * @author Matthew Ouyang.
 */
public class question3b {
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
                        }
                    }
                }

                // Output the length of the longest path.
                if (!adjList.isEmpty()) System.out.println(longestPathLength(adjList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * For computing the longest path length of DAG.
     *
     * @param adjList adjacency list representation of graph.
     * @return length of the longest path in the graph.
     */
    private static int longestPathLength(ArrayList<ArrayList<Integer>> adjList) {
        // Get size of graph.
        int order = adjList.size();

        // Topological stack represents blacked out nodes in order of latest to earliest.
        Stack<Integer> topStack = new Stack<>();

        // To keep track of visited nodes.
        int[] visited = new int[order];

        // Set all distances to infinity.
        int[] dist = new int[order];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Set starting node '0' to distance of 0.
        dist[0] = 0;

        // Topologically sort nodes into topologicalStack.
        for (int v = 0; v < order; v++) {
            if (visited[v] == 0) dfs(adjList, v, visited, topStack);
        }

        // Calculate distances in topological order.
        while (!topStack.isEmpty()) {
            int u = topStack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (int v : adjList.get(u)) {
                    int newDist = dist[u] - 1;
                    if (dist[v] > newDist) dist[v] = newDist;
                }
            }
        }

        // Get the smallest path length.
        int shortestPathLength = Integer.MAX_VALUE;
        for (int i : dist) {
            if (i < shortestPathLength) shortestPathLength = i;
        }

        // Longest path length will be the absolute value of the smallest path length.
        return Math.abs(shortestPathLength);
    }

    /**
     * Modified dfs algorithm that will add to the topological stack and mark nodes visited.
     *
     * @param adjList adjacency list representation of the graph.
     * @param node the node currently being visited.
     * @param visited integer array keeping track if a node is visited.
     * @param topStack topological stack to sort nodes topologically.
     */
    private static void dfs(ArrayList<ArrayList<Integer>> adjList, int node, int[] visited, Stack<Integer> topStack) {
        visited[node] = 1;
        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor] == 0) dfs(adjList, neighbor, visited, topStack);
        }

        // This extra line for topological sorting.
        topStack.push(node);
    }
}
