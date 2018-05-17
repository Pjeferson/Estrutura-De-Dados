/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.hashTable;

import estrutura.hashtable.linearProbing.HashTable;
import java.util.Iterator;

/**
 *
 * @author 20171014040010
 */
public class TesteHashTableLinearProbing {

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        System.out.println(table.size());
        
        table.insertItem(5, "5");
        table.insertItem(15, "15");
        table.insertItem(14, "14");
        
        System.out.println(table.size());
        table.mostrar();
        
        table.removeElement(5);
        System.out.println(table.size());
        table.mostrar();
        Iterator<Integer> listaKeys = table.keys();
        while (listaKeys.hasNext()) {            
            System.out.println(listaKeys.next());
        }
    }
}
