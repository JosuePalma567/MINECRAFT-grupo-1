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
        
              
        while (!inputData.equalsIgnoreCase("S")) {
            System.out.println();
            switch (inputData.toUpperCase()) {
                case "N": 
                   nuevoobjeto();
                    break;
                case "A": 
                   actualizarRegistro();
                    break;
                case "E": 
                     eliminarRegistro();
                    break;
                    
                    
            }
            mostrar();
            menu();           
        } 
        System.out.println("Programa finaliazado");
    }
    
    
    public static void menu(){
        System.out.println(LineSeperator);
        System.out.println("\tN Nuevo \tA Actualizar\tE Eliminar \tS Salir\n Presione una tecla ");
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

    
    
    public static void nuevoobjeto(){
        System.out.println();
        System.out.println("Getting New Data");
        System.out.println(LineSeperator);
        System.out.println("MINECRAFTBLOCKNAME: ");
        String MINECRAFTBLOCKNAME = keyInput.nextLine();
        System.out.println("MINECRAFTCRAFTRECEIPT: ");
        String MINECRAFTCRAFTRECEIPT = keyInput.nextLine();
        System.out.println("MINECRAFTATTACK: ");
        int MINECRAFTATTACK = keyInput.nextInt();
        System.out.println("MINECRAFTDEFENCE: ");
        int MINECRAFTDEFENCE = keyInput.nextInt();
        MinecraftEntry newEntry = new MinecraftEntry();
        newEntry.setMINECRAFTBLOCKNAME(MINECRAFTBLOCKNAME);
        newEntry.setMINECRAFTCRAFTRECEIPT(MINECRAFTCRAFTRECEIPT);
        newEntry.setMINECRAFTATTACK(MINECRAFTATTACK);
        newEntry.setMINECRAFTDEFENCE(MINECRAFTDEFENCE);
        
        myConnection.addNewMinecraftEntry(newEntry);
        
        System.out.println();
        
    }
    
    public static void actualizarRegistro(){
        
        System.out.println("Escriba el código del registro a actualizar:");
        int idRegistro = keyInput.nextInt();
      
        keyInput.nextLine();

        MinecraftEntry registroAActualizar = myConnection.obtenerUnRegistro(idRegistro);
        
        
        if (registroAActualizar.getID() > 0){
            System.out.println(LineSeperator);
            System.out.println(registroAActualizar.getFormattedText());
            System.out.println(LineSeperator);
           
            System.out.println("MINECRAFTBLOCKNAME (" + registroAActualizar.getMINECRAFTBLOCKNAME() + "):");
            String MINECRAFTBLOCKNAME = keyInput.nextLine();

            if (!MINECRAFTBLOCKNAME.isEmpty() && !MINECRAFTBLOCKNAME.equals(registroAActualizar.getMINECRAFTBLOCKNAME())){
                registroAActualizar.setMINECRAFTBLOCKNAME(MINECRAFTBLOCKNAME);
            }
            
            System.out.println("MINECRAFTCRAFTRECEIPT (" + registroAActualizar.getMINECRAFTCRAFTRECEIPT()+ "):");
            String MINECRAFTCRAFTRECEIPT = keyInput.nextLine();
            if (!MINECRAFTCRAFTRECEIPT.isEmpty() && !MINECRAFTCRAFTRECEIPT.equals(registroAActualizar.getMINECRAFTCRAFTRECEIPT())){
                registroAActualizar.setMINECRAFTCRAFTRECEIPT(MINECRAFTCRAFTRECEIPT);
            }
            
            
            System.out.println("MINECRAFTATTACK (" + registroAActualizar.getMINECRAFTATTACK() + "):");
            int MINECRAFTATTACK = keyInput.nextInt();
            if (MINECRAFTATTACK!=registroAActualizar.getMINECRAFTATTACK()){
                registroAActualizar.setMINECRAFTATTACK(MINECRAFTATTACK);
            }
            
            
            System.out.println("MINECRAFTDEFENCE (" + registroAActualizar.getMINECRAFTDEFENCE() + "):");
            int MINECRAFTDEFENCE = keyInput.nextInt();
            if (MINECRAFTDEFENCE!=registroAActualizar.getMINECRAFTDEFENCE()){
                registroAActualizar.setMINECRAFTDEFENCE(MINECRAFTDEFENCE);
            }
            
            System.out.println(registroAActualizar.getFormattedText());
            myConnection.actualizarRegistro(registroAActualizar);
            System.out.println("Registro Actualizado!!! Presione Enter para Continuar.");
        } else {
            System.out.println("No existe Registro !!! Presione Enter para Continuar.");
        }
        
        keyInput.nextLine();
    }
    
    public static void eliminarRegistro(){
        System.out.println("Escriba el código del registro a eliminar:");
        int idRegistro = keyInput.nextInt();

        keyInput.nextLine();

        MinecraftEntry registroAEliminar = myConnection.obtenerUnRegistro(idRegistro);
        if (registroAEliminar.getID() > 0) {
            System.out.println(LineSeperator);
            System.out.println(registroAEliminar.getFormattedText());
            System.out.println(LineSeperator);

            System.out.println("¿Desea Eliminar el registro? (S/N):");
            String opcion = keyInput.nextLine();
            if (opcion.toUpperCase().equals("S")){
                myConnection.eliminarRegistro(registroAEliminar);
                System.out.println("Registro Eliminado. Presione Enter para continuar.");
            } else {
                System.out.println("Operación cancelada. Presione Enter para continuar.");
            }
        } else {
            System.out.println("No existe Registro !!! Presione Enter para Continuar.");
        }
        
        keyInput.nextLine();
    }
}
