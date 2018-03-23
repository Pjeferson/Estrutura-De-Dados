package estrutura.sequencia.array;

import estrutura.sequencia.EPosicaoInvalida;
import estrutura.sequencia.ESequenciaVazia;

public class SequenciaArray implements SequenciaArrayInterface{
	private No array[];
	private int i,f,c;

	public SequenciaArray(int tam, int c) {
		i = 0;
		f = 0;
		array = new No[tam];
		c = c <= 0? -1: c;
	}
	@Override
	public Object elemAtRank(int r) throws EPosicaoInvalida {
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		return array[i+r].getElemento();
	}

	@Override
	public Object replaceAtRank(int r, Object o) throws EPosicaoInvalida {
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		No no = new No();
		no.setElemento(o);
		no.setIndice(r);
		Object aux = array[i+r].getElemento(); 
		array[i+r] = no;
		return aux;
	}

	@Override
	public void insertAtRank(int r, Object o) throws EPosicaoInvalida {
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		No no = new No();
		no.setElemento(o);
		no.setIndice(r);
		
		No arrayAux[] = new No[size()+1];
		int j;
		for (j = 0; j < r; j++) {
			arrayAux[j] = array[i++];
			i %= array.length;
		}
		arrayAux[j] = no;
		while(j < size()){
			array[i].setIndice(i+1);
			arrayAux[j++] = array[i++];
			i %= array.length;
		}
		i=0;
		f = j;
		array = arrayAux;
	}

	@Override
	public Object removeAtRank(int r) throws EPosicaoInvalida {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public No first() throws ESequenciaVazia {
		return array[i];
	}

	@Override
	public No last() throws ESequenciaVazia {
		return array[(f-1)%array.length];
	}

	@Override
	public No before(No n) {
		return array[(n.getIndice() -1)%array.length];
	}

	@Override
	public No after(No n) {
		return array[(i+n.getIndice() +1)%array.length];
	}

	@Override
	public void replaceElement(No n, Object o) {
		array[(i+n.getIndice())%array.length].setElemento(o);;
	}

	@Override
	public void swapElements(No n, No q) {
		int indexN = n.getIndice();
		int indexQ = q.getIndice();
		
		q.setIndice(indexN);
		array[(i+indexN)%array.length] = q;
		n.setIndice(indexQ);
		array[(i+indexQ)%array.length] = n;
	}

	@Override
	public void insertBefore(No n, Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAfter(No n, Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertFirst(Object o) {
		int soma = size() == array.length - 1?1:0;
		No no = new No();
		no.setElemento(o);
		no.setIndice(0);
		
		No arrayAux[] = new No[array.length+soma];
		arrayAux[0] = no;
		int j;
		for (j = 1; j < size()+1; j++) {
			array[i].setIndice(i+1);
			arrayAux[j] = array[i++];
			i %= array.length;
		}
		
		i=0;
		f = j;
		array = arrayAux;
	}

	@Override
	public void insertLast(Object o) {
		if(size() == array.length - 1){
			No arrayAux[];
			if (c < 0) {
				arrayAux = new No[array.length *2];
			} else {
				arrayAux = new No[array.length+c];
			}
			int j;
			for (j = 0; j < size(); j++) {
				arrayAux[j] = array[i++];
				i %= array.length;
			}
			i=0;
			f = j;
			array = arrayAux;
		}
		No no = new No();
		no.setElemento(o);
		no.setIndice(size()+1);
		
		array[f++] = no;
		f %= array.length;
		
	}

	@Override
	public void remove(No n) {
		int index = n.getIndice();
		No arrayAux[] = new No[size()-1];
		int j;
		for (j = 0; j < index; j++) {
			arrayAux[j] = array[i++];
			i %= array.length;
		}
		j++;
		while(j < size()){
			array[i].setIndice(i-1);
			arrayAux[j++] = array[i++];
			i %= array.length;
		}
		i=0;
		f = j;
		array = arrayAux;
	}

	@Override
	public No atRank(int r) throws EPosicaoInvalida {
		if (r >= size() || r<0) {
			throw new EPosicaoInvalida("Posição Inválida");
		}
		return array[(i+r)%array.length];
	}

	@Override
	public int rankOf(No n) {
		return n.getIndice();
	}

	@Override
	public int size() {
		return (array.length -i+f)%array.length;
	}

	@Override
	public boolean isEmpty() {
		return i == f;
	}

}
