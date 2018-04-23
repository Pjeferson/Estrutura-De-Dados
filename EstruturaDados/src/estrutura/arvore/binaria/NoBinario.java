package estrutura.arvore.binaria;

import estrutura.arvore.Position;

public class NoBinario  implements Position, Comparable<NoBinario>{
	private Object elemento;
	private NoBinario pai, filhoEsquerda, filhoDireita;

	public NoBinario()
	{
	}

	public NoBinario(NoBinario pai, Object o)
	{
		this.elemento = o;
		this.pai = pai;
		this.filhoDireita = null;
		this.filhoEsquerda = null;
	}

	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public NoBinario getPai() {
		return pai;
	}
	public void setPai(NoBinario pai) {
		this.pai = pai;
	}
	public NoBinario getFilhoEsquerda() {
		return filhoEsquerda;
	}
	public void setFilhoEsquerda(NoBinario filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}
	public NoBinario getFilhoDireita() {
		return filhoDireita;
	}
	public void setFilhoDireita(NoBinario filhoDireita) {
		this.filhoDireita = filhoDireita;
	}

	@Override
	public Object element() {
		return elemento;
	}

	@Override
	public int compareTo(NoBinario n) {
		if ((int)this.elemento < (int)n.elemento) {
			return -1;
		}
		if ((int)this.elemento > (int)n.elemento) {
			return 1;
		}
		return 0;
	}
}
