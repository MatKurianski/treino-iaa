/* 

  LISTA LIGADA E FUNÇÕES DO COUTINHO

*/

class No {

	private int valor;
	private No proximo;

	public No(int valor){

		this.valor = valor;
		this.proximo = null;
	}

	public void setProximo(No no){ 
	
		proximo = no; 
	}
  
	public No getProximo(){ 

		return proximo; 
	}

	public int getValor(){ 

		return valor; 
	}
}

public class ListaLigada {

	private No primeiro;

	public ListaLigada(){ 

		primeiro = null;
	}

  	public void adiciona(int valor){

    		No novo = new No(valor);

		if(primeiro == null) {

			primeiro = novo;
		}
		else {

			No ultimo = primeiro;
		
			while(ultimo.getProximo() != null) {

				ultimo = ultimo.getProximo();
			}

	    		ultimo.setProximo(novo);
		}
	}

	public int get(int indice){
		
		int i;
		No no;
		
		for(no = primeiro, i = 0; no != null; no = no.getProximo(), i++){

			if(i == indice) return no.getValor();
		}

		throw new IllegalArgumentException("Indice inválido: " + indice);
  }

/* 

  FUNÇÕES QUE ADICIONEI

*/

  public static void inicializaHashing(ListaLigada[] hash) {
    for(int i = 0; i < hash.length; i++) hash[i] = new ListaLigada();
  }

  public static void espalhaEAdiciona(ListaLigada[] hash, int valor) {
    int hashing = valor % hash.length; // ou seja, 8, como no enunciado pediu.
    hash[hashing].adiciona(valor);
  }

  public static void adicionarVarios(ListaLigada[] hash, int... valores) {
    for(int valor : valores) espalhaEAdiciona(hash, valor);
  }

  public static void imprimeHashing(ListaLigada[] hash) {
    for(int i = 0; i < hash.length; i++) {
      if(hash[i].primeiro != null) {
        System.out.println("Imprimindo a posicao "+i);
        No atual = hash[i].primeiro;
        
        while(atual != null) {
          System.out.print("["+atual.getValor()+"]");
          atual = atual.getProximo();
        }
        System.out.print("\n\n");
      }
    }
  }

	public static void main(String [] args){
    ListaLigada[] hash = new ListaLigada[8];
    inicializaHashing(hash); // Obrigatório

    adicionarVarios(hash, 279, 139, 43, 75, 27, 219, 407, 103, 123, 183, 235, 283, 231, 327, 539, 71);
    // adicionarVarios(hash, 279, 139, 103, 327, 71);

    imprimeHashing(hash);
  }
}
