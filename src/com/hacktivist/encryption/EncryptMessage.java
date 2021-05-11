package com.hacktivist.encryption;

import com.hacktivist.main.Main;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EncryptMessage extends LoadEncryptKeys{

    public String getEncryptedMsgModified(String userMsg){
        String H0 = userMsg.substring(0, userMsg.length() - Main.PASSWORD_SIZE);
        String H1 = userMsg.substring(userMsg.length() - Main.PASSWORD_SIZE);
        String H2 = "";
        ArrayList<Integer> digitList = new ArrayList<>();
        do{
            int random = SimpleOperations.generateRandomNumber(9);
            if(!digitList.contains(random)){
                digitList.add(random);
            }
        }while (digitList.size() != Main.PASSWORD_SIZE);
        System.out.println(digitList);
        for(int i=0; i<Main.PASSWORD_SIZE; i++){
            H2 = H2.concat(String.valueOf(digitList.get(i)));
        }
        System.out.println("H0: " + H0);
        System.out.println("H1: " + H1);
        System.out.println("H2: " + H2);
        String H2_sorted = SimpleOperations.getSortedString(H2, 1);
        System.out.println("H2_sorted: " + H2_sorted);
        StringBuilder stringBuilder = new StringBuilder(H0);
        String addCharacter = "";
        for(int i=0; i<H2.length(); i++){
            int index = Integer.parseInt(String.valueOf(H2_sorted.charAt(i)));
            for(int j=0; j<H2.length(); j++){
                if(Integer.parseInt(String.valueOf(H2.charAt(j))) == index){
                    addCharacter = String.valueOf(H1.charAt(j));
                    break;
                }
            }
            stringBuilder.insert(index,addCharacter);
        }
        String finalMsg = stringBuilder.toString() + H2;
        System.out.println(finalMsg);
        return getEncryptMsg(finalMsg);
    }

    public String getEncryptMsg(String userMsg){
        String encryptMsg = "";
        int [] dec_values = new int[userMsg.length()];
        for(int j=0; j<userMsg.length(); j++){
            dec_values[j] = Encrypter(userMsg.charAt(j));
        }
        for(int i=0; i<userMsg.length(); i++){
            if(dec_values[i] == 0){
                encryptMsg = encryptMsg.concat(String.valueOf(userMsg.charAt(i)));
            }else{
                encryptMsg = encryptMsg.concat(Character.toString(dec_values[i]));
            }
        }
        return encryptMsg;
    }

    public String getDecryptedMessageModified(String userMsg){
        String userMsgDec = getDecryptedMessage(userMsg);
        String passReference = userMsgDec.substring(userMsgDec.length() - Main.PASSWORD_SIZE);
        //System.out.println("reference: " + passReference);
        String passReference_modified = SimpleOperations.getSortedString(passReference, 2);
        //System.out.println(passReference_modified);
        String password = "";
        String message = userMsgDec.substring(0, userMsgDec.length() - Main.PASSWORD_SIZE);
        StringBuilder stringBuilder = new StringBuilder(message);
        for(int i=0; i<Main.PASSWORD_SIZE; i++){
            //popup exception here
            int index_mod = Integer.parseInt(String.valueOf(passReference_modified.charAt(i)));
            int index = Integer.parseInt(String.valueOf(passReference.charAt(i)));
            password = password.concat(String.valueOf(userMsgDec.charAt(index)));
            stringBuilder = stringBuilder.deleteCharAt(index_mod);
        }
        //System.out.println(stringBuilder);
        //System.out.println(password);
        return stringBuilder + password;
    }

    public String getDecryptedMessage(String userMsg){
        String decryptMsg = "";
        int [] dec_values = new int[userMsg.length()];

        for(int j=0; j<userMsg.length(); j++){
            dec_values[j] = userMsg.charAt(j);
        }

        for(int i=0; i<userMsg.length(); i++){
            if(Decrypter(userMsg.charAt(i)) == 0){
                decryptMsg = decryptMsg.concat(String.valueOf(userMsg.charAt(i)));
            }else{
                decryptMsg = decryptMsg.concat(String.valueOf(Decrypter(dec_values[i])));
            }
        }
        return decryptMsg;
    }

    public int Encrypter(char ch){
        for(int i=0; i<keyList.size(); i++){
            if(ch == keyList.get(i).getUser_key()){
                return keyList.get(i).getDec_value();
            }
        }
        return 0;
    }

    public char Decrypter(int dec){

        for(int i=0; i<keyList.size(); i++){
            if(dec == keyList.get(i).getDec_value()){
                return keyList.get(i).getUser_key();
            }
        }
        return 0;
    }

}
