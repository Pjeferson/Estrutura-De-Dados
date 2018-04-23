package estrutura.arvore.binaria;

import java.util.Iterator;
import java.util.Vector;

import estrutura.arvore.Position;

public class ArvoreBinaria implements ArvoreBinariaInterface{
	private NoBinario raiz;
	private int tamanho;

	public ArvoreBinaria(Object o) {
		this.raiz = new NoBinario(null, o);
		this.tamanho = 0;
	}

	@Override
	public Position leftChild(Position p) {
		NoBinario no = (NoBinario)p; 
		return no.getFilhoEsquerda();
	}

	@Override
	public Position rightChild(Position p) {
		NoBinario no = (NoBinario)p; 
		return no.getFilhoDireita();
	}

	@Override
	public boolean hasLeft(Position p) {
		NoBinario no = (NoBinario)p;
		return no.getFilhoEsquerda() != null;
	}

	@Override
	public boolean hasRight(Position p) {
		NoBinario no = (NoBinario)p; 
		return no.getFilhoDireita() != null;
	}

	@Override
	public int size() {
		return this.tamanho;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int height() {
		NoBinario raiz = root();
		return altura(raiz);
	}
	public int altura(NoBinario v){
		if (isExternal(v)) {
			return 0;
		} else {
			int altura = 0;
			Iterator<NoBinario> filhos = children(v);
			while (filhos.hasNext()) {
				NoBinario filho = filhos.next();
				if (filho != null) {					
					int alt2 = altura(filho);
					altura = altura>=alt2?altura:alt2;
				}
			}
			return altura+1;
		}
	}

	@Override
	public Iterator elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator nos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBinario root() {
		return this.raiz;
	}

	@Override
	public NoBinario parent(NoBinario v) {
		return v.getPai();
	}

	@Override
	public Iterator<NoBinario> children(NoBinario v) {
		Vector<NoBinario> vector = new Vector<>();
		vector.add(v.getFilhoEsquerda());
		vector.add(v.getFilhoDireita());
		return vector.iterator();
	}

	@Override
	public boolean isInternal(NoBinario v) {
		return (v.getFilhoEsquerda() != null || v.getFilhoDireita() != null);
	}

	@Override
	public boolean isExternal(NoBinario v) {
		return (v.getFilhoEsquerda() == null && v.getFilhoDireita() == null);
	}

	@Override
	public boolean isRoot(NoBinario v) {
		return v == this.raiz;
	}

	@Override
	public int depth(NoBinario v) {
		return profundidade(v);
	}

	private int profundidade(NoBinario v) {
		if (v == this.raiz)
			return 0;
		else
			return 1 + profundidade(v.getPai());
	}
	@Override
	public Object replace(NoBinario v, Object o) {
		Object backup = v.element();
		v.setElemento(o);
		return backup;
	}
	
	/*pesquisa*/
	public NoBinario find(Object o){
		NoBinario n = new NoBinario(null, o);
		return achar(this.raiz,n);
	}
	private NoBinario achar(NoBinario noAtual, NoBinario n){
		if(n.compareTo(noAtual) < 0){
			if (hasLeft(noAtual)) {
				noAtual = (NoBinario)leftChild(noAtual);
				return achar(noAtual, n);
			} else {
				return null;
			}
		}
		if(n.compareTo(noAtual) > 0){
			if (hasRight(noAtual)) {
				noAtual = (NoBinario)rightChild(noAtual);
				return achar(noAtual, n);
			} else {
				return null;
			}
		}
		return noAtual;
	}
	public void insert(Object o){
		NoBinario n = new NoBinario(null, o);
		inserir(this.raiz, n);
	}
	private void inserir(NoBinario noAtual, NoBinario n){
		if(n.compareTo(noAtual) <= 0){
			if (hasLeft(noAtual)) {
				noAtual = (NoBinario)leftChild(noAtual);
				inserir(noAtual, n);
			} else {
				noAtual.setFilhoEsquerda(n);
				n.setPai(noAtual);
				this.tamanho++;
			}
		} else {
			if (hasRight(noAtual)) {
				noAtual = (NoBinario)rightChild(noAtual);
				inserir(noAtual, n);
			} else {
				noAtual.setFilhoDireita(n);
				n.setPai(noAtual);
				this.tamanho++;
			}
		}
	}
	public NoBinario remove(Object o){
		NoBinario n = find(o);
		//TODO operar sobre nó n para completar sua remoção
		return n;
	};
	/*fim da parte de pesquisa*/
	
	@Override
	public String toString() {
		//TODO Retornar um String com a representação gráfica da arvore
		return super.toString();
	}
}
