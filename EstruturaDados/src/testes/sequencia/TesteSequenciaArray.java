package testes.sequencia;

import estrutura.sequencia.array.SequenciaArray;

public class TesteSequenciaArray {
	public static void main(String[] args) {
		SequenciaArray sequencia = new SequenciaArray(10, 5);
		
		sequencia.insertFirst(1);
		System.out.println(sequencia.size());
		sequencia.insertAtRank(0, 2);
		int teste = sequencia.size();
		System.out.println("Tamanho: "+ teste);
		System.out.println("==========");
		for (int i = 0; i < teste; i++) {
			System.out.println(sequencia.elemAtRank(i));
		}
		System.out.println("==========");
		System.out.println("Sequência vazia?: " + sequencia.isEmpty());
	}
}
