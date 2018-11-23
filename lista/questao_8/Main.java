/*
  Se eu entendi, é isso.
*/

public class Main {
  public static void main(String args[]) {
    int arrayzin[] = {1, 4, 6, 9, 8, 10, 7, 11, 15, 20, 19, 17, 14, 13};
    System.out.println(buscarNumero(arrayzin, 11));
  }

  static int buscarNumero(int[] array, int numero) {
    return buscarNumeroAux(array, numero, 0);
  }

  static int buscarNumeroAux(int[] array, int numero, int index) {
    if(array[index] == numero) return index;
    if(array.length-1 == index) return -1;
    return buscarNumeroAux(array, numero, index+1);
  }
}