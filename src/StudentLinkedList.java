

public class StudentLinkedList {

    private StudentNode head;

    public boolean addStudent(Student student) {

        if (searchStudent(student.getStudentId()) != null) {
            return false;
        }

        StudentNode newNode = new StudentNode(student);

        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return true;
    }

    public Student searchStudent(String studentId) {

        StudentNode current = head;

        while (current != null) {

            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    public boolean updateStudent(String studentId, String name,
                                 String programme, double marks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        return true;
    }

    public Student deleteStudent(String studentId) {

        if (head == null) {
            return null;
        }

        if (head.student.getStudentId().equalsIgnoreCase(studentId)) {

            Student deletedStudent = head.student;
            head = head.next;

            return deletedStudent;
        }

        StudentNode current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                Student deletedStudent = current.next.student;
                current.next = current.next.next;

                return deletedStudent;
            }

            current = current.next;
        }

        return null;
    }

    public void displayAll() {

        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode current = head;

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}