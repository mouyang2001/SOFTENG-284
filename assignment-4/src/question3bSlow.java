import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class question3bSlow {
    public static void main(String[] args) {
        try {

            BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
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
                        }
                    }


                }

                if (!adjList.isEmpty()) {
                    System.out.println(longestPath(adjList));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int longestPath(ArrayList<ArrayList<Integer>> adjList) {

        Stack<Integer> stack = new Stack<>();
        int[] distFromRoot = new int[adjList.size()];
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();

        int order = adjList.size();

        for (int i=0; i<order; i++) {
            path.add(new ArrayList<Integer>());
        }

        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int neighbour : adjList.get(node)) {
                if (!path.get(node).contains(neighbour)) { // Making sure we aren't counting loops
                    if (path.get(node).size() >= path.get(neighbour).size()) {
                        path.get(neighbour).clear();
                        path.get(neighbour).addAll(path.get(node));
                        path.get(neighbour).add(neighbour);
                        distFromRoot[neighbour] = path.get(neighbour).size();
                        stack.push(neighbour);
                    }
                }
            }
        }

        int longestPath = 0;

        for (int i=0; i<order; i++) {
            if (distFromRoot[i] > longestPath) {
                longestPath = distFromRoot[i];
            }
        }

        return longestPath;

    }
}
