package registration;

import authorization.Authorization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registration {
    private void registrate(String newUsername, String newPassword)
            throws IOException {
        FileWriter writer = new FileWriter(
                Authorization.databaseFile, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write("\n" + newUsername + " - " + newPassword);
        bufferWriter.close();
    }

    public void startRegistration() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Придумайте логин: ");
        String newUsername = scanner.nextLine();
        System.out.println("Придумайте пароль: ");
        String newPassword = scanner.nextLine();

        registrate(newUsername, newPassword);
        System.out.println("Вы успешно зарегистрированы.");
    }
}
