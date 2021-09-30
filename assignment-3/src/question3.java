import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class question3 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while((line = reader.readLine()) != null) {
                // Get the order of the graph.
                int order = Integer.parseInt(line);

                // Create empty adjacency list
                ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
                for (int i = 0; i < order; i++) graph.add(new ArrayList<>());

                // Populate adjacency list
                for (int u = 0; u < order; u++) {
                    String[] data = reader.readLine().split(" ");
                    if (!Objects.equals(data[0], "")) {
                        for (String value : data) {
                            int v = Integer.parseInt(value);
                            graph.get(u).add(v);
                        }
                    }
                }

                if (!graph.isEmpty()) System.out.println(hasCycle(graph));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int hasCycle(ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[graph.size()];
        int[] inStack = new int[graph.size()];
        int order = graph.size();

        // for every node starting from '0'
        for (int i = 0; i < order; i++) {
            if (visited[i] == 1) continue;

            stack.push(i);
            while (!stack.isEmpty()) {
                int u = stack.peek();

                if (visited[u] == 0) {
                    visited[u] = 1;
                    inStack[u] = 1;
                } else {
                    stack.pop();
                    inStack[u] = 0;
                }

                for (int v : graph.get(u)) {
                    if (visited[v] == 0) stack.push(v);
                    if (inStack[v] == 1) return 1;
                }
            }
        }

        return 0;
    }
}
