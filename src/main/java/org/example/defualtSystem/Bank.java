package org.example.defualtSystem;

import org.example.Utils.PlayInfo;
import org.example.interfaces.BankInterface;
import org.example.models.*;
import org.example.models.Character;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bank extends Industry implements BankInterface {

    private static final int MAX_EMPLOYEE_COUNT = 5;
    private static final float BASE_EMP_SALARY = 0.5f;
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    private Manager manager = null;

    public static  BankTurnover turnover;

    public Bank(Property property,Character root) {
        super("Bank",property,root,100.0f);
        turnover = new BankTurnover();
    }

    public BankAccount newAccount(String username,String password){
        BankAccount bankAccount = new BankAccount(username,password,10f,new Date());
        accounts.add(bankAccount);
        return bankAccount;
    }
    public boolean registerAsEmp(Character character){
        if(employees.size() >= MAX_EMPLOYEE_COUNT)return false;
        Employee employee = new Employee(character.getUserInfo().getUsername(),this,BASE_EMP_SALARY,character.getAccount());
        employees.add(employee);
        return true;
    }


    public String bankDetail(Character character){
        if(character.getUserInfo().getUsername().equals(manager.getUsername())){
            return "";
        }
        return "Only Manager can see Bank detail";
    }

    @Override
    public void menu() {
        System.out.println("Welcome to "+getTitle());
        System.out.println("Your Balance: "+ PlayInfo.playCharacter.getAccount().getMoney());
        System.out.println("press enter to return");
        new Scanner(System.in).nextLine();
    }
}
