package estrutura.pilha.encadeada;

import estrutura.pilha.Pilha;
import estrutura.listaLigada.No;
import estrutura.pilha.EPilhaVazia;

public class PilhaEncadeada implements Pilha{
	private int tam;
	private No tos;

	public PilhaEncadeada() {
		tam = 0;
		tos = null;
	}

	@Override
	public int size() {
		return tam;
	}

	@Override
	public boolean isEmpty() {
		return tos == null;
	}

	@Override
	public Object top() throws EPilhaVazia {
		if (this.isEmpty()) {
			throw new EPilhaVazia("Pilha vazia");
		}
		return tos.getElemento();
	}

	@Override
	public void push(Object o) {
		No ntemp = new No();
		ntemp.setElemento(o);
		ntemp.setProximo(tos);
		tos = ntemp;
		tam++;
	}

	@Override
	public Object pop() throws EPilhaVazia {
		if (this.isEmpty()) {
			throw new EPilhaVazia("Pilha vazia");
		}
		Object otemp = tos.getElemento();
		tos = tos.getProximo();
		tam--;
		return otemp;
	}


}
