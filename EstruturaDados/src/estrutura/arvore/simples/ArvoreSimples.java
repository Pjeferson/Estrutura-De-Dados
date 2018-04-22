package estrutura.arvore.simples;

import java.util.Iterator;
import java.util.Vector;

import estrutura.arvore.InvalidPositionException;
import estrutura.arvore.NoArvore;
import estrutura.arvore.Position;
public class ArvoreSimples{
	NoArvore raiz;
	int tamanho;

	public ArvoreSimples(Object o)
	{
		raiz = new NoArvore(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da árvore */
	public Position root()
	{
		return raiz;
	}
	/** Retorna o nó pai de um nó */
	public Position parent(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.parent());
	}
	/** retorna os filhos de um nó */
	public Iterator<NoArvore> children(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n.children();
	}
	/** Testa se um nó é interno */
	public boolean isInternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() > 0);
	}
	/** Testa se um nó é externo*/
	public boolean isExternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() == 0);
	}
	/** Testa se um nó é a raiz */
	public boolean isRoot(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n == raiz;
	}
	/** Adiciona um filho a um nó */
	public void addChild(Position v, Object o)
	{
		NoArvore n = (NoArvore) v;
		NoArvore novo = new NoArvore(n, o);
		n.addChild(novo);
		tamanho++;
	}
	/** Remove um nó
	 *  Só pode remover nós externos e que tenham um pai (não seja raiz)
	 */
	public Object remove(Position v) throws InvalidPositionException
	{
		NoArvore n = (NoArvore) v;
		NoArvore pai = n.parent();
		if (pai != null || isExternal(n))
			pai.removeChild(n);
		else
			throw new InvalidPositionException("Posição Inválida");
		Object o = n.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posição */
	public void swapElements(Position v, Position w)
	{
		NoArvore n1 = (NoArvore) v;
		NoArvore n2 = (NoArvore) w;
		Object backupN2 = n1.element();
		n1.setElement(n2.element());
		n2.setElement(backupN2);
	}
	/** Retorna a profundidade de um nó */
	public int depth(Position v)
	{
		NoArvore n = (NoArvore) v;
		int profundidade = profundidade(n);
		return profundidade;
	}
	private int profundidade(NoArvore n)
	{
		if (n == raiz)
			return 0;
		else
			return 1 + profundidade(n.parent());
	}
	/** Retorna a altura da árvore */
	public int height()
	{
		NoArvore raiz = (NoArvore)root();
		return altura(raiz);
	}
	public int altura(NoArvore no){
		if (isExternal(no)) {
			return 0;
		} else {
			int altura = 0;
			Iterator<NoArvore> filhos = no.children();
			while (filhos.hasNext()) {
				NoArvore filho = (NoArvore) filhos.next();
				int alt2 = altura(filho);
				altura = altura>=alt2?altura:alt2;
			}
			return altura+1;
		}
	}
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator<Object> elements()
	{
		NoArvore n = raiz;
		Vector<Object> elementos = listarElementos(n);
		return elementos.iterator();
	}
	private Vector<Object> listarElementos(Position p){
		Vector<Object> v = new Vector<>();
		NoArvore n = (NoArvore) p;
		Iterator<NoArvore> filhos = n.children();
		while (filhos.hasNext()) {
			NoArvore filho = (NoArvore) filhos.next();
			v.addAll(listarElementos(filho));
		}
		v.add(n.element());
		return v;
	}
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator<NoArvore> positions()
	{
		NoArvore n = raiz;
		Vector<NoArvore> positions = listarPositions(n);
		return positions.iterator();
	}
	private Vector<NoArvore> listarPositions(Position p){
		Vector<NoArvore> v = new Vector<>();
		NoArvore n = (NoArvore) p;
		Iterator<NoArvore> filhos = n.children();
		while (filhos.hasNext()) {
			NoArvore filho = (NoArvore) filhos.next();
			v.addAll(listarPositions(filho));
		}
		v.add(n);
		return v;
	}
	/** Retorna o número de nós da árvore
	 */
	public int size()
	{
		return this.tamanho;
	}
	/** Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	/** Substitui elemento de um nó específico
	 */
	public Object replace(Position v, Object o)
	{
		NoArvore n1 = (NoArvore) v;
		Object backupN1 = n1.element();
		n1.setElement(o);
		return backupN1;
	}
	
	@Override
	public String toString() {
		/*Retorna um String com a representação gráfica da arvore*/
		return super.toString();
	}
}
