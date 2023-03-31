package authorization;

import registration.Registration;

import java.io.IOException;
import java.util.Scanner;

public class Selector {
    public void select() throws IOException {
        System.out.println("Выберите действие: ");
        System.out.println("Авторизация: 1");
        System.out.println("Регистрация: 2");

        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        if (selection.equals("1")) {
            Authorization authorization = new Authorization();
            authorization.authorize();
        }
        else if(selection.equals("2")) {
            Registration registration = new Registration();
            registration.startRegistration();
        }
        else {
            System.out.println("Неизвестный выбор. Попробуйте ещё.");
            select();
        }
    }
}
