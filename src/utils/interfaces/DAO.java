/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.interfaces;

import java.util.List;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Amine
 */
public interface DAO<T> {
    
    public boolean create(T obj) throws ProblemeTechniqueException;
    
    public boolean update(T obj) throws ProblemeTechniqueException;
    
    public boolean delete(T obj) throws ProblemeTechniqueException;
    
    public List<T> getAll() throws ProblemeTechniqueException;
    
    public T findById(int id) throws ProblemeTechniqueException;
}
