/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author Amine
 */
public class Functions {
    public static String ConvertToMd5(String ch){
        String result = null;
        try {
                    MessageDigest m;
                    m = MessageDigest.getInstance("MD5");
                    m.update(ch.getBytes(),0,ch.length());
                    
                    result = new BigInteger(1,m.digest()).toString(16);
                    //fix bug 0 au debut
                    if (result.length() < 32)
                        result = "0" + result;
                    
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("probleme avec la méthode de hachage");
        }
        
        return result;
    }
    
    @SuppressWarnings("empty-statement")
    public static  String RandomPassword()
    {
        String Password ="";
        String[] Caractere = {"0","1", "2", "3", "4", "5", "6", "7","8", "9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int RandCaractere ; 
        int min = 0;
        int max = Caractere.length;
        Random rand = new Random();
 
        for (int i = 0; i < 8; i++) {
          RandCaractere = rand.nextInt(max);
          Password=Password+Caractere[RandCaractere];
        }
        return Password ; 
    }
}
