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
    private int insertCelula;

    public Heap(int tam) {
        array = new Celula[tam + 1];
        size = 0;
        insertCelula = 1;
    }

    private void upHeap(int posi) {
        /*TODO */
    }

    private void downHeap() {
        /*TODO */
    }

    public void insert(int key, Object element) {
        /*TODO */
    }

    public Object removeMin() {
        /*TODO */
        return null;
    }

    public Object min() {
        return array[1].getElement();
    }
    
    private boolean hasLeft(int index) {
        /*TODO */
        return false;
    }

    private boolean hasRight(int index) {
        /*TODO */
        return false;
    }

    private int LeftIndex(int index) {
        /*TODO */
        return 0;
    }

    private int RightIndex(int index) {
        /*TODO */
        return 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }
}
