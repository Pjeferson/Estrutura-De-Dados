package estrutura.sequencia.encadeada;

import estrutura.listaDuplamenteLigada.No;
import estrutura.sequencia.EPosicaoInvalida;
import estrutura.sequencia.ESequenciaVazia;
import estrutura.sequencia.Sequencia;

public class SequenciaEncadeada implements Sequencia{
	No header, trailer;
	int tam;

	public SequenciaEncadeada() {
		header = new No();
		trailer = new No();
		header.setElemento(null);
		trailer.setElemento(null);
		header.setProximo(trailer);
		trailer.setAnterior(header);
		tam = 0;
	}

	@Override
	public Object elemAtRank(int r) throws EPosicaoInvalida{
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		No n;
		if (r <= size()/2) {
			n = header.getProximo();
			for(int i=0; i < r; i++){
				n = n.getProximo();
			}
		}else{
			n = trailer.getAnterior();
			for(int i=0; i < size()-r-1 ; i++)
				n = n.getAnterior();
		}
		return n.getElemento();
	}

	@Override
	public Object replaceAtRank(int r, Object o) throws EPosicaoInvalida{
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		No n;
		if (r <= size()/2) {
			n = header.getProximo();
			for(int i=0; i < r; i++){
				n = n.getProximo();
			}
		}else{
			n = trailer.getAnterior();
			for(int i=0; i < size()-r-1 ; i++)
				n = n.getAnterior();
		}
		Object aux = n.getElemento();
		n.setElemento(o);
		return aux;
	}

	@Override
	public void insertAtRank(int r, Object o) throws EPosicaoInvalida{
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		No n;
		if (r <= size()/2) {
			n = header.getProximo();
			for(int i=0; i < r; i++){
				n = n.getProximo();
			}
		}else{
			n = trailer.getAnterior();
			for(int i=0; i < size()-r-1 ; i++)
				n = n.getAnterior();
		}
		No nAux = new No();
		nAux.setElemento(o);
		nAux.setAnterior(n.getAnterior());
		nAux.setProximo(n);
		n.getAnterior().setProximo(nAux);
		n.setAnterior(nAux);
		tam++;
	}

	@Override
	public Object removeAtRank(int r) throws EPosicaoInvalida{
		No n = atRank(r);
		n.getAnterior().setProximo(n.getProximo());
		n.getProximo().setAnterior(n.getAnterior());
		Object aux = n.getElemento();
		n = null;
		tam--;
		return aux;
	}

	@Override
	public No first() throws ESequenciaVazia{
		if(isEmpty()){
			throw new ESequenciaVazia("Sequência Vazia");
		}
		return header.getProximo();
	}

	@Override
	public No last() throws ESequenciaVazia{
		if(isEmpty()){
			throw new ESequenciaVazia("Sequência Vazia");
		}
		return trailer.getAnterior();
	}

	@Override
	public No before(No n) {
		return n.getAnterior();
	}

	@Override
	public No after(No n) {
		return n.getProximo();
	}

	@Override
	public void replaceElement(No n, Object o) {
		n.setElemento(o);
	}

	@Override
	public void swapElements(No n, No q) {
		No anteriorAux = q.getAnterior();
		No proximoAux = q.getProximo();

		q.setAnterior(n.getAnterior());
		q.setProximo(n.getProximo());
		n.getAnterior().setProximo(q);
		n.getProximo().setAnterior(q);

		n.setAnterior(anteriorAux);
		n.setProximo(proximoAux);
		anteriorAux.setProximo(n);
		proximoAux.setAnterior(n);
	}

	@Override
	public void insertBefore(No n, Object o) {
		No nAux = new No();
		nAux.setElemento(o);
		nAux.setAnterior(n.getAnterior());
		nAux.setProximo(n);
		n.getAnterior().setProximo(nAux);
		n.setAnterior(nAux);
		tam++;
	}

	@Override
	public void insertAfter(No n, Object o) {
		No nAux = new No();
		nAux.setElemento(o);
		nAux.setProximo(n.getProximo());
		nAux.setAnterior(n);
		n.getProximo().setAnterior(nAux);
		n.setProximo(nAux);
		tam++;
	}

	@Override
	public void insertFirst(Object o) {
		No nAux = new No();
		nAux.setElemento(o);
		nAux.setProximo(header.getProximo());
		header.getProximo().setAnterior(nAux);
		header.setProximo(nAux);
		nAux.setAnterior(header);

		tam++;
	}

	@Override
	public void insertLast(Object o) {
		No nAux = new No();
		nAux.setElemento(o);
		nAux.setAnterior(trailer.getAnterior());
		trailer.getAnterior().setProximo(nAux);
		trailer.setAnterior(nAux);
		nAux.setProximo(trailer);

		tam++;
	}

	@Override
	public void remove(No n) {
		n.getAnterior().setProximo(n.getProximo());
		n.getProximo().setAnterior(n.getAnterior());
		n = null;
		tam--;
	}

	@Override
	public No atRank(int r) throws EPosicaoInvalida{
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		No n;
		if (r <= size()/2) {
			n = header.getProximo();
			for(int i=0; i < r; i++){
				n = n.getProximo();
			}
		}else{
			n = trailer.getAnterior();
			for(int i=0; i < size()-r-1 ; i++)
				n = n.getAnterior();
		}
		return n;
	}

	@Override
	public int rankOf(No n) {
		No nAux = header.getProximo();
		int r = 0;
		while(n != nAux && nAux != trailer) {
			nAux = nAux.getProximo();
			r++;
		}
		return nAux == trailer? -1 : r;
	}

	@Override
	public int size() {
		return tam;
	}

	@Override
	public boolean isEmpty() {
		return header.getProximo() == trailer;
	}

}
