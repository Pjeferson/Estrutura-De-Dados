package estrutura.fila.encadeada;

import estrutura.fila.Fila;
import estrutura.listaLigada.No;
import estrutura.fila.EFilaVazia;

public class FilaEncadeada implements Fila{
	
	private No i;
	private No f;
	private int tam;

	public FilaEncadeada() {
		i =  null;
		f = null;
		tam = 0;
	}
	
	@Override
	public int tamanho() {
		return tam;
	}

	@Override
	public boolean estaVazia() {
		return tam == 0;
	}

	@Override
	public Object inicio() throws EFilaVazia {
		if (this.estaVazia()) {
			throw new EFilaVazia("Fila vazia");
		}
		return i.getElemento();
	}

	@Override
	public void enfileirar(Object o) {
		No ntemp = new No();
		ntemp.setElemento(o);
		ntemp.setProximo(null);
		if(f != null){
			f.setProximo(ntemp);
			f = ntemp;
		} else {
			i = ntemp;
			f = ntemp;
		}
		tam++;
	}

	@Override
	public Object desenfileirar() throws EFilaVazia {
		if (this.estaVazia()) {
			throw new EFilaVazia("Fila vazia");
		}
		Object out = i.getElemento();
		i = i.getProximo();
		tam--;
		return out;
	}
	

}
