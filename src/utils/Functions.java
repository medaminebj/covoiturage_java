/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
}
