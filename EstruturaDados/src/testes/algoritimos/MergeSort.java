/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.algoritimos;

import estrutura.algoritimos.Ordenacao;
import estrutura.heap.Celula;

/**
 *
 * @author pjeferson
 */
public class MergeSort {

    public static void main(String[] args) {
        Celula[] array = new Celula[20];
        
        for (int i = 0; i < array.length; i++) {
            int val = (int) Math.floor((Math.random() * 10) + 1);
            //int val = i+1;
            Celula celula = new Celula();
            celula.setKey(val);
            celula.setElement(Integer.toString(val));
            array[i] = celula;
            System.out.print(val + " ");
        }
        System.out.print("\n");
        
        System.out.println(5/2);
        
        Ordenacao sort = new Ordenacao();
        Celula[] arrayOrdenada = sort.mergeSort(array);
        
        for (int i = 0; i < arrayOrdenada.length; i++) {
            System.out.print(arrayOrdenada[i].getElement() + " ");
        }
        System.out.print("\n");
    }
}
