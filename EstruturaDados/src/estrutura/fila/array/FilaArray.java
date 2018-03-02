package estrutura.fila.array;

import estrutura.fila.EFilaVazia;
import estrutura.fila.Fila;

public class FilaArray implements Fila {
	private Object q[];
	private int i;
	private int f;
	private int c;

	public FilaArray(int tam, int c){
		i = 0;
		f = 0;
		q = new Object[tam];
		if (c <= 0) {
			this.c = -1;
		} else {
			this.c = c;
		}
	}
	public int tamanho() {
		return (q.length -i+f)%q.length;
	}


	public boolean estaVazia() {
		return i == f;
	}


	public Object inicio() throws EFilaVazia {
		return q[i];
	}


	public void enfileirar(Object o) {
		if(tamanho() == q.length - 1){
			Object qtemp[];
			if (c < 0) {
				qtemp = new Object[q.length *2];
			} else {
				qtemp = new Object[q.length+c];
			}
			int j;
			for (j = 0; !estaVazia(); j++) {
				qtemp[j] = desenfileirar();
			}
			i=0;
			f = j;
			q = qtemp;
		}
		q[f++] = o;
		f %= q.length;
	}


	public Object desenfileirar() throws EFilaVazia {
		if (this.estaVazia()) {
			throw new EFilaVazia("Fila vazia");
		}
		Object o = q[i++];
		i %= q.length;
		return o;
	}

}
