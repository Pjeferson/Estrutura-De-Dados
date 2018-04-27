package testes.arvore;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import estrutura.arvore.InvalidPositionException;
import estrutura.arvore.binaria.ArvoreBinaria;
import estrutura.arvore.binaria.NoBinario;

public class TesteArvoreBinaria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArvoreBinaria arvore = new ArvoreBinaria(15);
		arvore.insert(10);
		arvore.insert(20);
		arvore.insert(6);
		arvore.insert(12);
		//arvore.remove(16);
		Iterator<NoBinario> iteBi = arvore.nos();
		while(iteBi.hasNext()){
			System.out.print(iteBi.next().element() + " ");
		}
		System.out.println("\n#####");
		System.out.println("Tamanho: "+arvore.size());
		System.out.println("Altura: "+arvore.height());
		arvore.mostrar();
	}
}
