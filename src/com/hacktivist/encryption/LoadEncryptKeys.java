package com.hacktivist.encryption;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class LoadEncryptKeys {
    public ArrayList<keys> keyList = new ArrayList<>();
    keys key_new;
    public String getResource(String rsc, String folderLocation) {
        String val = "";

        try {
            Class cls = Class.forName("com.hacktivist.encryption.LoadEncryptKeys");

            // returns the ClassLoader object associated with this Class
            ClassLoader cLoader = cls.getClassLoader();

            // input stream
            InputStream i = cLoader.getResourceAsStream(folderLocation + rsc);
            BufferedReader r = new BufferedReader(new InputStreamReader(i));

            // reads each line
            String l;
            while((l = r.readLine()) != null) {
                val = val + l;
            }
            i.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return val;
    }

    public void storeKeys() {
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
                    keyList.add((keys) fileInput.readObject());
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

    public void makeKeysArray(){
        key_new = new keys('A', 926);
        keyList.add(key_new);
        key_new = new keys('B', 947);
        keyList.add(key_new);
        key_new = new keys('C', 948);
        keyList.add(key_new);
        key_new = new keys('D', 916);
        keyList.add(key_new);
        key_new = new keys('E', 915);
        keyList.add(key_new);
        key_new = new keys('F', 923);
        keyList.add(key_new);
        key_new = new keys('G', 928);
        keyList.add(key_new);
        key_new = new keys('H', 931);
        keyList.add(key_new);
        key_new = new keys('I', 968);
        keyList.add(key_new);
        key_new = new keys('J', 937);
        keyList.add(key_new);
        key_new = new keys('K', 949);
        keyList.add(key_new);
        key_new = new keys('L', 962);
        keyList.add(key_new);
        key_new = new keys('M', 969);
        keyList.add(key_new);
        key_new = new keys('N', 952);
        keyList.add(key_new);
        key_new = new keys('O', 920);
        keyList.add(key_new);
        key_new = new keys('P', 951);
        keyList.add(key_new);
        key_new = new keys('Q', 963);
        keyList.add(key_new);
        key_new = new keys('R', 955);
        keyList.add(key_new);
        key_new = new keys('S', 950);
        keyList.add(key_new);
        key_new = new keys('T', 946);
        keyList.add(key_new);
        key_new = new keys('U', 945);
        keyList.add(key_new);
        key_new = new keys('V', 953);
        keyList.add(key_new);
        key_new = new keys('W', 47);
        keyList.add(key_new);
        key_new = new keys('X', 30340);
        keyList.add(key_new);
        key_new = new keys('Y', 19968);
        keyList.add(key_new);
        key_new = new keys('Z', 26159);
        keyList.add(key_new);

        key_new = new keys('a', 19981);
        keyList.add(key_new);
        key_new = new keys('b', 20102);
        keyList.add(key_new);
        key_new = new keys('c', 20154);
        keyList.add(key_new);
        key_new = new keys('d', 25105);
        keyList.add(key_new);
        key_new = new keys('e', 22312);
        keyList.add(key_new);
        key_new = new keys('f', 26377);
        keyList.add(key_new);
        key_new = new keys('g', 20182);
        keyList.add(key_new);
        key_new = new keys('h', 36825);
        keyList.add(key_new);
        key_new = new keys('i', 20043);
        keyList.add(key_new);
        key_new = new keys('j', 20010);
        keyList.add(key_new);
        key_new = new keys('k', 20013);
        keyList.add(key_new);
        key_new = new keys('l', 19978);
        keyList.add(key_new);
        key_new = new keys('m', 21516);
        keyList.add(key_new);
        key_new = new keys('n', 23567);
        keyList.add(key_new);
        key_new = new keys('o', 24403);
        keyList.add(key_new);
        key_new = new keys('p', 21487);
        keyList.add(key_new);
        key_new = new keys('q', 23398);
        keyList.add(key_new);
        key_new = new keys('r', 20998);
        keyList.add(key_new);
        key_new = new keys('s', 21448);
        keyList.add(key_new);
        key_new = new keys('t', 23450);
        keyList.add(key_new);
        key_new = new keys('u', 35265);
        keyList.add(key_new);
        key_new = new keys('v', 21482);
        keyList.add(key_new);
        key_new = new keys('w', 20027);
        keyList.add(key_new);
        key_new = new keys('x', 27809);
        keyList.add(key_new);
        key_new = new keys('y', 20844);
        keyList.add(key_new);
        key_new = new keys('z', 20174);
        keyList.add(key_new);

        key_new = new keys('1', 9777);
        keyList.add(key_new);
        key_new = new keys('2', 9778);
        keyList.add(key_new);
        key_new = new keys('3', 9779);
        keyList.add(key_new);
        key_new = new keys('4', 9780);
        keyList.add(key_new);
        key_new = new keys('5', 9781);
        keyList.add(key_new);
        key_new = new keys('6', 9783);
        keyList.add(key_new);
        key_new = new keys('7', 65078);
        keyList.add(key_new);
        key_new = new keys('8', 65077);
        keyList.add(key_new);
        key_new = new keys('9', 9553);
        keyList.add(key_new);
        key_new = new keys('0', 12292);
        keyList.add(key_new);
    }

    public void saveToFile(){
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
}
