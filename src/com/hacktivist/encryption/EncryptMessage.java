package com.hacktivist.encryption;

public class EncryptMessage extends LoadEncryptKeys{
    public String getEncryptMsg(String userMsg){
        String encryptMsg = "";
        int [] dec_values = new int[userMsg.length()];
        for(int j=0; j<userMsg.length(); j++){
            dec_values[j] = Encrypter(userMsg.charAt(j));
            System.out.println(dec_values[j]);
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

    private int Encrypter(char ch){
        System.out.println("-->" + keyList.size());
        for(int i=0; i<keyList.size(); i++){
            if(ch == keyList.get(i).getUser_key()){
                return keyList.get(i).getDec_value();
            }
        }
        return 0;
    }

    private char Decrypter(int dec){

        for(int i=0; i<keyList.size(); i++){
            if(dec == keyList.get(i).getDec_value()){
                return keyList.get(i).getUser_key();
            }
        }
        return 0;
    }

}
