package org.example.Utils;

import java.util.List;

public class Console {
    public static void ClearConsole(){
        //TODO
    }

    public static void ShowMenu(List<String> items){
        for (int i =0;i<items.size();i++){
            System.out.println(Integer.toString(i+1)+" - "+items.get(i));
        }
    }
}
