package estrutura.arvore.simples;

import java.util.Iterator;
import java.util.Vector;

import estrutura.arvore.ArvoreGenerica;
import estrutura.arvore.InvalidPositionException;
import estrutura.arvore.NoArvore;
import estrutura.arvore.Position;
public class ArvoreSimples {
	//Atributos da árvore
	NoArvore raiz;
	int tamanho;
	//Construtor
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
	public Iterator children(Position v)
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
		/*Método que serve de exercício
		 * Este método deverá fazer com que o objeto
		 * que estava na posição v fique na posição w
		 * e fazer com que o objeto que estava na posição w
		 * fique na posição v
		 */  
		
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
		// Método que serve de exercício
		int altura = 0;
		return altura;
	}
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements()
	{
		NoArvore n = raiz;
		Vector<NoArvore> elementos = listar(n);
		return elementos.iterator();
	}
	private Vector<NoArvore> listar(Position p){
		Vector v = new Vector<>();
		NoArvore n = (NoArvore) p;
		Iterator filhos = n.children();
		while (filhos.hasNext()) {
			NoArvore filho = (NoArvore) filhos.next();
			//System.out.println(filho.element());
			/*Bug  no armazenamento*/
			v = listar(filho);
		}
		v.add(n.element());
		return v;
	}
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator positions()
	{
		// Método não implementados --- Coleguinha fique a vontade para fazê-los
		return null;
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
	public Object replace(Position v, Object o)
	{
		// Método de exercício
		return null;
	}
}
