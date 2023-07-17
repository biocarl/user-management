import java.util.List;

public class UserController {
    private UserModel userModel;
    private UserView userView;

    public UserController(UserModel userModel, UserView userView) {
        this.userModel = userModel;
        this.userView = userView;
    }

    public void handleUserInput() {
        while (true) {
            userView.displayMenu();
            String choice = App.scanner.nextLine();

            switch (choice) {
                case "1":
                    addUser();
                    break;
                case "2":
                    deleteUser();
                    break;
                case "3":
                    viewUsers();
                    break;
                case "4":
                    userView.displayMessage("Exiting...");
                    System.exit(0);
                    break;
                default:
                    userView.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addUser() {
        User user = userView.getUserInput();
        userModel.addUser(user);
        userView.displayMessage("User added successfully.");
    }

    private void deleteUser() {
        int index = userView.getIndexToDelete();
        userModel.deleteUser(index);
        userView.displayMessage("User deleted successfully.");
    }

    private void viewUsers() {
        List<User> users = userModel.getUsers();
        userView.displayUsers(users);
    }
}