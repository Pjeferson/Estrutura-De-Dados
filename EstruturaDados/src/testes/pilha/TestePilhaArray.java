package testes.pilha;

import estrutura.pilha.array.PilhaArray;

public class TestePilhaArray {
	public static void main(String[] args) {
		PilhaArray pilha = new PilhaArray(10,0);
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
