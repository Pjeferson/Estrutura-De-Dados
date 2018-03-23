package testes.sequencia;

import estrutura.sequencia.array.SequenciaArray;

public class TesteSequenciaArray {
	public static void main(String[] args) {
		SequenciaArray sequencia = new SequenciaArray(10, 5);
		
		sequencia.insertFirst(10);
		sequencia.insertAtRank(0, 20);
		sequencia.insertAtRank(1, 30);
		sequencia.insertBefore(sequencia.atRank(1),4);
		sequencia.insertAfter(sequencia.atRank(3),5);
		sequencia.insertFirst(1);
		sequencia.insertLast(999);
		System.out.println(sequencia.first().getElemento());
		System.out.println(sequencia.last().getElemento());
		System.out.println(sequencia.before(sequencia.atRank(3)).getElemento());
		System.out.println(sequencia.after(sequencia.atRank(3)).getElemento());
		int teste = sequencia.size();
		System.out.println("Tamanho: "+ sequencia.size());
		System.out.println("==========");
		for (int i = 0; i < teste; i++) {
			System.out.println(sequencia.removeAtRank(0));
		}
		System.out.println("==========");
		System.out.println("Sequência vazia?: " + sequencia.isEmpty());
	}
}
