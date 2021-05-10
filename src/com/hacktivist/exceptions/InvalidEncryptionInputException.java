package com.hacktivist.exceptions;

import com.hacktivist.main.Main;

public class InvalidEncryptionInputException extends Exception{
    InvalidEncryptionInputException(char s){
        //popup message here
        System.out.println("Invalid Encryption Input Exception: '" + s +"' is not allowed");
    }

    public static void validate(String userInputMsg) throws InvalidEncryptionInputException {
        for(int i=0; i< userInputMsg.length(); i++){
            if(Main.encryptMessage.Encrypter(userInputMsg.charAt(i)) == 0){
                throw new InvalidEncryptionInputException(userInputMsg.charAt(i));
            }
        }

    }
}
