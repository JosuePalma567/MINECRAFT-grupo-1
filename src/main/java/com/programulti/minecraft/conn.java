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
     
     public void eliminarRegistro(MinecraftEntry registroAEliminar){
        try {
            String sentenciaSQL = "DELETE from MINECRAFT where ID=%d;";
            Statement comandoSQL = c.createStatement();
            comandoSQL.executeUpdate(
                    String.format(
                            sentenciaSQL,
                            registroAEliminar.getID()
                    )
            );
            comandoSQL.close();
        } catch(Exception ex){
            System.err.println(" Error " + ex.getMessage());
            System.exit(0);
        }
    }
     
     public void actualizarRegistro(MinecraftEntry registroAActualizar){
        try {
            String sentencialSQL = "UPDATE MINECRAFT set MINECRAFTBLOCKNAME='%s', "
                    + "MINECRAFTCRAFTRECEIPT='%s', MINECRAFTATTACK='%d', MINECRAFTDEFENCE='%d' "
                    + "where ID=%d;";
            Statement comandoSQL = c.createStatement();
            comandoSQL.executeUpdate(
                    String.format( 
                            sentencialSQL,
                            registroAActualizar.getMINECRAFTBLOCKNAME(),
                            registroAActualizar.getMINECRAFTCRAFTRECEIPT(),
                            registroAActualizar.getMINECRAFTATTACK(),
                            registroAActualizar.getMINECRAFTDEFENCE(),
                            registroAActualizar.getID()
                    )
            );
            comandoSQL.close();
        } catch (Exception ex){
            System.err.println(" Error " + ex.getMessage());
            System.exit(0);
        }
    }
     
     
     public void addNewMinecraftEntry(MinecraftEntry newEntry){
        try {
        String sentenciaSql = "INSERT INTO MINECRAFT (MINECRAFTBLOCKNAME,MINECRAFTCRAFTRECEIPT,"
                + "MINECRAFTATTACK,MINECRAFTDEFENCE) valueS ('%s','%s','%d','%d');";
        Statement comandoSql = c.createStatement();
        comandoSql.executeUpdate(String.format(sentenciaSql,
                newEntry.getMINECRAFTBLOCKNAME(),
                newEntry.getMINECRAFTCRAFTRECEIPT(),
                newEntry.getMINECRAFTATTACK(),
                newEntry.getMINECRAFTDEFENCE()
            )
        );
        comandoSql.close();
        } catch (Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
        }
    }
     
     public MinecraftEntry obtenerUnRegistro( int idRegistro) {
        try{
            String setenciaSql = "SELECT * from MINECRAFT where ID=%d;";
            Statement comandoSql = c.createStatement();
            ResultSet cursorDeRegistro = comandoSql.executeQuery(
                String.format(setenciaSql, idRegistro)
            );
            MinecraftEntry miRegistro = new MinecraftEntry();
            while ( cursorDeRegistro.next()){
                miRegistro.setID(cursorDeRegistro.getInt("ID"));
                miRegistro.setMINECRAFTBLOCKNAME(cursorDeRegistro.getString("MINECRAFTBLOCKNAME"));
                miRegistro.setMINECRAFTCRAFTRECEIPT(cursorDeRegistro.getString("MINECRAFTCRAFTRECEIPT"));
                miRegistro.setMINECRAFTATTACK(cursorDeRegistro.getInt("MINECRAFTATTACK"));
                miRegistro.setMINECRAFTDEFENCE(cursorDeRegistro.getInt("MINECRAFTDEFENCE"));
            }
            comandoSql.close();
            return miRegistro;
        } catch (Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    
}

