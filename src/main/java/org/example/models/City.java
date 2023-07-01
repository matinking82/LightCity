package org.example.models;

import org.example.Utils.Console;
import org.example.Utils.PlayInfo;
import org.example.defualtSystem.*;
import org.example.interfaces.CityInterface;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class City implements CityInterface {
    private final ArrayList<Character> characters;
    private Bank bankSystem;
    private final Municipality municipality;
    private final StockMarket stockMarket;
    private List<Industry> industries;
    private Character root;

    public City() {
        characters = new ArrayList<>();
        municipality = new Municipality();
//        Get Bank Property from municipality
        stockMarket = new StockMarket();
        stockMarket.startMarketSimulation();
        industries = new ArrayList<>();
    }

    @Override
    public void joinCharacter(User userinfo) {
        Character character = new Character(userinfo, null, new Life(), null, null, null);
        PlayInfo.playCharacter = character;
        characters.add(character);
        FastFoodShop fastFoodShop = new FastFoodShop("pizza forooshi",municipality
                .buyProperty(character,new float[]{5,5}),character);
        bankSystem = new Bank(municipality.buyProperty(character,new float[]{0f,0f}), character);
        BankAccount newAccount = bankSystem.newAccount(userinfo.getUsername(), userinfo.getPassword());
        character.setAccount(newAccount);

        industries.add(fastFoodShop);
        industries.add(bankSystem);
        beginGame(character);
    }

    @Override
    public void getCityDetail() {
        String players = Arrays.toString(characters.toArray());
    }


    /**
     * Begin Game function generate a new thread for each character ,<b > DO NOT CHANGE THIS FUNCTION STRUCTURE</b> ,
     *
     * */
    private void beginGame(Character character) {
        Thread thread = new Thread(() -> {
            try {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    List<String> items = new ArrayList<>();
                    items.add("Go to");
                    items.add("Process Location");
                    items.add("Dashboard");
                    items.add("Life");
                    items.add("Exit");
                    Console.ShowMenu(items);
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> Goto();
                        case 2 -> ProcessLocation();
                        case 3 -> Dashboard();
                        case 4 -> LifeMenu();
                        case 5 -> System.exit(0);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    private void LifeMenu() {
        Console.ClearConsole();
        Life life = PlayInfo.playCharacter.getLife();
        System.out.println("Your Life Details");
        System.out.println("Food: "+life.getFood());
        System.out.println("Water: "+life.getWater());
        System.out.println("Sleep: "+life.getSleep());
        System.out.println("Press enter to return..");
        new Scanner(System.in).nextLine();
    }

    private void Dashboard() {
        Console.ClearConsole();
        System.out.println("Your Character Details");
        System.out.println("Username: "+PlayInfo.playCharacter.getUserInfo().getUsername());
        System.out.println("Job: "
                +((PlayInfo.playCharacter.getJob()==null)? "Unemployed":PlayInfo.playCharacter.getJob().getTitle()));
        System.out.println("Balance: "+PlayInfo.playCharacter.getAccount().getMoney());
        System.out.println("Press enter to return..");
        new Scanner(System.in).nextLine();
    }

    private void ProcessLocation() {
            for (Industry i :
                industries) {
                if (Arrays.compare(PlayInfo.currentCoordinates,i.getCoordinate())==0) {
                    i.menu();
                }
            }
    }

    private void Goto() {
        System.out.println("Go to a ...:");
        List<String> items = new ArrayList<>();
        Console.ClearConsole();
        items.add("coordinate");
        items.add("Industry");
        Console.ShowMenu(items);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice){
            case 1:{
                System.out.println("Enter the coordinate you want to go: ");
                PlayInfo.currentCoordinates = new float[]{scanner.nextInt(),scanner.nextInt()};
                System.out.println("Successfully went to the coordinate");
                break;
            }
            case 2:{
                System.out.println("Enter the title of the industry you want to go: ");

                Scanner sScanner = new Scanner(System.in);
                String title = sScanner.next();

                for (Industry i :
                        industries) {
                    if (i.getTitle().equals(title)){
                        PlayInfo.currentCoordinates = i.getCoordinate();
                    }
                }

                System.out.println("Successfully went to the industry");
                break;
            }
        }
    }
}
