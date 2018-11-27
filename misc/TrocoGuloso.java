import java.util.ArrayList;

public class TrocoGuloso {
  public static ArrayList<Integer> trocarMoedas(int valor) {
    ArrayList<Integer> troco = new ArrayList();
    int moedas[] = {100, 50, 25, 5, 1};

    for(int moeda : moedas) {
      while(valor >= moeda) {
        valor = valor-moeda;
        troco.add(moeda);
      }
    }
    return troco;
  }

  public static void imprimirTroco(ArrayList<Integer> troco) {
    for(int elemento : troco) System.out.println(elemento);
  }

  public static void main(String args[]) {
    imprimirTroco(trocarMoedas(183));
  }
}
