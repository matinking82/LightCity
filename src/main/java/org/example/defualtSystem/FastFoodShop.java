package org.example.defualtSystem;

import org.example.Utils.Console;
import org.example.Utils.PlayInfo;
import org.example.models.Character;
import org.example.models.Employee;
import org.example.models.Industry;
import org.example.models.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FastFoodShop extends Industry {

    /**
     * Industry type example (Business)
     * */
    private static final float INCOME = 0.3f;
    private static final float EMPLOYEE_INCOME = 0.02f;
    public FastFoodShop(String title, Property property, Character character) {
        super(title, property, character,EMPLOYEE_INCOME);
    }

    @Override
    public void menu() {
        Console.ClearConsole();
        System.out.println("Welcome to "+getTitle());
        List<String> items = new ArrayList<>();
        items.add("order");
        items.add("prices");
        items.add("get hired");
        items.add("return");
        boolean c = true;
        Scanner scanner = new Scanner(System.in);
        while (c){
            Console.ShowMenu(items);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    order();
                    break;
                }
                case 2:{
                    prices();
                    break;
                }
                case 3:{
                    getHired();
                    break;
                }
                case 4:{
                    c = false;
                    break;
                }
            }
        }
    }

    private void order() {
        Console.ClearConsole();
        List<String> items = new ArrayList<>();
        items.add("Pizza - 150000T");
        items.add("Burger - 100000T");
        items.add("Sandwich - 85000T");
        items.add("French Fries - 50000T");
        items.add("Pepsi - 20000T");
        items.add("return");
        Console.ShowMenu(items);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                System.out.println("Here's your pizza, it'll be 150000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000150000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 2:{
                System.out.println("Here's your Burger, it'll be 100000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000100000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 3:{
                System.out.println("Here's your Sandwich, it'll be 85000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000085000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 4:{
                System.out.println("Here's your French Fries, it'll be 50000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000050000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 5:{
                System.out.println("Here's your Pepsi, it'll be 20000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000020000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 6:{
                break;
            }
        }
    }
    private void prices() {
        Console.ClearConsole();
        System.out.println("Pizza - 150000T");
        System.out.println("Burger - 100000T");
        System.out.println("Sandwich - 85000T");
        System.out.println("French Fries - 50000T");
        System.out.println("Pepsi - 20000T");
        System.out.println("press enter to continue..");
        new Scanner(System.in).next();
    }
    private void getHired() {
        //todo
    }
}
