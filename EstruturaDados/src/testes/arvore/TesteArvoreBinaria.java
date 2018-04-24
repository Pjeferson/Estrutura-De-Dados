package testes.arvore;

import java.util.Iterator;
import java.util.Scanner;

import estrutura.arvore.InvalidPositionException;
import estrutura.arvore.binaria.ArvoreBinaria;
import estrutura.arvore.binaria.NoBinario;

public class TesteArvoreBinaria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArvoreBinaria arvore = new ArvoreBinaria(16);
		arvore.insert(10);
		arvore.insert(20);
		arvore.insert(6);
		arvore.insert(12);
		/*String txt;
		while(!(txt = sc.next()).equals(".")){
			int in = Integer.parseInt(txt);
			if (arvore.find(in) != null) {
				System.out.println("encontrado");
			} else {
				System.out.println("não encontrado");
			}
		}*/
		try {
			if(arvore.remove(16) == null){
				System.err.println("falhou");
			}
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}
		Iterator<Object> ite = arvore.elements();
		while(ite.hasNext()){
			System.out.println(ite.next() + " ");
		}
		System.out.println("\n#####");
		System.out.println("Tamanho: "+arvore.size());
		System.out.println("Altura: "+arvore.height());
	}
}
