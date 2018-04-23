package testes.arvore;

import java.util.Iterator;
import java.util.Scanner;

import estrutura.arvore.binaria.ArvoreBinaria;
import estrutura.arvore.binaria.NoBinario;

public class TesteArvoreBinaria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArvoreBinaria arvore = new ArvoreBinaria(0);
		arvore.insert(1);
		arvore.insert(2);
		arvore.insert(3);
		arvore.insert(4);
		String txt;
		while(!(txt = sc.next()).equals(".")){
			int in = Integer.parseInt(txt);
			if (arvore.find(in) != null) {
				System.out.println("encontrado");
			} else {
				System.out.println("não encontrado");
			}
		}
		System.out.println("\n#####");
		System.out.println("Tamanho: "+arvore.size());
		System.out.println("Altura: "+arvore.height());
	}
}
