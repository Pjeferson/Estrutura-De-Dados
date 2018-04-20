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
	
	/* Métodos genéricos */
	/** Retorna o número de nós da árvore */
	public int size();
	/** retorna se a árvore está vazia */
	public boolean isEmpty();
	/** Retorna a altura da árvore */
	public int height();
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements();
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator nos();

	/* Métodos de acesso*/
	/** Retorna a raiz da árvore */
	public NoBinario root();
	/** Retorna o nó pai de um nó */
	public NoBinario parent(NoBinario v);
	/** Retorna os filhos de um nó */
	public Iterator children(NoBinario v);

	/* Métodos de consulta */
	/** Testa se um nó é interno */
	public boolean isInternal(NoBinario v);
	/** Testa se um nó é externo*/
	public boolean isExternal(NoBinario v);
	/** Testa se um nó é a raiz */
	public boolean isRoot(NoBinario v);
	/** Retorna a profundidade de um nó */
	public int depth(NoBinario v);

	/* Métodos de atualização */
	/** Substitui o objeto de um um nó */
	public Object replace(NoBinario v, Object o);
	/** Retorna a profundidade de um nó */
}
