package estrutura.arvore.binaria;

import java.util.Iterator;

import estrutura.arvore.Arvore;
import estrutura.arvore.Position;

public interface ArvoreBinariaInterface{
	public Position leftChild(Position p);
	public Position rightChild(Position p);
	public boolean hasLeft(Position p);
	public boolean hasRight(Position p);
	
	//Metodos de Arvore com 'No' alterado
	
	/* M�todos gen�ricos */
	/** Retorna o n�mero de n�s da �rvore */
	public int size();
	/** retorna se a �rvore est� vazia */
	public boolean isEmpty();
	/** Retorna a altura da �rvore */
	public int height();
	/** Retorna um iterator com os elementos armazenados na �rvore */
	public Iterator elements();
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator nos();

	/* M�todos de acesso*/
	/** Retorna a raiz da �rvore */
	public NoBinario root();
	/** Retorna o n� pai de um n� */
	public NoBinario parent(NoBinario v);
	/** Retorna os filhos de um n� */
	public Iterator children(NoBinario v);

	/* M�todos de consulta */
	/** Testa se um n� � interno */
	public boolean isInternal(NoBinario v);
	/** Testa se um n� � externo*/
	public boolean isExternal(NoBinario v);
	/** Testa se um n� � a raiz */
	public boolean isRoot(NoBinario v);
	/** Retorna a profundidade de um n� */
	public int depth(NoBinario v);

	/* M�todos de atualiza��o */
	/** Substitui o objeto de um um n� */
	public Object replace(NoBinario v, Object o);
	/** Retorna a profundidade de um n� */
}
