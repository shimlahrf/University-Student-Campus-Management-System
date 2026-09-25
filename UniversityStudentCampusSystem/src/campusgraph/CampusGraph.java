package campusgraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CampusGraph {

    private HashMap<String, ArrayList<String>> adjacencyList;

    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add campus location
    public boolean addLocation(String location) {

        if (adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.put(location, new ArrayList<>());

        return true;
    }

    // Remove campus location
    public boolean removeLocation(String location) {

        if (!adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.remove(location);

        for (ArrayList<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    // Add connection
    public boolean addConnection(
            String location1,
            String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {

            return false;
        }

        if (location1.equals(location2)) {
            return false;
        }

        if (adjacencyList.get(location1).contains(location2)) {
            return false;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        return true;
    }

    // Remove connection
    public boolean removeConnection(
            String location1,
            String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {

            return false;
        }

        boolean removed1 =
                adjacencyList.get(location1).remove(location2);

        boolean removed2 =
                adjacencyList.get(location2).remove(location1);

        return removed1 && removed2;
    }

    // Display connections
    public void displayConnections() {

        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\n===== CAMPUS CONNECTIONS =====");

        for (String location : adjacencyList.keySet()) {

            System.out.print(location + " -> ");

            ArrayList<String> neighbours =
                    adjacencyList.get(location);

            if (neighbours.isEmpty()) {

                System.out.println("No connections");

            } else {

                for (String neighbour : neighbours) {
                    System.out.print(neighbour + " ");
                }

                System.out.println();
            }
        }
    }

    // BFS traversal
    public void bfs(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {

            System.out.println("Campus location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        queue.add(startLocation);
        visited.add(startLocation);

        System.out.println("\n===== BFS TRAVERSAL =====");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println(current);

            for (String neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }
}