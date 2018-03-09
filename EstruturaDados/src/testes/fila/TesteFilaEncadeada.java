package testes.fila;

import estrutura.fila.EFilaVazia;
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
		int timeEnd = 16;
		while(timeEnd-- > 0){
			try{
			System.out.println(fila.desenfileirar());
		} catch (EFilaVazia e){
			System.out.println(e.getMessage());	
		}
		}
	}
}
