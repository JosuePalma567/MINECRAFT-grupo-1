/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programulti.minecraft;

/**
 *
 * @author DELL
 */
public class MinecraftEntry {

    /**
     * @return the id
     */
    public int getID() {
        return ID;
    }

    /**
     * @param id the id to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the MINECRAFTBLOCKNAME
     */
    public String getMINECRAFTBLOCKNAME() {
        return MINECRAFTBLOCKNAME;
    }

    /**
     * @param MINECRAFTBLOCKNAME the MINECRAFTBLOCKNAME to set
     */
    public void setMINECRAFTBLOCKNAME(String MINECRAFTBLOCKNAME) {
        this.MINECRAFTBLOCKNAME = MINECRAFTBLOCKNAME;
    }

    /**
     * @return the MINECRAFTCRAFTRECEIPT
     */
    public String getMINECRAFTCRAFTRECEIPT() {
        return MINECRAFTCRAFTRECEIPT;
    }

    /**
     * @param MINECRAFTCRAFTRECEIPT the MINECRAFTCRAFTRECEIPT to set
     */
    public void setMINECRAFTCRAFTRECEIPT(String MINECRAFTCRAFTRECEIPT) {
        this.MINECRAFTCRAFTRECEIPT = MINECRAFTCRAFTRECEIPT;
    }

    /**
     * @return the MINECRAFTATTACK
     */
    public int getMINECRAFTATTACK() {
        return MINECRAFTATTACK;
    }

    /**
     * @param MINECRAFTATTACK the MINECRAFTATTACK to set
     */
    public void setMINECRAFTATTACK(int MINECRAFTATTACK) {
        this.MINECRAFTATTACK = MINECRAFTATTACK;
    }

    /**
     * @return the MINECRAFTDEFENCE
     */
    public int getMINECRAFTDEFENCE() {
        return MINECRAFTDEFENCE;
    }

    /**
     * @param MINECRAFTDEFENCE the MINECRAFTDEFENCE to set
     */
    public void setMINECRAFTDEFENCE(int MINECRAFTDEFENCE) {
        this.MINECRAFTDEFENCE = MINECRAFTDEFENCE;
    }
    
    private int ID;
    private String MINECRAFTBLOCKNAME;
    private String MINECRAFTCRAFTRECEIPT;
    private int MINECRAFTATTACK;
    private int MINECRAFTDEFENCE;
    
    
    public String getFormattedText(){
        return String.format(
                "%d\t%-20s\t%-40s\t%-10d\t%-40d",
                ID,
                MINECRAFTBLOCKNAME,
                MINECRAFTCRAFTRECEIPT,
                MINECRAFTATTACK,
                MINECRAFTDEFENCE);                
                }
    
}
