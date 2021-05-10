package com.hacktivist.encryption;

public abstract class SimpleOperations {

    public static boolean ifPasswordRequired(String password){
        if(password.equals("00000000") ||
                password.equals("11111111") ||
                password.equals("22222222") ||
                password.equals("33333333") ||
                password.equals("44444444") ||
                password.equals("55555555") ||
                password.equals("66666666") ||
                password.equals("77777777") ||
                password.equals("88888888") ||
                password.equals("99999999")){
            return false;
        }else{
            return true;
        }
    }
}
