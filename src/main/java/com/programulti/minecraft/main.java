/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programulti.minecraft;


import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author DELL
 */


public class main {
  
    private static String inputData = "R";
    private static ArrayList<MinecraftEntry> myEntries;
    private static conn myConnection;
    private static Scanner keyInput;
    private static String LineSeperator;
    
    public static void main(String args[]) {
        
        myConnection = new conn();
        myConnection.getConnection();
        keyInput = new Scanner(System.in);
        LineSeperator = new String(new char[118]).replace("\0", "-");
        
        
        System.out.println(".===============================================================================.\n" +
"|                                      ,                                        |\n" +
"|                                 .;xxxxxxx;.                                   |\n" +
"|                            .;xxxxxxxx%%xxxxxxx;.                              |\n" +
"|                       .;xxxxxx%%++xx%%xxxxx%%xxxxxx;.                         |\n" +
"|                  .;xxxx%%xxx%%xxx%%xxxxxxxxx%++x%%xxxxxx;.                    |\n" +
"|                  |**'*-.xxxxxxxxxxxxxx++xxxxxxx%%%x.-*'**|                    |\n" +
"|                  |*******`\"-.;x%%@@%%++x%%xxx;.-\"`*******|                    |\n" +
"|                  |::`;********`\"-.xxxxxxx.-\"`*********:::|                    |\n" +
"|                  |::::\"`:::`*******`\"x\"`*********,***`:::|                    |\n" +
"|                  |::::::::::::*******|*****`***\"`::::::::|                    |\n" +
"|                  |:::::cc:::::::\"'-**|*`\"**::::::::::cc::|                    |\n" +
"|                  |::cc:::::::::::::::|::::::::::::cc:::::|                    |\n" +
"|                  |:::::::cc::::::cc::|::::::cc:::::::::::|                    |\n" +
"|                  |::cc:::::::::::::::|::cc:::::cc::::::::|                    |\n" +
"|                  :;::::::::::cc::::::|::::::::::::::::::;:                    |\n" +
"|                     `\":;:::::::::::::|::::cc:::::::;:\"`                       |\n" +
"|                          `\":;::::cc::|::::::::;:`                             |\n" +
"|                               `\":;:::|:::;:\"`                                 |\n" +
"|                                    `\":\"`                                      |\n" +
"|                                                                               |\n" +
"| ##   ##  #####  ##   ##  #######   #####   ######     ###    #######  ####### |\n" +
"| ### ###   ###   ###  ##  ##       ##   ##  ##   ##   ## ##   ##       # ### # |\n" +
"| #######   ###   #######  ######   ##       ######   ##   ##  #####      ###   |\n" +
"| ## # ##   ###   ## ####  ##       ##   ##  ##  ##   #######  ##         ###   |\n" +
"| ##   ##  #####  ##   ##  #######   #####   ##   ##  ##   ##  ##         ###   |\n" +
"'==============================================================================='");
        
        System.out.println(LineSeperator);
        System.out.println("Iniciando Proyecto");
        System.out.println(LineSeperator);
        
              
        while (!inputData.equalsIgnoreCase("Q")) {
            System.out.println();
            switch (inputData.toUpperCase()) {
                case "R": 
                    
                    break;
                case "N": 
                   
                    break;
                case "U": 
                    
                    break;
                case "D": 
                    
                    break;
            }
            mostrar();
            menu();
        } 
    }
    
    
    public static void menu(){
        System.out.println(LineSeperator);
        System.out.println("Q Quit\tR Reload\tN New\tU Update\tD Delete \n Press Key and Enter: ");
        inputData = keyInput.nextLine();
    }
    
    public static void mostrar(){
        myEntries = myConnection.getAllMinecraftEntry();
        
        System.out.println(LineSeperator);
        System.out.println(String.format("%s\t%s\t%-40s\t%s\t%s", "#","MINECRAFTBLOCKNAME",
                "MINECRAFTCRAFTRECEIPT", "MINECRAFTATTACK", "MINECRAFTDEFENCE"));
        System.out.println(LineSeperator);
        
        for (MinecraftEntry _entry : myEntries) { 
            System.out.println(_entry.getFormattedText());
        }        
        System.out.println(LineSeperator);
        System.out.println(String.format("Total Rows: %d",myEntries.size()));
}

}
