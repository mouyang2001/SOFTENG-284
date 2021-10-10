import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class question3aRecursive {
    public static void main(String[] args) {

        try {
            BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
            //BufferedReader bfReader = new BufferedReader(new FileReader("C:\\Users\\ishbh\\Documents\\Engineering 2nd Year\\Sem 2\\SOFTENG 284\\Assignments\\Assignment 4\\Question3b\\src\\q3\\Q3_test_input.txt"));
            String line;

            while ((line = bfReader.readLine()) != null) {
                int order = Integer.valueOf(line); // Get order

                // Create list to store digraph
                ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
                for (int i=0; i<order; i++) {
                    adjList.add(new ArrayList<>());
                }


                // Add nodes to list
                for (int i=0; i<order; i++) {
                    String[] nextLine = bfReader.readLine().split(" ");

                    if (!Objects.equals(nextLine[0], "")) {
                        for (String node : nextLine) {
                            int intNode = Integer.valueOf(node);
                            adjList.get(i).add(intNode);
                            adjList.get(intNode).add(i); // Adding reverse nodes for underlying graph
                        }
                    }
                }

                if (!adjList.isEmpty()) {
                    System.out.println(numConnectedComponents(adjList));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int numConnectedComponents(ArrayList<ArrayList<Integer>> adjList) {

        int order = adjList.size();
        int[] visited = new int[order];
        int count = 0;

        for (int v=0; v<order; ++v) {
            if (visited[v] == 0) {
                DFSUtil(v, visited, adjList, count);
                count++;
            }
        }

        return count;
    }

    public static void DFSUtil(int node, int[] visited, ArrayList<ArrayList<Integer>> adjList, int count) {
        visited[node] = 1;

        for (int neighbour : adjList.get(node)) {
            if (visited[neighbour] == 0) {
                DFSUtil(neighbour, visited, adjList, count);
            }
        }
    }
}
