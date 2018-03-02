package testes.fila;

import estrutura.fila.encadeada.FilaEncadeada;

public class TesteFilaEncadeada {
	public static void main(String[] args) {
		FilaEncadeada fila = new FilaEncadeada();
		int timeStart = 15;
		while(timeStart-- > 0){
			fila.enfileirar(timeStart);
		}
		System.out.println("Tamanho: "+fila.tamanho());
		System.out.println("==================");
		int timeEnd = 15;
		while(timeEnd-- > 0){
			System.out.println(fila.desenfileirar());
		}
	}
}
