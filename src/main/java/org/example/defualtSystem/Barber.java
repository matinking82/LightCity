package org.example.defualtSystem;

import org.example.Utils.Console;
import org.example.Utils.PlayInfo;
import org.example.models.Character;
import org.example.models.Industry;
import org.example.models.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barber extends Industry {

    private static final float INCOME = 0.4f;
    private static final float EMPLOYEE_INCOME = 0.005f;
    public Barber(String title, Property property, Character character) {
        super(title, property, character, EMPLOYEE_INCOME);
    }

    @Override
    public void menu() {
        List<String> items = new ArrayList<>();
        items.add("Cut hairs");
        items.add("Get hired");
        items.add("Return");
        boolean c = true;
        Scanner scanner = new Scanner(System.in);
        while (c){
            Console.ShowMenu(items);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    Cut();
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

    private void Cut() {
        Console.ClearConsole();
        List<String> items = new ArrayList<>();
        items.add("Khoroosi 100000T");
        items.add("Sade 50000T");
        items.add("Kachal 25000T");
        items.add("Kootah 50000T");
        items.add("Return");
        Console.ShowMenu(items);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                System.out.println("Khoroosi, it'll be 100000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000100000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 2:{
                System.out.println("Sade, it'll be 50000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000050000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 3:{
                System.out.println("Kachal, it'll be 25000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000025000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 4:{
                System.out.println("Kootah, it'll be 50000T\npress enter to pay..");
                scanner.nextLine();
                PlayInfo.playCharacter.getAccount().withdraw(getOwner(),0.000050000f);
                System.out.println("have a great day\npress enter to return..");
                scanner.nextLine();
                break;
            }
            case 5:{
                break;
            }
        }
    }
}
