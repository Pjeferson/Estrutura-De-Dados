/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.heap;

/**
 *
 * @author pjeferson
 */
public class Heap {

    private Celula[] array;
    int size;

    public Heap(int tam) {
        array = new Celula[tam + 1];
        size = 0;
    }

    /*Auxiliar para vizualiar array*/
    public void mostrar() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null) {
                System.out.print("X ");
            } else {
                System.out.print(array[i].getKey() + " ");
            }

        }
        System.out.print("\n");
    }

    private void upHeap(int index) {
        while (!(index == 1 || array[parentIndex(index)].getKey() <= array[index].getKey())) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public void insert(Celula celula) throws EHeapCheia {
        if (this.size == array.length - 1) {
            throw new EHeapCheia("A Heap está cheia");
        }
        size++;
        array[this.size] = celula;
        upHeap(size);
    }

    private void downHeap() {
        int index = 1;
        while (index <= size) {
            if (hasLeft(index) && hasRight(index)) {
                if (array[leftIndex(index)].getKey() < array[index].getKey() && array[rightIndex(index)].getKey() < array[index].getKey()) {
                    if (array[rightIndex(index)].getKey() < array[leftIndex(index)].getKey()) {
                        swap(index, rightIndex(index));
                        index = rightIndex(index);
                    } else {
                        swap(index, leftIndex(index));
                        index = leftIndex(index);
                    }
                    continue;
                } else if (array[leftIndex(index)].getKey() < array[index].getKey()) {
                    swap(index, leftIndex(index));
                    index = leftIndex(index);
                    continue;
                } else if (array[rightIndex(index)].getKey() < array[index].getKey()) {
                    swap(index, rightIndex(index));
                    index = rightIndex(index);
                    continue;
                }
            } else if (hasLeft(index) && array[leftIndex(index)].getKey() < array[index].getKey()) {
                swap(index, leftIndex(index));
                index = leftIndex(index);
                continue;
            } else if (hasRight(index) && array[rightIndex(index)].getKey() < array[index].getKey()) {
                swap(index, rightIndex(index));
                index = rightIndex(index);
                continue;
            }
            break;
        }
    }

    public Celula removeMin() throws EHeapVazia {
        if (this.size == 0) {
            throw new EHeapVazia("A Heap está vazia");
        }
        swap(1, size);
        Celula celulaAux = array[size];
        array[size] = null;
        this.size--;
        downHeap();
        return celulaAux;
    }

    public Celula min() throws EHeapVazia {
        if (this.size == 0) {
            throw new EHeapVazia("A Heap está vazia");
        }
        return array[1];
    }

    private void swap(int index1, int index2) {
        Celula cel = array[index1];
        array[index1] = array[index2];
        array[index2] = cel;
    }

    private boolean hasLeft(int index) {
        return !(leftIndex(index) > size || array[leftIndex(index)] == null);
    }

    private boolean hasRight(int index) {
        return !(rightIndex(index) > size || array[rightIndex(index)] == null);
    }

    private boolean hasParent(int index) {
        return array[parentIndex(index)] != null;
    }

    private int leftIndex(int index) {
        return index * 2;
    }

    private int rightIndex(int index) {
        return index * 2 + 1;
    }

    private int parentIndex(int index) {
        return index / 2;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }
}
