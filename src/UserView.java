import java.util.List;

public class UserView {
    public void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add user");
        System.out.println("2. Delete user");
        System.out.println("3. View users");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public User getUserInput() {
        System.out.print("Enter name: ");
        String name = App.scanner.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(App.scanner.nextLine());

        System.out.print("Enter password: ");
        String password = App.scanner.nextLine();

        return new User(name, age, password);
    }

    public int getIndexToDelete() {
        System.out.print("Enter user index to delete: ");
        return Integer.parseInt(App.scanner.nextLine());
    }

    public void displayUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("Users:");
            for (int i = 0; i < users.size(); i++) {
                System.out.println("[" + i + "] " + users.get(i));
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}