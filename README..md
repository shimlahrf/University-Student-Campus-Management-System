-# University Student & Campus Management System

## 1. Project Title

**University Student & Campus Management System**

## 2. Project Description

The University Student & Campus Management System is a Java-based console application developed to manage university student records, student service requests, and campus locations.

The main purpose of this project is to demonstrate the practical use of different Data Structures and Algorithms in a real-world university management system.

The system provides a simple menu-driven interface where users can add, update, delete, search, and display student information. It also manages service requests and campus locations and connections.

## 3. Main Features

* Add student records
* Update student records
* Delete student records
* Display all student records
* Add service requests
* Process service requests
* Display recent system actions
* Display students using Binary Search Tree
* Search students using Hashing
* Add campus locations
* Remove campus locations
* Add campus connections
* Remove campus connections
* Display campus connections
* Traverse campus locations using BFS

## 4. Data Structures and Algorithms Used

### Linked List

Used to store and manage student records.

### Stack

Used to store recent actions performed in the system. The Stack follows the **LIFO (Last-In, First-Out)** principle.

### Queue

Used to manage student service requests. The Queue follows the **FIFO (First-In, First-Out)** principle.

### Binary Search Tree

Used to store student records based on Student ID and display them in sorted order.

### Hashing

Used to search student records efficiently using Student ID.

### Graph

Used to represent campus locations and connections between locations.

### Breadth-First Search (BFS)

Used to traverse connected campus locations starting from a selected location.

## 5. Technologies Used

* **Programming Language:** Java
* **IDE:** Eclipse
* **Version Control:** GitHub
* **Application Type:** Console-based Java Application

## 6. Project Structure

```text
CampusManagement
│
└── src
    │
    └── campusmanagment
        │
        ├── Student.java
        ├── StudentNode.java
        ├── StudentLinkedList.java
        ├── ActionStack.java
        ├── ServiceQueue.java
        ├── BSTNode.java
        ├── StudentBST.java
        ├── HashTable.java
        ├── Graph.java
        └── Main.java
```

## 7. Class Description

* **Student.java** – Stores student information.
* **StudentNode.java** – Represents a node used in the Linked List.
* **StudentLinkedList.java** – Manages student records using a Linked List.
* **ActionStack.java** – Manages recent actions using a Stack.
* **ServiceQueue.java** – Manages student service requests using a Queue.
* **BSTNode.java** – Represents a node used in the Binary Search Tree.
* **StudentBST.java** – Manages student records using a Binary Search Tree.
* **HashTable.java** – Stores and searches student records using Hashing.
* **Graph.java** – Manages campus locations, connections, and BFS traversal.
* **Main.java** – Contains the main menu and connects the different system functions.

## 8. How to Run the Project

1. Open **Eclipse IDE**.
2. Import the project into Eclipse.
3. Make sure all Java files are inside the `campusmanagment` package.
4. Open `Main.java`.
5. Right-click on `Main.java`.
6. Select **Run As → Java Application**.
7. The system menu will appear in the Eclipse Console.
8. Select an option from the menu and follow the instructions.

## 9. Team Members and Contributions

### 1. RF.Shimlah

**Student ID:** 23DA2-0940

**Role:** Team Leader

**Contribution: Student Management and Main System Integration**

* Worked on `Student.java`
* Worked on `StudentNode.java`
* Worked on `StudentLinkedList.java`
* Worked on `Main.java`
* Implemented add, search, update, delete, and display operations for student records
* Developed the main system menu
* Integrated the different data structures and system functions
* Connected student, service request, and campus management functions
* Tested the complete system
* Coordinated GitHub collaboration and project integration

### 2. SF.Aashiqa

**Student ID:** 23DA2-1030

**Contribution: Stack and Queue**

* Worked on `ActionStack.java`
* Worked on `ServiceQueue.java`
* Implemented Stack operations for storing recent system actions
* Implemented Queue operations for managing student service requests
* Tested Stack and Queue functionality

### 3. S.Suaath

**Student ID:** 23DA2-01059

**Contribution: Hashing**

* Worked on `HashTable.java`
* Implemented Hashing for efficient student search
* Implemented student search using Student ID
* Managed student records using the Hash Table
* Tested Hashing and student search functionality

### 4. MS.Thisan Banu

**Student ID:** 23DA2-0980

**Contribution: Graph and Campus Location Management**

* Worked on `Graph.java`
* Added campus locations
* Removed campus locations
* Added campus connections
* Removed campus connections
* Displayed campus connections
* Implemented Breadth-First Search (BFS)
* Tested Graph and BFS functionality

## 10. GitHub Collaboration

The project was developed collaboratively using GitHub.

* Each team member worked on their assigned components.
* Team members created separate branches for their work.
* Changes were committed and pushed to their respective branches.
* Pull Requests were used to submit changes for review.
* The Team Leader reviewed and merged the completed contributions into the main branch.
* The team tested the integrated project after merging the contributions.

## 11. Sample System Menu

```text
======================================
 UNIVERSITY STUDENT & CAMPUS SYSTEM
======================================

1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS
16. Exit

======================================
```

## 12. Conclusion

The University Student & Campus Management System demonstrates how different Data Structures and Algorithms can be applied to solve practical problems in a university environment.

The project combines Linked List, Stack, Queue, Binary Search Tree, Hashing, Graph, and BFS into one Java console application.

The system provides student management, service request management, and campus management functions through a simple menu-driven interface.

The project also demonstrates collaborative software development using GitHub branches, commits, and Pull Requests.
