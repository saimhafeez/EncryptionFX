package com.hacktivist.encryption;

import java.util.ArrayList;
import java.util.Random;

public abstract class SimpleOperations {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
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

    public static int generateRandomNumber(int maxValue){
        int min = 0;
        return  (int) Math.floor(Math.random()*(maxValue-min+1)+min);
    }

    public static String getSortedString(String H2){
        int temp;
        String H2_sorted = "";
        int[] H2_array = new int[H2.length()];
        for(int i=0;i<H2.length();i++){
            H2_array[i] = Integer.parseInt(String.valueOf(H2.charAt(i)));
        }
        for(int m=0;m<H2_array.length;m++){
            for(int n=m+1;n<H2_array.length;n++){
                if(H2_array[m]>H2_array[n]){
                    temp = H2_array[m];
                    H2_array[m]=H2_array[n];
                    H2_array[n]=temp;
                }
            }
        }
        for(int i=0;i<H2.length();i++){
            H2_sorted = H2_sorted.concat(String.valueOf(H2_array[i]));
        }
        return H2_sorted;
    }
}
