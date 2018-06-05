/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.algoritimos;

import estrutura.heap.Celula;
import estrutura.heap.Heap;

/**
 *
 * @author pjeferson
 */
public class Ordenacao {

    public Celula[] heapSort(Celula[] array) {
        Celula[] arraytmp = new Celula[array.length];
        Heap heap = new Heap(array.length);
        for (Celula celula : array) {
            heap.insert(celula);
        }
        int heapSize = heap.size();
        for (int i = 0; i < heapSize; i++) {
            arraytmp[i] = heap.removeMin();
        }
        return arraytmp;
    }

    public Celula[] mergeSort(Celula[] array) {
        if (array.length > 1) {
            int meio = array.length / 2;
            Celula[] auxA = partition(array, 0, meio);
            Celula[] auxB = partition(array, meio, array.length);
            auxA = mergeSort(auxA);
            auxB = mergeSort(auxB);
            array = merge(auxA, auxB);
        }
        return array;
    }

    private Celula[] merge(Celula[] auxA, Celula[] auxB) {
        Celula[] auxC = new Celula[auxA.length + auxB.length];
        int a = 0;
        int b = 0;
        int c = 0;
        while (a < auxA.length && b < auxB.length) {
            if (auxA[a].compareTo(auxB[b]) < 0) {
                auxC[c++] = auxA[a++];

            } else {
                auxC[c++] = auxB[b++];
            }
        }
        while (a < auxA.length) {
            auxC[c++] = auxA[a++];
        }
        while (b < auxB.length) {
            auxC[c++] = auxB[b++];
        }
        return auxC;
    }

    private Celula[] partition(Celula[] array, int inicio, int fim) {
        Celula[] aux = new Celula[fim - inicio];

        for (int i = inicio, j = 0; i < fim; i++, j++) {
            aux[j] = array[i];
        }
        return aux;
    }

}
