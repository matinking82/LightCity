package org.example.defualtSystem;

import org.example.Utils.Console;
import org.example.Utils.PlayInfo;
import org.example.models.Character;
import org.example.models.Industry;
import org.example.models.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClothShop extends Industry {
    private static final float INCOME = 0.5f;
    private static final float EMPLOYEE_INCOME = 0.02f;

    public ClothShop(String title, Property property, Character character) {
        super(title, property, character, EMPLOYEE_INCOME);
    }

    @Override
    public void menu() {
        Console.ClearConsole();
        System.out.println("Welcome to "+getTitle());
        List<String> items = new ArrayList<>();
        items.add("Buy");
        items.add("get hired");
        items.add("return");
        boolean c = true;
        Scanner scanner = new Scanner(System.in);
        while (c){
            Console.ShowMenu(items);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    Buy();
                    break;
                }
                case 2:{
                    getHired();
                    break;
                }
                case 3:{
                    c = false;
                    break;
                }
            }
        }
    }

    private void getHired() {
        //TODO
    }

    private void Buy() {
        Console.ClearConsole();
        List<String> items = new ArrayList<>();
        items.add("T-Shirt - 150000T");
        items.add("Pants - 200000T");
        items.add("Pejamas - 100000T");
        items.add("Socks - 50000T");
        items.add("Shoes - 300000T");
        items.add("return");
        Console.ShowMenu(items);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                System.out.println("Here's your T-Shirt, it'll be 150000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000150000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 2:{
                System.out.println("Here's your Pants, it'll be 200000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000200000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 3:{
                System.out.println("Here's your Pejamas, it'll be 100000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000100000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 4:{
                System.out.println("Here's your Socks, it'll be 50000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000050000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 5:{
                System.out.println("Here's your Shoes, it'll be 20000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000300000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 6:{
                break;
            }
        }
    }
}
