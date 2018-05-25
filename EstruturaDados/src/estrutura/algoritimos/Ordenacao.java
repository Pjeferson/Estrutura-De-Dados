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

    public static Celula[] heapSort(Celula[] array) {
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
}
