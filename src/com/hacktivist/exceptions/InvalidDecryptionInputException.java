package com.hacktivist.exceptions;

import com.hacktivist.main.Main;

public class InvalidDecryptionInputException extends Exception{
    InvalidDecryptionInputException(){
        //popup message here
        System.out.println("Invalid Decryption Input Exception");
    }

    public static void validate(String userMsgInput) throws InvalidDecryptionInputException {
        for(int i=0;i<userMsgInput.length(); i++){
            if(Main.encryptMessage.Decrypter(userMsgInput.charAt(i)) == 0){
                throw new InvalidDecryptionInputException();
            }
        }
    }
}
