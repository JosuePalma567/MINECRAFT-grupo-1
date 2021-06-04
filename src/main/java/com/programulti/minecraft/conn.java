/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programulti.minecraft;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class conn {
    
    Connection c = null;
    public void getConnection(){
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MINECRAFT.db");
            String SQLVerifyTable = "CREATE TABLE IF NOT EXISTS MINECRAFT"
                    + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " MINECRAFTBLOCKNAME TEXT NOT NULL,"
                    + " MINECRAFTCRAFTRECEIPT TEXT NOT NULL,"
                    + " MINECRAFTATTACK INTEGER NOT NULL,"
                    + " MINECRAFTDEFENCE INTEGER NOT NULL"
                    + ")";
            Statement stmt = c.createStatement();
            stmt.executeUpdate(SQLVerifyTable);
            stmt.close();
            
        } catch ( Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
        }
    }
    
    
    
     public ArrayList<MinecraftEntry> getAllMinecraftEntry(){
        try{
            if (c == null) {
                getConnection();
            }
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MINECRAFT;");
            ArrayList<MinecraftEntry> allMyEntries = new ArrayList<MinecraftEntry>();
            while(rs.next()){
                MinecraftEntry currentEntry = new MinecraftEntry();
                currentEntry.setID(rs.getInt("ID"));
                currentEntry.setMINECRAFTBLOCKNAME(rs.getString("MINECRAFTBLOCKNAME"));
                currentEntry.setMINECRAFTCRAFTRECEIPT(rs.getString("MINECRAFTCRAFTRECEIPT"));
                currentEntry.setMINECRAFTATTACK(rs.getInt("MINECRAFTATTACK"));
                currentEntry.setMINECRAFTDEFENCE(rs.getInt("MINECRAFTDEFENCE"));
                
                allMyEntries.add(currentEntry);
                
            }
            stmt.close();
            return allMyEntries;
        } catch( Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    
}

