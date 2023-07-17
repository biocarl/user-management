import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> users;
    private String filePath;

    public UserModel(String filePath) {
        this.filePath = filePath;
        this.users = new ArrayList<>();
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                String name = userData[0];
                int age = Integer.parseInt(userData[1]);
                String password = userData[2];
                User user = new User(name, age, password);
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        saveUsersToFile();
    }

    public void deleteUser(int index) {
        if (index >= 0 && index < users.size()) {
            users.remove(index);
            saveUsersToFile();
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.write(user.getName() + "," + user.getAge() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }
}