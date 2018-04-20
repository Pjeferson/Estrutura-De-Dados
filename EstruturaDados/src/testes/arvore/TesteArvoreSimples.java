package testes.arvore;

import java.util.Iterator;

import estrutura.arvore.NoArvore;
import estrutura.arvore.simples.ArvoreSimples;

public class TesteArvoreSimples {
	public static void main(String[] args) {
		ArvoreSimples arvore = new ArvoreSimples(0);
		arvore.addChild(arvore.root(), 1);
		arvore.addChild(arvore.root(), 2);
		Iterator ite = arvore.children(arvore.root());
		NoArvore n3 = (NoArvore)ite.next();
		arvore.addChild(n3, 3);
		arvore.addChild(n3, 4);
		
		//System.out.println(arvore.size());
		Iterator ele = arvore.elements();
		while (ele.hasNext()) {
			System.out.println(ele.next());
		}
	}
}
