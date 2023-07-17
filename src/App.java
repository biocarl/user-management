import java.util.Scanner;

public class App {
    public static final String FILE_PATH = "users.csv";
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserModel userModel = new UserModel(FILE_PATH);
        UserView userView = new UserView();
        UserController userController = new UserController(userModel, userView);
        userController.handleUserInput();
    }
}