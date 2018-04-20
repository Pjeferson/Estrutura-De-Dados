package estrutura.arvore.binaria;

public class NoBinario {
	Object elemento;
	NoBinario pai, filhoEsquerda, filhoDireita;
	
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
}
