package org.example;

import org.example.Utils.Console;
import org.example.models.User;

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
        if (next.equals("1")) {
            game.continueGame(loginMenu());
        }else if(next.equals("2")){
            game.startGame(loginMenu());
        }else if (next.equals("3")){
            joinServer();
        }else if (next.equals("4"))
            System.exit(0);
    }
    public static void mainMenu(){

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
                System.out.println("LoginFailed");
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
