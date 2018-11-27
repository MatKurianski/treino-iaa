public class Main {
  public static void main(String args[]) {
    int[] array = {5, 8, 9, 8, 7, 4, 5, 6, 3, 6, 9, 8, 2, 3, 1, 4, 7};
    selectionSortRec(array, 0);
    imprimirArray(array);
  }

  public static void selectionSortRec(int[] array, int index) {
    int tamanho = array.length-1;
    if(index == tamanho) return;

    int k = menorValor(array, index);

    if(k != index) {
      int aux = array[k];
      array[k] = array[index];
      array[index] = aux;
    }

    selectionSortRec(array, index+1);
  }

  public static int menorValor(int[] array, int index) {
    int tamanho = array.length-1;
    if (index == tamanho) return index;

    int k = menorValor(array, index +1);
    return array[index] < array[k] ? index : k;
  }

  public static void imprimirArray(int[] array) {
    for(int elemento : array) System.out.print(elemento+" ");
  }
}