package campusmanagement; 
 
import java.util.Scanner; 
 
public class Main { 
 
    static Scanner scanner = new Scanner(System.in); 
 
    static StudentLinkedList studentList = new StudentLinkedList(); 
    static ActionStack actionStack = new ActionStack(); 
    static ServiceQueue serviceQueue = new ServiceQueue(); 
    static StudentBST studentBST = new StudentBST(); 
    static HashTable hashTable = new HashTable(); 
    static Graph graph = new Graph(); 
 
    public static void main(String[] args) { 
 
        int choice; 
 
        do { 
 
            displayMenu(); 
 
            choice = readInt("Enter your choice: "); 
 
            switch (choice) { 
 
                case 1: 
                    addStudent(); 
                    break; 
 
                case 2: 
                    updateStudent(); 
                    break; 
 
                case 3: 
                    deleteStudent(); 
                    break; 
 
                case 4: 
                    studentList.displayAll(); 
                    break; 
 
                case 5: 
                    addServiceRequest(); 
                    break; 
 
                case 6: 
                    serviceQueue.processNextRequest(); 
                    break; 
 
                case 7: 
                    actionStack.displayActions(); 
                    break; 
 
                case 8: 
                    studentBST.displayInOrder(); 
                    break; 
 
                case 9: 
                    searchUsingHashing(); 
                    break; 
 
                case 10: 
                    addCampusLocation(); 
                    break; 
 
                case 11: 
                    removeCampusLocation(); 
                    break; 
 
                case 12: 
                    addCampusConnection(); 
                    break; 
 
                case 13: 
                    removeCampusConnection(); 
                    break; 
 
                case 14: 
                    graph.displayConnections(); 
                    break; 
 
                case 15: 
                    bfsCampus(); 
                    break; 
 
                case 16: 
                    System.out.println("Exiting program..."); 
                    break; 
 
                default: 
                    System.out.println("Invalid choice. Please select 1-16."); 
            } 
 
        } while (choice != 16); 
 
        scanner.close(); 
    } 
 
    public static void displayMenu() { 
 
        System.out.println("\n======================================"); 
        System.out.println(" UNIVERSITY STUDENT & CAMPUS SYSTEM"); 
        System.out.println("======================================"); 
 
        System.out.println("1. Add Student Record"); 
        System.out.println("2. Update Student Record"); 
        System.out.println("3. Delete Student Record"); 
        System.out.println("4. Display All Records using Linked List"); 
        System.out.println("5. Add Service Request to Queue"); 
        System.out.println("6. Process Next Service Request"); 
        System.out.println("7. Display Recent Actions using Stack"); 
        System.out.println("8. Display Students using BST"); 
        System.out.println("9. Search Student using Hashing"); 
        System.out.println("10. Add Campus Location"); 
        System.out.println("11. Remove Campus Location"); 
        System.out.println("12. Add Campus Connection/Road"); 
        System.out.println("13. Remove Campus Connection/Road"); 
        System.out.println("14. Display Campus Connections"); 
        System.out.println("15. Traverse Campus Locations using BFS"); 
        System.out.println("16. Exit"); 
 
        System.out.println("======================================"); 
    } 
 
    public static void addStudent() { 
 
        System.out.println("\n--- Add Student ---"); 
 
        String id = readText("Enter Student ID: "); 
 
        if (studentList.searchStudent(id) != null) { 
            System.out.println("Student ID already exists."); 
            return; 
        } 
 
        String name = readText("Enter Name: "); 
        String programme = readText("Enter Programme: "); 
        double marks = readMarks(); 
 
        Student student = new Student(id, name, programme, marks); 
 
        studentList.addStudent(student); 
        studentBST.insert(student); 
        hashTable.addStudent(student); 
 
        actionStack.pushAction("Added student " + id); 
 
        System.out.println("Student added successfully."); 
    } 
 
    public static void updateStudent() { 
 
        System.out.println("\n--- Update Student ---"); 
 
        String id = readText("Enter Student ID: "); 
 
        Student student = studentList.searchStudent(id); 
 
        if (student == null) { 
            System.out.println("Student not found."); 
            return; 
        } 
 
        String name = readText("Enter new Name: "); 
        String programme = readText("Enter new Programme: "); 
        double marks = readMarks(); 
 
        studentList.updateStudent(id, name, programme, marks); 
 
        actionStack.pushAction("Updated student " + id); 
 
        System.out.println("Student updated successfully."); 
    } 
 
