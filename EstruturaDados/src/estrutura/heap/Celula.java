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
public class Celula implements Comparable<Celula>{
    private int key;
    private Object element;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    @Override
    public int compareTo(Celula o) {
        if(this.key < o.key){
            return -1;
        } else if (this.key > o.key){
            return 1;
        } else {
            return 0;
        }
    }
    
    
}
