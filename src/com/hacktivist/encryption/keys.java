package com.hacktivist.encryption;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author saimh
 */
public class keys implements Serializable{
    private char user_key;
    private int dec_value;

    public keys(char user_key, int dec_value) {
        this.user_key = user_key;
        this.dec_value = dec_value;
    }

    public char getUser_key() {
        return user_key;
    }

    public void setUser_key(char user_key) {
        this.user_key = user_key;
    }

    public int getDec_value() {
        return dec_value;
    }

    public void setDec_value(int dec_value) {
        this.dec_value = dec_value;
    }

    
}
