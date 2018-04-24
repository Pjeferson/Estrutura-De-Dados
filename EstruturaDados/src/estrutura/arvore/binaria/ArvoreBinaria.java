package estrutura.arvore.binaria;

import java.util.Iterator;
import java.util.Vector;

import estrutura.arvore.InvalidPositionException;
import estrutura.arvore.NoArvore;
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
	public Iterator<Object> elements() {
		NoBinario n = this.raiz;
		Vector<Object> elementos = listarElementos(n);
		return elementos.iterator();
	}
	private Vector<Object> listarElementos(Position p){
		Vector<Object> v = new Vector<>();
		NoBinario n = (NoBinario) p;
		Iterator<NoBinario> filhos = children(n);
		while (filhos.hasNext()) {
			NoBinario filho = (NoBinario) filhos.next();
			v.addAll(listarElementos(filho));
		}
		v.add(n.element());
		return v;
	}
	@Override
	public Iterator nos() {
		// TODO método baseado em elements. Retornando iterador de nós
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
		if(v.getFilhoEsquerda()!=null){
			vector.add(v.getFilhoEsquerda());
		}
		if(v.getFilhoDireita()!=null){
			vector.add(v.getFilhoDireita());
		}
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
	public NoBinario remove(Object o) throws InvalidPositionException{
		NoBinario n = find(o);
		return remover(n, o);
	}
	public NoBinario remover(NoBinario n, Object o) throws InvalidPositionException{
		if (isRoot(n)) {
			throw new InvalidPositionException("Não é possível remover a raiz");
		}
		if (n != null) {
			/*folha*/
			if (isExternal(n)) {
				if (n.compareTo(n.getPai()) <= 0) {
					n.getPai().setFilhoEsquerda(null);
				} else {
					n.getPai().setFilhoDireita(null);
				}
				return n;
			}
			/*um nó*/
			if (n.getFilhoEsquerda() != null && n.getFilhoDireita() == null) {
				if (n.compareTo(n.getPai()) <= 0) {
					n.getPai().setFilhoEsquerda(n.getFilhoEsquerda());
					n.getFilhoEsquerda().setPai(n.getPai());
				} else {
					n.getPai().setFilhoDireita(n.getFilhoEsquerda());
					n.getFilhoEsquerda().setPai(n.getPai());
				}
				return n;
			}
			if (n.getFilhoEsquerda() == null && n.getFilhoDireita() != null) {
				if (n.compareTo(n.getPai()) <= 0) {
					n.getPai().setFilhoEsquerda(n.getFilhoDireita());
					n.getFilhoDireita().setPai(n.getPai());
				} else {
					n.getPai().setFilhoDireita(n.getFilhoDireita());
					n.getFilhoDireita().setPai(n.getPai());
				}
				return n;
			}
			/*dois nós*/
			NoBinario andaEsq = n.getFilhoDireita();
			while (andaEsq.getFilhoEsquerda() != null) {
				andaEsq = andaEsq.getFilhoEsquerda();
			}
			Object valorBackup = andaEsq.element();
			remover(andaEsq, valorBackup);
			n.setElemento(valorBackup);
			return n;
		}
		return null;
	}
	/*fim da parte de pesquisa*/

	@Override
	public String toString() {
		//TODO Retornar um String com a representação gráfica da arvore
		return super.toString();
	}
}
