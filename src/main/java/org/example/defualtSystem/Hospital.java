package org.example.defualtSystem;

import org.example.Utils.Console;
import org.example.Utils.PlayInfo;
import org.example.models.Character;
import org.example.models.Industry;
import org.example.models.Property;

import java.util.*;

public class Hospital extends Industry {
    private static final float INCOME = 0.5f;
    private static final float EMPLOYEE_INCOME = 0.02f;

    private Map<Character,Float> payments;
    public Hospital(String title, Property property, Character character) {
        super(title, property, character,EMPLOYEE_INCOME);
        payments = new HashMap<Character,Float>();
    }
    @Override
    public void menu() {
        Console.ClearConsole();
        System.out.println("Welcome to "+getTitle());
        System.out.println("Username : "+ PlayInfo.playCharacter.getUserInfo().getUsername());
        List<String> items = new ArrayList<>();
        items.add("visit");
        items.add("pay");
        items.add("get hired");
        items.add("return");
        boolean c = true;
        Scanner scanner = new Scanner(System.in);
        while (c){
            Console.ShowMenu(items);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    visit();
                    break;
                }
                case 2:{
                    pay();
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

    private void getHired() {
        //todo
    }

    private void pay() {
        if (payments.containsKey(PlayInfo.playCharacter)){
            PlayInfo.playCharacter.getAccount().withdraw(getOwner(),payments.get(PlayInfo.playCharacter));
            payments.remove(PlayInfo.playCharacter);
            System.out.println("Paid Successfully\npress enter to continue");
            new Scanner(System.in).nextLine();
        }
    }

    private void visit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your problem?:\n");
        scanner.nextLine();
        if (payments.containsKey(PlayInfo.playCharacter)){
            payments.put(PlayInfo.playCharacter,0.001f);
        }else {
            payments.put(PlayInfo.playCharacter,payments.get(PlayInfo.playCharacter)+0.001f);
        }
        System.out.println("Visited Successfully your fee is 1000000T \npress enter to continue");
        scanner.nextLine();
    }
}
