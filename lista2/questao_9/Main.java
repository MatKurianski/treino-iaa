import java.util.Random;
public class Main {
  public static void main(String args[]) {
    int amostra[] = {5, 8, 9, 1, 4, 23, 11, 14};
    int numero = amostra[new Random().nextInt(amostra.length)];
    int indiceProcurado = buscarNumeroRec(amostra, numero, 0, amostra.length-1);

    System.out.println("Numero escolhido: "+numero);
    System.out.println("Indice achado: "+indiceProcurado);
  }

  public static int buscarNumeroRec(int[] array, int numero, int inicio, int fim) {
    if(inicio == fim) return -1;

    int meio = (inicio+fim)/2;
    if(array[inicio] == numero) return inicio;
    if(array[meio] == numero) return meio;
    if(array[fim] == numero) return fim;

    int valor = buscarNumeroRec(array, numero, inicio, meio);
    if(valor == -1) valor = buscarNumeroRec(array, numero, meio+1, fim);

    return valor;
  }
}