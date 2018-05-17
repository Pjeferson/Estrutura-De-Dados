/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.hashTable;

import estrutura.hashtable.doubleHashing.HashTable;

/**
 *
 * @author pjeferson
 */
public class TesteHashTableDoubleHashing {

    public static void main(String[] args) {
        HashTable table = new HashTable(13);
        /*--Inser��o e teste--*/
        table.insertItem(18, "18");
        table.insertItem(41, "41");
        table.insertItem(22, "22");
        table.insertItem(44, "44");
        table.insertItem(59, "59");
        table.insertItem(32, "32");
        table.insertItem(31, "31");
        table.insertItem(73, "73");
        System.out.println(table.size());
        table.mostrar();
        /*----*/
        /*--Remo��o, reinser��o e teste de tamanho--*/
        table.removeElement(18);
        table.removeElement(44);
        table.removeElement(31);
        table.insertItem(18, "18");
        table.insertItem(44, "44");
        table.insertItem(31, "31");
        System.out.println(table.size());
        table.mostrar();
        /*----*/
        /*--Verificando o m�todo findElement--*/
        System.out.println(table.findElement(31));
        System.out.println(table.findElement(66));
        /*----*/
    }
}
