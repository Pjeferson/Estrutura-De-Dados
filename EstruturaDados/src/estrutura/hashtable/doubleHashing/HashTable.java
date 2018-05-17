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
        primo = getPrimo(capacity);
        //primo = 7;
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
        int i = h(key);
        int d = d(key);
        for (int j = 0; j < array.length; j++) {
            int probe = (i + j * d) % array.length;
            Celula celula = array[probe];
            if (celula != null) {
                if (!celula.isAvailable() && key == celula.getKey()) {
                    return celula.getElement();
                }
            } else {
                return null;
            }
        }
        return null;
        /*formula ( i + jd ( k )) mod N*/
    }

    @Override
    public void insertItem(int key, Object element) throws HashTableCheiaException {
        if (this.size >= array.length) {
            throw new HashTableCheiaException("A tabela está cheia");
        }
        Celula celula = new Celula();
        celula.setElement(element);
        celula.setKey(key);
        celula.setAvailable(false);
        int i = h(key);
        int d = d(key);
        for (int j = 0; j < array.length; j++) {
            int probe = (i + j * d) % array.length;
            if (array[probe] == null || array[probe].isAvailable()) {
                array[probe] = celula;
                this.size++;
                return;
            }
        }
        /*formula ( i + jd ( k )) mod N*/
    }

    @Override
    public Object removeElement(int key) {
        int i = h(key);
        int d = d(key);
        for (int j = 0; j < array.length; j++) {
            int probe = (i + j * d) % array.length;
            Celula celula = array[probe];
            if (celula != null) {
                if (!celula.isAvailable() && key == celula.getKey()) {
                    celula.setAvailable(true);
                    this.size--;
                    return celula.getElement();
                }
            } else {
                return null;
            }
        }
        return null;
        /*formula ( i + jd ( k )) mod N*/
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

    /*pega maior primo anterior a 'capacity'*/
    private int getPrimo(int capacity) {
        for (int i = capacity - 1; i > 1; i--) {
            boolean teste = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    teste = false;
                    break;
                }
            }
            if (teste) {
                return i;
            }
        }
        return 1;
    }

}
