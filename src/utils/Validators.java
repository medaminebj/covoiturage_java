/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Pattern;

/**
 *
 * @author Amine
 */
public class Validators {
    public static boolean adresseValidator(String adresse){
        String input = "[a-zA-Z_0-9]*|[a-zA-Z_0-9]+,[a-zA-Z_0-9]+";
        boolean res = Pattern.matches(adresse, input);
        return res;
    }
}
