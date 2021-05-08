package com.hacktivist.encryption;

import java.io.Serializable;

public class Keys implements Serializable{
    private char user_key;
    private int dec_value;

    public Keys(char user_key, int dec_value) {
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
