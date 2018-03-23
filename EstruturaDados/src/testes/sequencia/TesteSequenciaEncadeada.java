package testes.sequencia;

import estrutura.sequencia.encadeada.SequenciaEncadeada;

public class TesteSequenciaEncadeada {
	public static void main(String[] args) {
		SequenciaEncadeada sequencia = new SequenciaEncadeada();
		
		sequencia.insertFirst(10);
		sequencia.insertAtRank(0, 20);
		int teste = sequencia.size();
		System.out.println("Tamanho: "+ teste);
		System.out.println("==========");
		for (int i = 0; i < teste; i++) {
			System.out.println(sequencia.removeAtRank(0));
		}
		System.out.println("==========");
		System.out.println("Sequência vazia?: " + sequencia.isEmpty());
	}
}
