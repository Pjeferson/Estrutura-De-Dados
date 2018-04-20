package estrutura.arvore.simples;

import java.util.Iterator;
import java.util.Vector;

import estrutura.arvore.ArvoreGenerica;
import estrutura.arvore.InvalidPositionException;
import estrutura.arvore.NoArvore;
import estrutura.arvore.Position;
public class ArvoreSimples {
	//Atributos da �rvore
	NoArvore raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		raiz = new NoArvore(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da �rvore */
	public Position root()
	{
		return raiz;
	}
	/** Retorna o n� pai de um n� */
	public Position parent(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.parent());
	}
	/** retorna os filhos de um n� */
	public Iterator children(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n.children();
	}
	/** Testa se um n� � interno */
	public boolean isInternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() > 0);
	}
	/** Testa se um n� � externo*/
	public boolean isExternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() == 0);
	}
	/** Testa se um n� � a raiz */
	public boolean isRoot(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n == raiz;
	}
	/** Adiciona um filho a um n� */
	public void addChild(Position v, Object o)
	{
		NoArvore n = (NoArvore) v;
		NoArvore novo = new NoArvore(n, o);
		n.addChild(novo);
		tamanho++;
	}
	/** Remove um n�
	 *  S� pode remover n�s externos e que tenham um pai (n�o seja raiz)
	*/
	public Object remove(Position v) throws InvalidPositionException
	{
		NoArvore n = (NoArvore) v;
		NoArvore pai = n.parent();
		if (pai != null || isExternal(n))
			pai.removeChild(n);
		else
			throw new InvalidPositionException("Posi��o Inv�lida");
		Object o = n.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posi��o */
	public void swapElements(Position v, Position w)
	{
		/*M�todo que serve de exerc�cio
		 * Este m�todo dever� fazer com que o objeto
		 * que estava na posi��o v fique na posi��o w
		 * e fazer com que o objeto que estava na posi��o w
		 * fique na posi��o v
		 */  
		
	}
	/** Retorna a profundidade de um n� */
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
	/** Retorna a altura da �rvore */
	public int height()
	{
		// M�todo que serve de exerc�cio
		int altura = 0;
		return altura;
	}
	/** Retorna um iterator com os elementos armazenados na �rvore */
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
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator positions()
	{
		// M�todo n�o implementados --- Coleguinha fique a vontade para faz�-los
		return null;
	}
	/** Retorna o n�mero de n�s da �rvore
	 */
	public int size()
	{
		return this.tamanho;
	}
	/** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(Position v, Object o)
	{
		// M�todo de exerc�cio
		return null;
	}
}
