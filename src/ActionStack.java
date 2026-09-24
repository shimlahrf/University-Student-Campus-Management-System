public class ActionStack {

    private String[] actions;
    private int top;

    public ActionStack(int size) {

        actions = new String[size];
        top = -1;
    }

    public void push(String action) {

        if (top == actions.length - 1) {

            System.out.println(
                "Action stack is full."
            );

            return;
        }

        top++;
        actions[top] = action;
    }

    public String pop() {

        if (top == -1) {
            return null;
        }

        String action = actions[top];

        top--;

        return action;
    }

    public void displayActions() {

        if (top == -1) {

            System.out.println(
                "No recent actions."
            );

            return;
        }

        System.out.println(
            "\n===== RECENT ACTIONS ====="
        );

        for (int i = top; i >= 0; i--) {

            System.out.println(
                "- " + actions[i]
            );
        }
    }
}
