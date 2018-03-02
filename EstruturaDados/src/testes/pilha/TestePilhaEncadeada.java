package testes.pilha;

import estrutura.pilha.encadeada.PilhaEncadeada;

public class TestePilhaEncadeada {
	public static void main(String[] args) {
		PilhaEncadeada pilha = new PilhaEncadeada();
		int timeStart = 15;
		while(timeStart-- > 0){
			pilha.push(timeStart);
		}
		System.out.println("Tamanho: "+pilha.size());
		System.out.println("==================");
		int timeEnd = 15;
		while(timeEnd-- > 0){
			System.out.println(pilha.pop());
		}
	}
}
