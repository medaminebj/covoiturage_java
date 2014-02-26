/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amine
 */
public class Validators {
  // vérifier si le numéro de telephone contient que des chiffre

       public static boolean NumeroTelValidator(String NumTel){
        String input = "((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+";
        boolean res = NumTel.matches(input);
        return res;
    }
       //vérifier si le nom ou le prenom ne contient pas des chiffre
     public static boolean NomPrenomValidator(String ch){
        String input = "[a-zA-Z]*";
        boolean res = ch.matches(input);
        return res;
    }
     // Vérifier Si lemail est valide
     public static boolean EmailValidator(String ch)
     {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(ch.toUpperCase());
        return m.matches();
     }
       // Vérifier la taille du numéro de téléphone
      public static boolean TailleNumTelValidator(String ch)
     {
        if (ch.length()>8)
            return false;
        else return true ; 
     } 
      //Vérifier le format de la date 
      public static boolean DateValidator(String ch)
     {
       Pattern p = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");
        Matcher m = p.matcher(ch.toUpperCase());
        return m.matches();
     } 
      //Verfier la confirmation de la mot de passe 
      public static boolean ConfirmerMotDePasseValidator(String ch , String ch2)
     {
       return (ch.equals(ch2));
     } 
}
