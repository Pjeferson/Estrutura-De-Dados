package estrutura.pilha.array;

import estrutura.pilha.EPilhaVazia;
import estrutura.pilha.Pilha;

public class PilhaArray implements Pilha{
	private Object s[];
	private int tos;
	private int c;

	public PilhaArray(int tam, int c){
		s = new Object[tam];
		if (c <= 0) {
			this.c = -1;
		} else {
			this.c = c;
		}
		tos = -1;
	}

	@Override
	public int size() {
		return tos+1;
	}

	@Override
	public boolean isEmpty() {
		return tos < 0;
	}

	@Override
	public Object top() throws EPilhaVazia {
		if (this.isEmpty()) {
			throw new EPilhaVazia("Pilha vazia");
		}
		return s[tos];
	}

	@Override
	public void push(Object o) {
		if (tos == s.length -1) {
			Object stemp[];
			if (c < 0) {
				stemp = new Object[s.length *2];
			} else {
				stemp = new Object[s.length+c];
			}
			for (int i = 0; i < s.length; i++) {
				stemp[i] = s[i];
			}
			s = stemp;
		}
		s[++tos] = o;
	}

	@Override
	public Object pop() throws EPilhaVazia {
		if (this.isEmpty()) {
			throw new EPilhaVazia("Pilha vazia");
		}
		return s[tos--];
	}

}
