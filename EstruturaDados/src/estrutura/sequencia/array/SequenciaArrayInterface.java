package estrutura.sequencia.array;

import estrutura.sequencia.EPosicaoInvalida;
import estrutura.sequencia.ESequenciaVazia;

public interface SequenciaArrayInterface {
	public Object elemAtRank(int r) throws EPosicaoInvalida;
	public Object replaceAtRank(int r, Object o) throws EPosicaoInvalida;
	public void insertAtRank(int r, Object o) throws EPosicaoInvalida;
	public Object removeAtRank(int r) throws EPosicaoInvalida;
	
	public No first() throws ESequenciaVazia;
	public No last() throws ESequenciaVazia;
	public No before(No n);
	public No after(No n);
	public void replaceElement(No n, Object o);
	public void swapElements(No n, No q);
	public void insertBefore(No n, Object o);
	public void insertAfter(No n, Object o);
	public void insertFirst(Object o);
	public void insertLast(Object o);
	public void remove(No n);

	public No atRank(int r) throws EPosicaoInvalida;
	public int rankOf(No n);
	
	public int size();
	public boolean isEmpty();
}