    public static void deleteStudent() { 
 
        System.out.println("\n--- Delete Student ---"); 
 
        String id = readText("Enter Student ID: "); 
 
        Student deletedStudent = studentList.deleteStudent(id); 
 
        if (deletedStudent == null) { 
            System.out.println("Student not found."); 
            return; 
        } 
 
        hashTable.deleteStudent(id); 
 
        actionStack.pushAction("Deleted student " + id); 
 
        System.out.println("Student deleted successfully."); 
    } 
 
    public static void addServiceRequest() { 
 
        System.out.println("\n--- Add Service Request ---"); 
 
        String id = readText("Enter Student ID: "); 
 
        Student student = studentList.searchStudent(id); 
 
        if (student == null) { 
            System.out.println("Student not found."); 
            return; 
        } 
 
        String request = readText("Enter Service Request: "); 
 
        String fullRequest = id + " - " + request; 
 
        serviceQueue.addRequest(fullRequest); 
 
        actionStack.pushAction("Added service request for " + id); 
 
        System.out.println("Service request added successfully."); 
    } 
 
    public static void searchUsingHashing() { 
 
        System.out.println("\n--- Search Student Using Hashing ---"); 
 
        String id = readText("Enter Student ID: "); 
 
        Student student = hashTable.searchStudent(id); 
 
        if (student == null) { 
            System.out.println("Student not found."); 
        } else { 
            System.out.println("Student found:"); 
            System.out.println(student); 
        } 
    } 
 
    public static void addCampusLocation() { 
 
        System.out.println("\n--- Add Campus Location ---"); 
 
        String location = readText("Enter Location Name: "); 
 
        if (graph.addLocation(location)) { 
            actionStack.pushAction("Added campus location " + location); 
            System.out.println("Campus location added successfully."); 
        } else { 
            System.out.println("Location already exists."); 
        } 
    } 
 
    public static void removeCampusLocation() { 
 
        System.out.println("\n--- Remove Campus Location ---"); 
 
        String location = readText("Enter Location Name: "); 
 
        if (graph.removeLocation(location)) { 
            actionStack.pushAction("Removed campus location " + location); 
            System.out.println("Campus location removed successfully."); 
        } else { 
            System.out.println("Location not found."); 
        } 
    } 
 
    public static void addCampusConnection() { 
 
        System.out.println("\n--- Add Campus Connection ---"); 
 
        String location1 = readText("Enter First Location: "); 
        String location2 = readText("Enter Second Location: "); 
 
        if (graph.addConnection(location1, location2)) { 
 
            actionStack.pushAction( 
                    "Added connection between " 
                    + location1 + " and " + location2 
            ); 
 
            System.out.println("Connection added successfully."); 
 
        } else { 
            System.out.println( 
                    "Unable to add connection. " 
                    + "Check locations or duplicate connection." 
            ); 
        } 
    } 
 
    public static void removeCampusConnection() { 
 
        System.out.println("\n--- Remove Campus Connection ---"); 
 
        String location1 = readText("Enter First Location: "); 
        String location2 = readText("Enter Second Location: "); 
 
        if (graph.removeConnection(location1, location2)) { 
 
            actionStack.pushAction( 
                    "Removed connection between " 
                    + location1 + " and " + location2 
            ); 
 
            System.out.println("Connection removed successfully."); 
 
        } else { 
            System.out.println("Connection not found."); 
        } 
    } 
 
    public static void bfsCampus() { 
 
        System.out.println("\n--- BFS Campus Traversal ---"); 
 
        String start = readText("Enter Starting Location: "); 
 
        graph.bfs(start); 
    } 
 
    public static String readText(String message) { 
 
        while (true) { 
 
            System.out.print(message); 
 
            String input = scanner.nextLine().trim(); 
 
            if (!input.isEmpty()) { 
                return input; 
            } 
 
            System.out.println("Input cannot be empty."); 
        } 
    } 
 
    public static int readInt(String message) { 
 
        while (true) { 
 
            System.out.print(message); 
 
            try { 
 
                return Integer.parseInt(scanner.nextLine().trim()); 
 
            } catch (NumberFormatException e) { 
 
                System.out.println("Invalid number. Please try again."); 
            } 
        } 
    } 
 
    public static double readMarks() { 
 
        while (true) { 
 
            System.out.print("Enter Marks (0-100): "); 
 
            try { 
 
                double marks = Double.parseDouble(scanner.nextLine().trim()); 
 
                if (marks >= 0 && marks <= 100) { 
                    return marks; 
                } 
 
                System.out.println("Marks must be between 0 and 100."); 
 
            } catch (NumberFormatException e) { 
 
                System.out.println("Please enter a valid number."); 
            } 
        } 
    } 
}