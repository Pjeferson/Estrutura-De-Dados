package testes.fila;

import estrutura.fila.EFilaVazia;
import estrutura.fila.array.FilaArray;

public class TesteFilaArray {
	public static void main(String[] args) {
		FilaArray fila = new FilaArray(10,0);
		int timeStart = 15;
		while(timeStart-- > 0){
			fila.enfileirar(timeStart);
		}
		System.out.println("Tamanho: "+fila.tamanho());
		System.out.println("==================");
		int timeEnd = 16;
		while(timeEnd-- > 0){
			try {
			System.out.println(fila.desenfileirar());
			} catch (EFilaVazia e){
				System.out.println(e.getMessage());	
			}
		}
	}
}
