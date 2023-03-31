package authorization;

import java.io.*;
import java.util.HashMap;

public class Authorization {
    public static final String DATABASE_PATH =
            "C:\\Users\\admin\\IdeaProjects\\Registration\\src\\main\\resources\\database.txt";

    File databaseFile = new File(DATABASE_PATH);
    HashMap<Integer, User> data = new HashMap<>();


    public void readDatabaseFile() {
        try(FileReader fileReader = new FileReader(databaseFile)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            int counter = 0;
            createUser(line, counter);
            System.out.println("Username - " + data.get(0).getUsername());
            System.out.println("Password - " + data.get(0).getPassword());
        }
        catch(FileNotFoundException exception) {
            System.out.println("Database not found.");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void parsePassword(String databaseLine, User user) {
        char[] chars = databaseLine.toCharArray();
        StringBuilder password = new StringBuilder();

        for(int i=0; i<chars.length; i++){
            String symbol = String.valueOf(chars[i]);
            if(symbol.equals(" ")) {
                for(int k=i+3; k<chars.length; k++) {
                    password.append(chars[k]);
                }
                user.setPassword(password.toString());
                break;
            }
        }
    }

    private void parseUsername(String databaseLine, User user) {
        char[] chars = databaseLine.toCharArray();
        StringBuilder username = new StringBuilder();

        for(char aChar : chars) {
            String symbol = String.valueOf(aChar);
            if(symbol.equals(" ")) {
                user.setUsername(username.toString());
                break;
            } else {
                username.append(symbol);
            }
        }
    }
    private void createUser(String line, int counter) {
        User user = new User();
        parseUsername(line, user);
        parsePassword(line, user);
        data.put(counter, user);
    }
}
