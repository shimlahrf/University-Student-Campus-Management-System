package campusgraph;

public class TestGraph {

    public static void main(String[] args) {

        CampusGraph graph = new CampusGraph();

        
        graph.addLocation("Main Building");
        graph.addLocation("Library");
        graph.addLocation("Cafeteria");
        graph.addLocation("Hostel");

       
        graph.addConnection("Main Building", "Library");
        graph.addConnection("Main Building", "Cafeteria");
        graph.addConnection("Main Building", "Hostel");

       
        graph.displayConnections();

       
        graph.bfs("Main Building");
    }
}
