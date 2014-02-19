/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.Exceptions;

/**
 *
 * @author Amine
 */
public class ProblemeTechniqueException extends Exception{
    public ProblemeTechniqueException(){
        super("Le système a rencontré un problème veuillez réessayer ultérieurement.");
    }
}
