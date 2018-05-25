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
public class TesteArrayCelula {

    /*Testando implementação para método swap da Heap*/
    public static void main(String[] args) {
        Celula[] cel = new Celula[2];
        
        Celula cel1 = new Celula();
        cel1.setKey(1);
        cel1.setElement(1);
        cel[0] = cel1;
        
        Celula cel2 = new Celula();
        cel2.setKey(2);
        cel2.setElement(2);
        cel[1] = cel2;
        
        Celula cel3 = cel[0];
        cel[0] = cel[1];
        cel[1] = cel3;
        System.out.println(cel[0].getKey() +"--"+cel[1].getKey());
    }
}
