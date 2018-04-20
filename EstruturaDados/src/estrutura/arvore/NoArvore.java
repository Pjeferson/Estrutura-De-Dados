package estrutura.arvore;

import java.util.Iterator;
import java.util.Vector;

public class NoArvore implements Position {
	private Object o;
	private NoArvore pai;
	private Vector<NoArvore> filhos = new Vector();
	public NoArvore(NoArvore pai, Object o)
	{
		this.pai = pai;
		this.o = o;
	}
	public Object element()
	{
		return o;
	}
	public NoArvore parent()
	{
		return pai;
	}
	public void setElement(Object o)
	{
		this.o = o;
	}
	public void addChild(NoArvore o)
	{
		filhos.add(o);
	}
	public void removeChild(NoArvore o)
	{
		filhos.remove(o);
	}
	public int childrenNumber()
	{
		return filhos.size();
	}
	public Iterator children()
	{
		return filhos.iterator();
	}
}
