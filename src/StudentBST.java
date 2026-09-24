public class StudentBST {

    private BSTNode root;

    public StudentBST() {
        root = null;
    }

    public void insert(Student student) {

        root = insertRecursive(root, student);
    }

    private BSTNode insertRecursive(
            BSTNode node,
            Student student) {

        if (node == null) {
            return new BSTNode(student);
        }

        if (student.getStudentId()
                < node.student.getStudentId()) {

            node.left =
                    insertRecursive(node.left, student);

        } else if (student.getStudentId()
                > node.student.getStudentId()) {

            node.right =
                    insertRecursive(node.right, student);
        }

        return node;
    }

    public Student search(int studentId) {

        BSTNode current = root;

        while (current != null) {

            if (studentId ==
                    current.student.getStudentId()) {

                return current.student;
            }

            if (studentId <
                    current.student.getStudentId()) {

                current = current.left;

            } else {

                current = current.right;
            }
        }

        return null;
    }

    public void displayInOrder() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(BSTNode node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);

        node.student.displayStudent();

        inOrder(node.right);
    }
}