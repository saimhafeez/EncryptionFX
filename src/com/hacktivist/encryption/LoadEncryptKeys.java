package com.hacktivist.encryption;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public abstract class LoadEncryptKeys {
    public static ArrayList<Keys> keyList = new ArrayList<>();
    private Keys key_new;

    public void performAutomatedRequiredEvents(){
        File requiredKeysFile = new File("src/com/hacktivist/encryption/keys.txt");
        if(requiredKeysFile.exists()){
            storeKeys();
        }else {
            makeKeysArray();
            saveToFile();
        }
    }

    private void storeKeys() {
        try{
            //Class cls = Class.forName("com.hacktivist.encryption.LoadEncryptKeys");
            //ClassLoader cLoader = cls.getClassLoader();
            //InputStream keysFile = cLoader.getResourceAsStream("com/hacktivist/encryption/keys.txt");
            FileInputStream keysFile = new FileInputStream("src/com/hacktivist/encryption/keys.txt");
            ObjectInputStream fileInput = new ObjectInputStream(keysFile);
            System.out.println("StoreKeys runned");
            boolean endOfFile = false;
            while(!endOfFile){
                try{
                    keyList.add((Keys) fileInput.readObject());
                }catch(EOFException e){
                    endOfFile = true;
                }catch(Exception j){
                    System.out.println(j.getMessage());
                }
            }
            fileInput.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(keyList.size());
    }

    private void saveToFile(){
        try{
            FileOutputStream file = new FileOutputStream("src/com/hacktivist/encryption/keys.txt");
            ObjectOutputStream fileOutput = new ObjectOutputStream(file);

            for(int i=0; i<keyList.size(); i++){
                fileOutput.writeObject(keyList.get(i));
            }
            fileOutput.close();
            //JOptionPane.showMessageDialog(null, "Successfully Saved!");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void makeKeysArray(){
        key_new = new Keys('A', 926);
        keyList.add(key_new);
        key_new = new Keys('B', 947);
        keyList.add(key_new);
        key_new = new Keys('C', 948);
        keyList.add(key_new);
        key_new = new Keys('D', 916);
        keyList.add(key_new);
        key_new = new Keys('E', 915);
        keyList.add(key_new);
        key_new = new Keys('F', 923);
        keyList.add(key_new);
        key_new = new Keys('G', 928);
        keyList.add(key_new);
        key_new = new Keys('H', 931);
        keyList.add(key_new);
        key_new = new Keys('I', 968);
        keyList.add(key_new);
        key_new = new Keys('J', 937);
        keyList.add(key_new);
        key_new = new Keys('K', 949);
        keyList.add(key_new);
        key_new = new Keys('L', 962);
        keyList.add(key_new);
        key_new = new Keys('M', 969);
        keyList.add(key_new);
        key_new = new Keys('N', 952);
        keyList.add(key_new);
        key_new = new Keys('O', 920);
        keyList.add(key_new);
        key_new = new Keys('P', 951);
        keyList.add(key_new);
        key_new = new Keys('Q', 963);
        keyList.add(key_new);
        key_new = new Keys('R', 955);
        keyList.add(key_new);
        key_new = new Keys('S', 950);
        keyList.add(key_new);
        key_new = new Keys('T', 946);
        keyList.add(key_new);
        key_new = new Keys('U', 945);
        keyList.add(key_new);
        key_new = new Keys('V', 953);
        keyList.add(key_new);
        key_new = new Keys('W', 47);
        keyList.add(key_new);
        key_new = new Keys('X', 30340);
        keyList.add(key_new);
        key_new = new Keys('Y', 19968);
        keyList.add(key_new);
        key_new = new Keys('Z', 26159);
        keyList.add(key_new);

        key_new = new Keys('a', 19981);
        keyList.add(key_new);
        key_new = new Keys('b', 20102);
        keyList.add(key_new);
        key_new = new Keys('c', 20154);
        keyList.add(key_new);
        key_new = new Keys('d', 25105);
        keyList.add(key_new);
        key_new = new Keys('e', 22312);
        keyList.add(key_new);
        key_new = new Keys('f', 26377);
        keyList.add(key_new);
        key_new = new Keys('g', 20182);
        keyList.add(key_new);
        key_new = new Keys('h', 36825);
        keyList.add(key_new);
        key_new = new Keys('i', 20043);
        keyList.add(key_new);
        key_new = new Keys('j', 20010);
        keyList.add(key_new);
        key_new = new Keys('k', 20013);
        keyList.add(key_new);
        key_new = new Keys('l', 19978);
        keyList.add(key_new);
        key_new = new Keys('m', 21516);
        keyList.add(key_new);
        key_new = new Keys('n', 23567);
        keyList.add(key_new);
        key_new = new Keys('o', 24403);
        keyList.add(key_new);
        key_new = new Keys('p', 21487);
        keyList.add(key_new);
        key_new = new Keys('q', 23398);
        keyList.add(key_new);
        key_new = new Keys('r', 20998);
        keyList.add(key_new);
        key_new = new Keys('s', 21448);
        keyList.add(key_new);
        key_new = new Keys('t', 23450);
        keyList.add(key_new);
        key_new = new Keys('u', 35265);
        keyList.add(key_new);
        key_new = new Keys('v', 21482);
        keyList.add(key_new);
        key_new = new Keys('w', 20027);
        keyList.add(key_new);
        key_new = new Keys('x', 27809);
        keyList.add(key_new);
        key_new = new Keys('y', 20844);
        keyList.add(key_new);
        key_new = new Keys('z', 20174);
        keyList.add(key_new);
        key_new = new Keys('1', 9777);
        keyList.add(key_new);
        key_new = new Keys('2', 9778);
        keyList.add(key_new);
        key_new = new Keys('3', 9779);
        keyList.add(key_new);
        key_new = new Keys('4', 9780);
        keyList.add(key_new);
        key_new = new Keys('5', 9781);
        keyList.add(key_new);
        key_new = new Keys('6', 9783);
        keyList.add(key_new);
        key_new = new Keys('7', 9650);
        keyList.add(key_new);
        key_new = new Keys('8', 9660);
        keyList.add(key_new);
        key_new = new Keys('9', 9553);
        keyList.add(key_new);
        key_new = new Keys('0', 12292);
        keyList.add(key_new);
        key_new = new Keys('\n', 5827);
        keyList.add(key_new);
        key_new = new Keys('-', 43856);
        keyList.add(key_new);
        key_new = new Keys(' ', 43857);
        keyList.add(key_new);
    }
}
