package testes.arvore;

import java.util.Iterator;

import estrutura.arvore.NoArvore;
import estrutura.arvore.simples.ArvoreSimples;

public class TesteArvoreSimples {
	public static void main(String[] args) {
		ArvoreSimples arvore = new ArvoreSimples(0);
		arvore.addChild(arvore.root(), 1);
		arvore.addChild(arvore.root(), 2);
		
		Iterator<NoArvore> ite = arvore.children(arvore.root());
		NoArvore n3 = (NoArvore)ite.next();
		arvore.addChild(n3, 3);
		arvore.addChild(n3, 4);
		
		Iterator<NoArvore> ite1 = arvore.children(n3);
		NoArvore n5 = (NoArvore)ite1.next();
		arvore.addChild(n5, 5);
		arvore.addChild(n5, 6);
		arvore.addChild(n5, 7);
		
		Iterator<Object> ele = arvore.elements();
		System.out.println("Lista por elementos: ");
		while (ele.hasNext()) {
			System.out.print(ele.next()+" ");
		}
		
		arvore.swapElements(n3, arvore.root());/*inverte 1 com 0*/
		arvore.replace(arvore.root(), 12);/*inverte 1 com 12*/
		Iterator<NoArvore> elePosi = arvore.positions();
		System.out.println("\nLista por postions: ");
		while (elePosi.hasNext()) {
			NoArvore no = (NoArvore)elePosi.next();
			System.out.print(no.element()+" ");
		}
		System.out.println("\n#####");
		System.out.println("Tamanho: "+arvore.size());
		System.out.println("Altura: "+arvore.height());
	}
}
