/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.hashtable.doubleHashing;

import estrutura.hashtable.Celula;
import estrutura.hashtable.HashTableInterface;
import estrutura.hashtable.HashTableCheiaException;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author pjeferson
 */
public class HashTable implements HashTableInterface {

    private Celula[] array;
    private int primo;
    private int size;

    public HashTable(int capacity) {
        array = new Celula[capacity];
        size = 0;
        primo = getPrimario(capacity);
    }

    public void mostrar() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.print("[x] ");
            } else if (array[i].isAvailable()) {
                System.out.print("[a] ");
            } else {
                System.out.print("[" + array[i].getElement() + "] ");
            }
        }
        System.out.print("\n");
    }

    private int h(int key) {
        return key % this.array.length;
    }
    
    private int d(int key) {
        return primo - (key % primo);
    }

    @Override
    public Object findElement(int key) {
        /*TODO aplicar formula ( i + jd ( k )) mod N*/
        return null;
    }

    @Override
    public void insertItem(int key, Object element) throws HashTableCheiaException {
        /*TODO aplicar formula ( i + jd ( k )) mod N*/
    }

    @Override
    public Object removeElement(int key) {
       /*TODO aplicar formula ( i + jd ( k )) mod N*/
       return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<Integer> keys() {
        Vector<Integer> lista = new Vector();
        for (int i = 0; i < array.length; i++) {
            Celula celula = array[i];
            if (celula != null && !celula.isAvailable()) {
                lista.add(celula.getKey());
            }
        }
        return lista.iterator();
    }

    @Override
    public Iterator<Object> elements() {
        Vector<Object> lista = new Vector();
        for (int i = 0; i < array.length; i++) {
            Celula celula = array[i];
            if (celula != null && !celula.isAvailable()) {
                lista.add(celula.getElement());
            }
        }
        return lista.iterator();
    }

    private int getPrimario(int capacity) {
        /*TODO pegar maior primário anterior a 'capacity'*/
        return 0;
    }

}
