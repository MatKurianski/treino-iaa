public class Main {
  public static void main(String args[]) {
    Combinatoria c = new Combinatoria("MAK");
    c.arranjarEImprimir();
  } 
}

interface ICombinatoria { // Métodos que um usuário pode chamar.
  void arranjarEImprimir(int contador);
}

class Combinatoria implements ICombinatoria {
  Combinatoria(char[] palavra) {
    this.palavra = palavra;
  }

  Combinatoria(String palavra) { // Sobrecarga opcional #1.
    this.palavra = palavra.toCharArray();
  }

  private char[] palavra;

  public void arranjarEImprimir() { // Sobrecarga opcional #2.
    arranjarEImprimirAux(this.palavra.length, "");
  }

  public void arranjarEImprimir(int contador) {
    arranjarEImprimirAux(contador, "");
  } 

  private void arranjarEImprimirAux(int contador, String aux) {
    if(contador == 0) System.out.println(aux);
    else
      for(char letra : this.palavra)
        arranjarEImprimirAux(contador-1, aux+letra);
  } 
}