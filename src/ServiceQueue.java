public class ServiceQueue {

    private String[] requests;
    private int front;
    private int rear;
    private int count;

    public ServiceQueue(int size) {

        requests = new String[size];

        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(String request) {

        if (count == requests.length) {

            System.out.println(
                "Service queue is full."
            );

            return;
        }

        rear =
            (rear + 1) % requests.length;

        requests[rear] = request;

        count++;

        System.out.println(
            "Service request added."
        );
    }

    public String dequeue() {

        if (count == 0) {
            return null;
        }

        String request = requests[front];

        front =
            (front + 1) % requests.length;

        count--;

        return request;
    }

    public void displayQueue() {

        if (count == 0) {

            System.out.println(
                "No service requests."
            );

            return;
        }

        System.out.println(
            "\n===== SERVICE QUEUE ====="
        );

        int index = front;

        for (int i = 0; i < count; i++) {

            System.out.println(
                "- " + requests[index]
            );

            index =
                (index + 1) % requests.length;
        }
    }
}