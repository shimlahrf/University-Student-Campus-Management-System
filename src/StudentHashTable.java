public class StudentHashTable {

    private Student[] table;
    private int size;

    public StudentHashTable(int size) {
        this.size = size;
        this.table = new Student[size];
    }

    private int hash(int studentId) {
        return Math.abs(studentId) % size;
    }

    public void insert(Student student) {

        int index = hash(student.getStudentId());

        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    == student.getStudentId()) {

                return;
            }

            index = (index + 1) % size;

            if (index == originalIndex) {

                System.out.println(
                    "Hash table is full."
                );

                return;
            }
        }

        table[index] = student;
    }

    public Student search(int studentId) {

        int index = hash(studentId);

        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    == studentId) {

                return table[index];
            }

            index = (index + 1) % size;

            if (index == originalIndex) {
                break;
            }
        }

        return null;
    }

    public void displayTable() {

        for (int i = 0; i < size; i++) {

            if (table[i] == null) {

                System.out.println(
                    i + " -> Empty"
                );

            } else {

                System.out.println(
                    i +
                    " -> Student ID: " +
                    table[i].getStudentId() +
                    ", Name: " +
                    table[i].getName()
                );
            }
        }
    }
}