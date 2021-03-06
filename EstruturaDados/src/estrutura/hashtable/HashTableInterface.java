/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.hashtable;

import java.util.Iterator;

/**
 *
 * @author pjeferson
 */
public interface HashTableInterface {
    public Object findElement(int key);
    public void insertItem(int key, Object element) throws HashTableCheiaException;
    public Object removeElement(int key);
    public int size();
    public boolean isEmpty();
    public Iterator<Integer> keys();
    public Iterator<Object> elements();
}
