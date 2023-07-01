package org.example;

import org.example.Utils.Console;
import org.example.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Game game = new Game();
    private static Scanner scanner = new Scanner(System.in);
    private static Database db = new Database();
    public static void main(String[] args) {
            showMenu();
    }
    public static void showMenu(){
            mainMenu();
            String next = scanner.next();
            switch (next) {
                case "1" -> game.continueGame(loginMenu());
                case "2" -> game.startGame(loginMenu());
                case "3" -> joinServer();
                case "4" -> System.exit(0);
            }
    }
    public static void mainMenu(){
        List<String> items = new ArrayList<>();
        items.add("Continue");
        items.add("Start a new game");
        items.add("Join Server");
        items.add("Exit");

        Console.ShowMenu(items);
    }

    public static User loginMenu(){
        Console.ClearConsole();
        while (true){
            User user = new User();
            System.out.println("Please enter your username: ");
            user.setUsername(scanner.next());
            System.out.println("Please enter your Password: ");
            user.setPassword(scanner.next());

            if (db.loginGame(user)){
                return user;
            }else {
                db.registerGame(user);
                return user;
            }
        }
    }

    private static void joinServer(){
        System.out.print("Enter Server Ip Address :");
        String ip = scanner.next();
        System.out.print("Enter Server Port :");
        int port = scanner.nextInt();
        game.joinServer(ip,port);
    }
}
