/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.hashtable.linearProbing;

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
    private int size;

    public HashTable(int capacity) {
        array = new Celula[capacity];
        size = 0;
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

    @Override
    public Object findElement(int key) {
        int i = h(key);
        for (int p = 0; p < array.length; p++) {
            Celula celula = array[i];
            if (celula != null) {
                if (!celula.isAvailable() && key == array[i].getKey()) {
                    return array[i].getElement();
                } else {
                    i = (i + 1) % array.length;
                }
            } else {
                return null;
            }
        }
        return null;
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
        for (int p = 0; p < array.length; p++) {
            if (array[i] == null || array[i].isAvailable()) {
                array[i] = celula;
                this.size++;
                return;
            }
            i = (i + 1) % array.length;
        }
    }

    @Override
    public Object removeElement(int key) {
        int i = h(key);
        for (int p = 0; p < array.length; p++) {
            Celula celula = array[i];
            if (celula != null) {
                if (!celula.isAvailable() && key == array[i].getKey()) {
                    array[i].setAvailable(true);
                    this.size--;
                    return array[i].getElement();
                } else {
                    i = (i + 1) % array.length;
                }
            } else {
                return null;
            }
        }
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

}
